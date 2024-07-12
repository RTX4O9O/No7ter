package me.rtx4090.no7ter.hackerdetector.data;

import me.rtx4090.no7ter.hackerdetector.checks.*;
import me.rtx4090.no7ter.hackerdetector.utils.Vector2D;
import me.rtx4090.no7ter.hackerdetector.utils.ViolationLevelTracker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class PlayerDataSamples {

    // Existing fields...

    /** Used to ensure we check each player only once per tick, since the World#playerEntities list might contain duplicates */
    public boolean checkedThisTick;
    /** Amount of ticks the player has spent on ground */
    public int onGroundTime;
    /** Amount of ticks the player has spent in air */
    public int airTime;
    /** Amount of ticks since the player started sprinting */
    public int sprintTime = 0;
    /** Amount of ticks since the player has been using an item */
    public int useItemTime = 0;
    /** Amount of ticks since the player started eating */
    public int timeEating = 0;
    /** Amount of ticks since the player finished eating something */
    public int lastEatTime = 50;
    /** True if the item in use is food or potion or milk bucket */
    public boolean usedItemIsConsumable = false;
    /** True when we receive a swing packet from this entity during the last tick */
    public boolean hasSwung = false;
    public final SampleListZ swingList = new SampleListZ(20);
    /** Info about attack that happened this tick if any */
    public AttackInfo attackInfo;
    public final SampleListZ attackList = new SampleListZ(20);
    /** Last time the player broke a block */
    public long lastBreakBlockTime = System.currentTimeMillis();
    public SampleListF breakTimeRatio = new SampleListF(8);

    /* ----- Samples of rotations/positions interpolated by the client ----- */
    public final SampleListD posXList = new SampleListD(10);
    public final SampleListD posYList = new SampleListD(10);
    public final SampleListD posZList = new SampleListD(10);
    public final SampleListD speedXList = new SampleListD(5);
    public final SampleListD speedYList = new SampleListD(5);
    public final SampleListD speedZList = new SampleListD(5);
    /* ----- Client samples end ----- */

    /* ----- Samples of rotations/positions received from the server ----- */
    private int serverUpdates;
    public final SampleListI serverUpdatesList = new SampleListI(20);
    public final SampleListD serverPosXList = new SampleListD(5);
    public final SampleListD serverPosYList = new SampleListD(5);
    public final SampleListD serverPosZList = new SampleListD(5);
    /** Yaw of the player's body [-180, 180] */
    public final SampleListF serverYawList = new SampleListF(5);
    /** Pitch of the player's head [-90, 90] */
    public final SampleListF serverPitchList = new SampleListF(5);
    /** Yaw of the player's head [-180, 180], directly equals to player.rotationYawHead */
    public final SampleListF serverYawHeadList = new SampleListF(5);
    /* ----- Server samples end ----- */

    public final ViolationLevelTracker autoblockAVL = AutoblockCheck.newVL();
    public final ViolationLevelTracker fastbreakVL = FastbreakCheck.newVL();
    public final ViolationLevelTracker keepsprintAVL = KeepSprintACheck.newVL();
    public final ViolationLevelTracker keepSprintBVL = KeepSprintBCheck.newVL();
    public final ViolationLevelTracker killAuraAVL = KillAuraACheck.newVL();
    public final ViolationLevelTracker killAuraBVL = KillAuraBCheck.newVL();
    public final ViolationLevelTracker noSlowdownVL = NoSlowdownCheck.newVL();
    public final ViolationLevelTracker scaffoldVL = ScaffoldCheck.newVL();
    public final ViolationLevelTracker nukerVL = NukerCheck.newVL();
    public final ViolationLevelTracker longjumpVL = LongJumpCheck.newVL();

    // New field to store the target block position
    private BlockPos targetBlockPos;



    public void onTickStart() {
        this.checkedThisTick = false;
        this.hasSwung = false;
        this.attackInfo = null;
        this.serverUpdates = 0;
    }

    public void onTick(EntityPlayer player) {
        this.checkedThisTick = true;
        this.onGroundTime = player.onGround ? this.onGroundTime + 1 : 0;
        this.airTime = player.onGround ? 0 : this.airTime + 1;
        this.sprintTime = player.isSprinting() ? this.sprintTime + 1 : 0;
        final boolean isUsingItem = player.isEating() && player.getHeldItem() != null && player.getHeldItem().getMaxItemUseDuration() > 0;
        if (!isUsingItem && this.usedItemIsConsumable && this.useItemTime > 25) {
            this.lastEatTime = 0;
        }
        this.lastEatTime++;
        if (isUsingItem) {
            this.usedItemIsConsumable = player.getHeldItem().getMaxItemUseDuration() == 32;
            this.useItemTime = this.useItemTime + 1;
            this.timeEating = this.usedItemIsConsumable ? this.timeEating + 1 : 0;
        } else {
            this.useItemTime = 0;
            this.timeEating = 0;
        }
        this.swingList.add(this.hasSwung);
        this.attackList.add(this.hasAttacked());
        this.posXList.add(player.posX);
        this.posYList.add(player.posY);
        this.posZList.add(player.posZ);
        this.speedXList.add((player.posX - player.lastTickPosX) * 20D);
        this.speedYList.add((player.posY - player.lastTickPosY) * 20D);
        this.speedZList.add((player.posZ - player.lastTickPosZ) * 20D);
        this.serverUpdatesList.add(this.serverUpdates);
    }

    public void onPostChecks() {
        if (this.attackInfo != null) this.attackInfo.target = null;
    }

    public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
        this.serverUpdates++;
        this.serverPosXList.add(x);
        this.serverPosYList.add(y);
        this.serverPosZList.add(z);
        this.serverYawList.add(yaw);
        this.serverPitchList.add(pitch);
    }

    public void setRotationYawHead(float yawHead) {
        this.serverYawHeadList.add(yawHead);
    }

    /** True if the player has attacked another player during this tick */
    public boolean hasAttacked() {
        return this.attackInfo != null && !this.attackInfo.multiTarget;
    }

    /** True if the player has attacked another player during this tick, and we found the target */
    public boolean hasAttackedTarget() {
        return this.attackInfo != null && !this.attackInfo.multiTarget && this.attackInfo.target != null;
    }

    /** True if the player's position in the XZ plane is identical to the last tick */
    public boolean isNotMovingXZ() {
        return this.speedXList.get(0) == 0D && this.speedZList.get(0) == 0D;
    }

    public double getSpeedXZ() {
        final double vx = this.speedXList.get(0);
        final double vz = this.speedZList.get(0);
        return Math.sqrt(vx * vx + vz * vz);
    }

    public double getSpeedXZSq() {
        final double vx = this.speedXList.get(0);
        final double vz = this.speedZList.get(0);
        return vx * vx + vz * vz;
    }

    public Vec3 getPositionEyesServer(EntityPlayer player) {
        return new Vec3(this.serverPosXList.get(0), this.serverPosYList.get(0) + (double) player.getEyeHeight(), this.serverPosZList.get(0));
    }

    public Vec3 getLookServer() {
        return getVectorForRotation(this.serverPitchList.get(0), this.serverYawHeadList.get(0));
    }

    public double getMoveLookAngleDiff() {
        return MathHelper.wrapAngleTo180_double(new Vector2D(this.speedZList.get(0), -this.speedXList.get(0)).getOrientedAngle() - this.serverYawHeadList.get(0));
    }

    /**
     * Creates a Vec3 using the pitch and yaw of the entities' rotation.
     */
    private static Vec3 getVectorForRotation(float pitch, float yaw) {
        final float f = MathHelper.cos(-yaw * 0.017453292F - (float) Math.PI);
        final float f1 = MathHelper.sin(-yaw * 0.017453292F - (float) Math.PI);
        final float f2 = -MathHelper.cos(-pitch * 0.017453292F);
        final float f3 = MathHelper.sin(-pitch * 0.017453292F);
        return new Vec3(f1 * f2, f3, f * f2);
    }

    /**
     * Determines if the player is breaking a block through other blocks.
     * Assumes targetBlockPos is set to the position of the block being broken.
     */
    public boolean isBreakingBlockThroughOtherBlocks(World world, EntityPlayer player) {
        if (this.targetBlockPos == null) {
            return false;
        }

        Vec3 playerEyesPos = new Vec3(player.posX, player.posY + player.getEyeHeight(), player.posZ);
        Vec3 targetBlockVec = new Vec3(targetBlockPos.getX() + 0.5, targetBlockPos.getY() + 0.5, targetBlockPos.getZ() + 0.5);

        // Perform ray trace from player's eyes to the target block
        for (double t = 0; t <= 1.0; t += 0.1) {
            double x = playerEyesPos.xCoord + t * (targetBlockVec.xCoord - playerEyesPos.xCoord);
            double y = playerEyesPos.yCoord + t * (targetBlockVec.yCoord - playerEyesPos.yCoord);
            double z = playerEyesPos.zCoord + t * (targetBlockVec.zCoord - playerEyesPos.zCoord);
            BlockPos pos = new BlockPos(x, y, z);
            Block block = world.getBlockState(pos).getBlock();
            if (block != Blocks.air && !(block instanceof BlockBed)) {
                return true; // Player is breaking through another block
            }
        }
        return false;
    }

    /**
     * Sets the target block position. This method should be called whenever the player starts breaking a block.
     */
    public void setTargetBlockPos(BlockPos targetBlockPos) {
        this.targetBlockPos = targetBlockPos;
    }

    public boolean isBreakingBlockThroughOtherBlocks() {
        return false;
    }
private double lastPosX, lastPosZ;
private double jumpStartPosX, jumpStartPosZ;
private boolean isJumping;

// Call this method when the player starts jumping
public void startJump(double posX, double posZ) {
    this.jumpStartPosX = posX;
    this.jumpStartPosZ = posZ;
    this.isJumping = true;
}

// Call this method when the player lands
public void endJump(double posX, double posZ) {
    if (isJumping) {
        this.lastPosX = posX;
        this.lastPosZ = posZ;
        this.isJumping = false;
    }
}

// Calculate the horizontal distance covered during the jump
public double getJumpDistance() {
    if (!isJumping) {
        double deltaX = lastPosX - jumpStartPosX;
        double deltaZ = lastPosZ - jumpStartPosZ;
        return Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
    }
    return 0;
 }
}
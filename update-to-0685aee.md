# Updating to commit [`0685aee`](https://github.com/Polyfrost/OneConfigExampleMod/commit/0685aee63b98910b151ed1006564a5cfbdd3deff)

If you don't care to check the commit and manually apply everything, here are all the changes we made in that commit:

## build.gradle.kts

<img width="1459" alt="Screenshot 2024-07-06 at 9 19 02 PM" src="https://github.com/Polyfrost/OneConfigExampleMod/assets/45589059/6f9ac025-3a7e-4caf-8a22-a503bb38f4dc">

Updates and forces OneConfig Wrapper (what is used to download and load OneConfig automatically) to 1.0.0-beta17 (fixes SSL / antivirus detections)

## src/main/resources/mixins.examplemod.json

<img width="1455" alt="Screenshot 2024-07-06 at 9 20 43 PM" src="https://github.com/Polyfrost/OneConfigExampleMod/assets/45589059/f74ccf61-d9b0-4fc1-b54f-de293f45ec51">

Fixes the mixin json refmap not reflecting the mod id that is set in `gradle.properties`.

## settings.gradle.kts

<img width="1444" alt="Screenshot 2024-07-06 at 9 31 14 PM" src="https://github.com/Polyfrost/OneConfigExampleMod/assets/45589059/8ae60c6a-c601-4091-9885-86942891959a">

Updates PGT and Loom to 0.6.4

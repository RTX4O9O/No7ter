package org.redthsgayclub.no7ter.utils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class ClipboardUtil {

    public static void copyString(String msg) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(msg), null);
    }

}

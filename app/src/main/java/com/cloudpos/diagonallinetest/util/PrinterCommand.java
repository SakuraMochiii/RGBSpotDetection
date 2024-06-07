
package com.cloudpos.diagonallinetest.util;

public class PrinterCommand {

    /**
     * Print the data in the printer buffer, then feed paper for one line according to the current line space settings.
     * After printing, the print position moves to the beginning of the line.
     *
     * @return
     */
    static public byte[] getCmdLf() {
        return new byte[]{
                (byte) 0x0A
        };
    }

    /**
     * Move the print position to the next tab position.
     *
     * @return
     */
    static public byte[] getCmdHt() {
        return new byte[]{
                (byte) 0x09
        };
    }

    /**
     * Not supported.
     *
     * @return
     */
    static public byte[] getCmdFf() {
        return new byte[]{
                (byte) 0x0c
        };
    }

    /**
     * Print the data in the printer buffer and feed paper for n dots.
     *
     * @param n 0-255
     * @return
     */
    static public byte[] getCmdEscJN(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x4A, (byte) n
        };
    }

    /**
     * Not supported.
     *
     * @return
     */
    static public byte[] getCmdEscFf() {
        return new byte[]{
                (byte) 0x1b, (byte) 0x0c
        };
    }

    /**
     * Print the data in the printer buffer and feed paper for n lines.
     *
     * @param n 0-255
     * @return
     */
    static public byte[] getCmdEscDN(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x64, (byte) n
        };
    }

    /**
     * Not supported.
     */
    static public byte[] getCmdSetSmallFont_CN() {
        return new byte[]{
                (byte) 0x1C, (byte) 0x21, (byte) 0x01
        };
    }

    /**
     * Not supported.
     */
    static public byte[] getCmdCancelSmallFont_CN() {
        return new byte[]{
                (byte) 0x1C, (byte) 0x21, (byte) 0x00
        };
    }

    /**
     * Not supported.
     */
    static public byte[] getCmdSetSmallFont_EN() {
        return new byte[]{
                (byte) 0x1B, (byte) 0x21, (byte) 0x01
        };
    }

    /**
     * Not supported.
     */
    static public byte[] getCmdCancelSmallFont_EN() {
        return new byte[]{
                (byte) 0x1B, (byte) 0x21, (byte) 0x00
        };
    }

    /**
     * Not supported.
     *
     * @param n :0,1
     * @return
     */
    static public byte[] getCmdEscN(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x3d, (byte) n
        };
    }


    /**
     * Set the line space to a default value 3mm(24×0.125mm).
     *
     * @return
     */
    static public byte[] getCmdEsc2() {
        return new byte[]{
                (byte) 0x1B, (byte) 0x32
        };
    }

    /**
     * Set the line space to n dots.
     *
     * @param n :0-255
     * @return
     */
    static public byte[] getCmdEsc3N(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x33, (byte) n
        };
    }

    /**
     * Set the print alignment mode(left, center or right)
     *
     * @param n :0 ≤ n ≤ 2  or 48 ≤ n ≤ 50
     * @return
     */
    static public byte[] getCmdEscAN(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x61, (byte) n
        };
    }

    /**
     * Not supported.
     *
     * @param nL
     * @param nH
     * @return
     */
    static public byte[] getCmdGsLNlNh(int nL, int nH) {
        return new byte[]{
                (byte) 0x1D, (byte) 0x4c, (byte) nL, (byte) nH
        };
    }

    /**
     * Set the absolute print position.
     * Moves the print position to a location in a distance of (nL + nH × 256) dots from the starting position for printing.
     *
     * @param nL
     * @param nH
     * @return
     */
    static public byte[] getCmdEsc$NlNh(int nL, int nH) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x24, (byte) nL, (byte) nH
        };
    }


    /**
     * Set the font type (italic, border, bold, double width, double height, inverse or underline).
     *
     * @param n <p>
     *          <ul>
     *          <li> bit0, 0-Character type A (12×24) 1-Character type B (9×17)
     *          <li> bit1-bit3, reserved
     *          <li> bit4, 0- Double-height mode off, 1-Double-height mode on
     *          <li> bit5, 0- Double-width mode off, 1-Double-width mode on
     *          <li> bit6, reserved
     *          <li> bit7, 0- Underline mode off, 1-Underline mode on
     *          </ul>
     *          <p/>
     * @return
     */
    static public byte[] getCmdEsc_N(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x21, (byte) n
        };
    }

    /**
     * Select character size.
     * Character height is set by the bit0~bit3 of n, and character width is set by bit4~bit7 of n
     *
     * @param n <p>
     *          <ul>
     *          <li> Set character height: hex value: 00, 01, 02, 03, 04, 05, 06, 07
     *          <li> Set Character width： 00， 10， 20， 30， 40， 50，60， 70
     *          </ul>
     *          <p/>
     * @return
     */
    static public byte[] getCmdGs_N(int n) {
        return new byte[]{
                (byte) 0x1D, (byte) 0x21, (byte) n
        };
    }

    /**
     * Turns bold mode on or off using n as follows:
     * If n = 0, turn off the bold, if n = 1, turn on the bold.
     *
     * @param n
     * @return
     */
    static public byte[] getCmdEscEN(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x45, (byte) n
        };
    }

    /**
     * Set the right right-side character space is [n×0.125mm].
     * For double width mode, the character right margin is double than normal mode.
     *
     * @param n
     * @return
     */
    static public byte[] getCmdEscSpN(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x20, (byte) n
        };
    }

    /**
     * Set the line space to a default value 3mm(24×0.125mm).
     *
     * @return
     */
    static public byte[] getCmdEscSo() {
        return new byte[]{
                (byte) 0x1B, (byte) 0x0E
        };
    }

    /**
     * Turn off double width mode
     *
     * @return
     */
    static public byte[] getCmdEscDc4() {
        return new byte[]{
                (byte) 0x1B, (byte) 0x14
        };
    }

    /**
     * Turn upside-down printing mode on/off
     *
     * @param n 0 Upside-down print mode is turned off
     *          1 Upside-down print mode is turned on
     * @return
     */
    static public byte[] getCmdEsc__N(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x7B, (byte) n
        };
    }

    /**
     * Turn black/white inverse printing mode on/off
     *
     * @param n 0 Black/white inverse printing mode is turned off
     *          1 Black/white inverse printing mode is turned on
     * @return
     */
    static public byte[] getCmdGsBN(int n) {
        return new byte[]{
                (byte) 0x1D, (byte) 0x42, (byte) n
        };
    }

    /**
     * Turns underline mode on or off
     *
     * @param n 0, 48 Turns off underline mode
     *          1, 49 Turns on underline mode (1-dot thick)
     *          2， Turns on underline mode (2-dots thick)
     * @return
     */
    static public byte[] getCmdEsc___N(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x2D, (byte) n
        };
    }

    /**
     * Not supported.
     *
     * @param n
     * @return
     */
    static public byte[] getCmdEsc____N(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x25, (byte) n
        };
    }


    /**
     * Not supported.
     *
     * @param n
     * @return
     */
    static public byte[] getCmdEsc_____N(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x25, (byte) n
        };
    }

    /**
     * Select international character.
     *
     * @param n 8:Japan 15:China 101:ISO-8859-1 102:ISO-8859-2
     *          103:ISO-8859-3 104:ISO-8859-4 105:ISO-8859-5
     *          107:ISO-8859-7 109:ISO-8859-9 113：ISO-8859-13
     *          115：ISO-8859-15 130：GB13030-2000
     * @return
     */
    static public byte[] getCmdEscRN(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x52, (byte) n
        };
    }

    /**
     * Select character code table.
     * Suggest to use 1B 52 command.
     *
     * @param n
     * @return
     */
    static public byte[] getCmdEscTN(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x74, (byte) n
        };
    }


    /**
     * Not supported.
     *
     * @param n
     * @return
     */
    static public byte[] getCmdEscC5N(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x63, (byte) 0x35, (byte) n
        };
    }

    /**
     * Initialize the printer。
     * Reset the printer, the print mode reset to the default setting.
     *
     * @return
     */
    static public byte[] getCmdEsc_() {
        return new byte[]{
                (byte) 0x1B, (byte) 0x40
        };
    }

    /**
     * Not supported.
     *
     * @param n
     * @return
     */
    static public byte[] getCmdEscVN(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x76, (byte) n
        };
    }

    /**
     * Not supported.
     *
     * @param n
     * @return
     */
    static public byte[] getCmdGsAN(int n) {
        return new byte[]{
                (byte) 1D, (byte) 61, (byte) n
        };
    }

    /**
     * Not supported.
     *
     * @param n
     * @return
     */
    static public byte[] getCmdEscUN(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x75, (byte) n
        };
    }

    /**
     * 2 blank characters.
     *
     * @return
     */
    static public byte[] getCustomTabs() {
        return "  ".getBytes();
    }

    /**
     * Not supported.
     */
    static public byte[] getCmdCutPaper() {
        return new byte[]{
                (byte) 0x1B, (byte) 0x69
        };
    }

    /**
     * Turns bold mode on or off
     *
     * @param n If n = 0, turn off the bold, if n = 1, turn on the bold.
     */
    static public byte[] getCmdBold(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x45, (byte) n
        };
    }

    /**
     * Not supported.
     */
    static public byte[] getCmdBoldFontSmall() {
        return new byte[]{
                (byte) 0x1B, (byte) 0x21, 9, (byte) 0x1C, (byte) 0x21, 1
        };
    }

    /**
     * Not supported.
     */
    static public byte[] getCmdBoldFontMedium() {
        return new byte[]{
                (byte) 0x1B, (byte) 0x21, 8, (byte) 0x1C, (byte) 0x21, 0
        };
    }

    /**
     * Turn black/white inverse printing mode on/off
     *
     * @param n 0 Black/white inverse printing mode is turned off
     *          1 Black/white inverse printing mode is turned on
     */
    static public byte[] getCmdReverse(int n) {
        return new byte[]{
                (byte) 0x1D, (byte) 0x42, (byte) n
        };
    }

    /**
     * Turn upside-down printing mode on/off
     *
     * @param n 0 Upside-down print mode is turned off
     *          1 Upside-down print mode is turned on
     */
    static public byte[] getCmdInversion(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x7B, (byte) n
        };
    }

    /**
     * Not supported.
     *
     * @param n
     */
    static public byte[] getCmdSmallFontCN(int n) {
        return new byte[]{
                (byte) 0x1C, (byte) 0x21, (byte) n
        };
    }

    /**
     * @param n 0: Character type A (12×24)
     *          1: Character type B (9×17)
     */
    static public byte[] getCmdSmallFontEN(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x21, (byte) n
        };
    }

    /**
     * Select character size
     *
     * @param n = 0xAB
     *          <p>
     *          A 0<A<7, 1-8 times the width， 0 is normal.
     *          </p>
     *          <p>
     *          B 0<B<7, 1-8 times the height, 0 is normal.
     *          </p>
     */
    static public byte[] getCmdFontSize(int n) {
        return new byte[]{
                (byte) 0x1D, (byte) 0x21, (byte) n
        };
    }

    /**
     * Set the print alignment mode(left, center or right)
     *
     * @param n <p>
     *          n = 0, 48, left
     *          </p>
     *          <p>
     *          n = 1, 49, center
     *          </p>
     *          <p>
     *          n = 2, 50, right
     *          </p>
     */
    static public byte[] getCmdAlignType(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x61, (byte) n
        };
    }

    /**
     * Set the line space to n dots.
     *
     * @param n :0-255
     * @return
     */
    static public byte[] getCmdVerticalSpacing(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x33, (byte) n
        };
    }

    /**
     * Set the font type (italic, border, bold, double width, double height, inverse or underline).
     *
     * @param n <p>
     *          <ul>
     *          <li> bit0, 0-Character type A (12×24) 1-Character type B (9×17)
     *          <li> bit1-bit3, reserved
     *          <li> bit4, 0- Double-height mode off, 1-Double-height mode on
     *          <li> bit5, 0- Double-width mode off, 1-Double-width mode on
     *          <li> bit6, reserved
     *          <li> bit7, 0- Underline mode off, 1-Underline mode on
     *          </ul>
     *          <p/>
     * @return
     */
    static public byte[] getCmdType(int n) {
        return new byte[]{
                (byte) 0x1B, (byte) 0x21, (byte) n
        };
    }

    /**
     * Reset the printer, the print mode reset to the default setting.
     */
    public static byte[] getCmdClear() {
        return new byte[]{
                (byte) 0x1b, (byte) 0x40
        };
    }

    /**
     * Select print position of one-dimension HRI<br/>
     * HRI Human Readable Interpretation.
     *
     * @param n :
     *          n print position<br/>
     *          0,48 not print<br/>
     *          1,49 above the barcode<br/>
     *          2,50 below the barcode<br/>
     *          3,51 above and below the barcode<br/>
     *          **************************<br/>
     */
    public static byte[] getBarcodeHRILocation(int n) {
        return new byte[]{
                (byte) 0x1D, (byte) 0x48, (byte) n
        };
    }

    /**
     * Set height of one-dimension barcode.
     *
     * @param n : points in the vertical direction
     */
    public static byte[] getBarcodeHeight(byte n) {
        return new byte[]{
                0x1D, 0x68, n
        };
    }

    /**
     * Set width of one-dimension barcode.<br/>
     *
     * @param n n Set width of one-dimension barcode：<br/>
     *          ***********************************************************<br/>
     *          n     Multiple barcode unit widths(millimeter)     Binary barcode Narrow strip width(millimeter)     Binary barcode Wide strip width(millimeter)<br/>
     *          2     0.250     0.250     0.625<br/>
     *          3     0.375     0.375     1.000<br/>
     *          4     0.560     0.500     1.250<br/>
     *          5     0.625     0.625     1.625<br/>
     *          6     0.750     0.750     2.000<br/>
     *          Multiple barcode:<br/>
     *          UPC-A, UPC-E, JAN13 (EAN13), JAN8 (EAN8), CODE93, CODE128<br/>
     *          Binary barcode:：<br/>
     *          CODE39, ITF, CODABAR<br/>
     */
    public static byte[] getBarcodeWidth(byte n) {
        return new byte[]{
                0x1D, 0x77, n
        };
    }

    /**
     * Not supported.
     *
     * @param
     * @return
     * @throws
     */
    public static byte[] getBarcode(int barcodeType) {
        // dns = new byte[]{};
        byte[] cmds = new byte[]{
                0x1D, 0x6B, (byte) barcodeType
        };
        return cmds;
    }

    /**
     * Set left margin of one-dimension barcode
     *
     * @param n : 0-->255
     */
    public static byte[] getBarcodeLeftMargin(byte n) {
        return new byte[]{
                0x1d, 0x78, n
        };
    }

    /**
     * Query whether vendor printer
     * <p>
     * After calling write, calling read, if it can get data, it is the vendor printer.
     */
    public static byte[] getQueryVendorPrinter() {
        return new byte[]{
                0x1B, 0x41
        };
    }
}

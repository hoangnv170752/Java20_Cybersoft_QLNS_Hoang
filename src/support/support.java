package support;


import java.text.*;
import java.util.*;

import static java.lang.Character.*;
import static java.lang.Double.*;
import static java.lang.Integer.*;
import static java.lang.String.valueOf;
import static java.lang.System.*;
import static support.constant.*;

public class support {
    private static final Scanner mScan = new Scanner(in);

    public static boolean tryParseInt(String s) {
        var isSuccess = true;
        try {
            parseInt(s);
        } catch (Exception e) {
            isSuccess = false;
        }
        return isSuccess;
    }

    public static int scanInt() {
        var n = 0;
        var s = mScan.nextLine();
        if (tryParseInt(s)) {
            n = parseInt(s);
        } else {
            printAdv(RED, "Dữ liệu bạn nhập không phải số nguyên, xin nhập lại: ", RESET);
            n = scanInt();
        }
        return n;
    }

    public static int numLimit(int min, int max) {
        var n = scanInt();
        if (n < min || n > max) {
            printAdv(RED, "Không xác định, xin nhập lại: ", RESET);
            n = numLimit(min, max);
        }
        return n;
    }

    public static boolean tryParseDub(String s) {
        var isSuccess = true;
        try {
            parseDouble(s);
        } catch (Exception e) {
            isSuccess = false;
        }
        return isSuccess;
    }

    public static double scanDub() {
        var n = 0d;
        var s = mScan.nextLine();
        if (tryParseDub(s)) {
            n = parseDouble(s);
        } else {
            printAdv(RED, "Dữ liện bạn nhập không phải số, xin nhập lại: ", RESET);
            n = scanDub();
        }
        return n;
    }

    public static double numLimit(double min, double max) {
        var n = scanDub();
        if (n < min || n > max) {
            printAdv(RED, "Không xác định, xin nhập lại: ", RESET);
            n = numLimit(min, max);
        }
        return n;
    }
    public static String writePerfectDub(double n) {
        return n == (int) n ? String.valueOf((int) n) : String.valueOf(n);
    }

    public static void printAdv(String s) {
        for (var i = 1; i <= (WIDTH - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.print(s);
    }

    public static void printAdv(String colorStart, String s, String colorEnd) {
        for (var i = 1; i <= (WIDTH - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.print(colorStart + s + colorEnd);
    }

    public static void printlnAdv(String s) {
        for (var i = 1; i <= (WIDTH - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.println(s);
    }

    public static void printlnAdv(String color, String s) {
        for (var i = 1; i <= (WIDTH - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.println(color + s);
    }

    public static boolean isSpace(String s) {
        var isSuccess = true;
        for (var i = 0; i < s.length(); i++) {
            if (!isWhitespace(s.charAt(i))) {
                isSuccess = false;
                break;
            }
        }
        return isSuccess;
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean isNullOrWhitespace(String s) {
        return isNullOrEmpty(s) || isSpace(s);
    }

    public static String toTitleCase(String s) {
        var list = new ArrayList<Character>();
        var str = "";
        if (!isNullOrWhitespace(s)) {
            var cst = s.charAt(0);
            cst = isWhitespace(cst) ? cst : toUpperCase(cst);
            list.add(cst);
            for (var i = 0; i < s.length() - 1; i++) {
                var c = s.charAt(i + 1);
                if (isWhitespace(s.charAt(i)) && !isWhitespace(c)) {
                    list.add(toUpperCase(c));
                } else {
                    list.add(c);
                }
            }
            for (var item : list) {
                str += item;
            }
        }
        return str;
    }

    public static String toTitleCaseAdv(String s) {
        return isNullOrWhitespace(s) ? s : toTitleCase(s.toLowerCase());
    }

    public static int credit() {
        printlnAdv(PURPLE, "Bạn có muốn tiếp tục?");
        printlnAdv("1. Có   ");
        printlnAdv("2. Không");
        printAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        return numLimit(1, 2);
    }
}

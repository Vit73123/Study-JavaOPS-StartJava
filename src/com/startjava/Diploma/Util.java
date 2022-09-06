package com.startjava.Diploma;

import java.util.Scanner;

public class Util {

    public static boolean chooseYes(String message) {
        Scanner scan = new Scanner(System.in, "windows-1251");
        String yesNo;
        do {
            System.out.print(message + " [да / нет]: ");
            yesNo = scan.nextLine();
            if (yesNo.trim().equalsIgnoreCase("нет")) return false;
        } while (!yesNo.trim().equalsIgnoreCase("да"));
        return true;
    }

    public static String leftString (String str, int num) {
        return num > str.length() ? str : str.substring(0, num);
    }

    public static void printLine(String type, int len) {
        System.out.println(type.repeat(len));
    }
}

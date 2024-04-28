package com.project.project2;

import java.util.Scanner;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/12 下午 10:39
 * @Version 1.0
 */
public class CMUtility {
    private static Scanner sc = new Scanner(System.in);

    /**
     * 用於介面 menu的選擇，該方法讀取鍵盤，如果用戶輸入'1'~'5'中的任意字符，則方法返回
     *
     * @return 用戶輸入的字符
     */
    public static char readMenuSelection() {
        char c;
        while (true){
            String str = sc.next();
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' &&
                    c != '4' && c != '5') {
                System.out.print("輸入錯誤，請重新輸入:");
            } else break;
        }
        return c;
    }

    /**
     * 檢查是否要退出(y/n)，確認用戶是否輸入正確，並返回對應值
     * @return 如果用戶輸入的首字符為('y','Y'則 return 'y';)
     *                      首字符為('n','N'則 return 'n';)
     *                      首字符為(上述以外 則執行 loop;)
     */
    public static char doubleCheck(){
        char c;
        while (true) {
            String check = sc.next();
            c = check.charAt(0);
            if (c == 'y' || c == 'Y') {
                c = 'y';
                return c;

            } else if (c == 'n' || c == 'N') {
                c = 'n';
                return c;

            } else System.out.print("輸入錯誤，請重新輸入:");

        }
    }

    public static String readString(int limit){
        while (true) {
            String input = sc.next(); //sc.next有防輸入空白字符
            if (input.length() <= limit) {
                return input;
            }else System.out.println("請輸入低於"+limit+"個字元以下");
        }
    }

    public static String readString(int limit, String origin){
        while (true) {
            sc = new Scanner(System.in); //為了取消sc.nextLine()讀取回車，重新建立Scanner物件
            String input = sc.nextLine(); //sc.next有防輸入空白字符
            if (input.equals("")) {
                return origin;

            }else if (input.length() <= limit) {
                return input;
            }else System.out.println("請輸入低於"+limit+"個字元以下");
        }
    }

    public static char readChar(){
        String input = sc.next();
        char c = input.charAt(0);
        return c;
    }

    public static char readChar(char origin){
        String input = sc.nextLine();
        if (input.equals("")){
            return origin;
        }else {
            char c = input.charAt(0);
            return c;
        }
    }

    public static int readInt(){
        while (true) {
            boolean isInt = sc.hasNextInt();
            if (isInt) {
                int input = sc.nextInt();
                return input;
            } else {
                sc.next();
                System.out.print("錯誤，請輸入整數:");
            }
        }
    }

    public static int readInt(int origin){
        while (true) {
            String input = sc.nextLine();
            if (input.equals("")) {
                return origin;
            }

            if (input.matches("[0-9]+")) { //表示[0-9]至少出現一次的格式
                int num = Integer.parseInt(input);
                return num;

            } else {
                sc.next();
                System.out.print("錯誤，請輸入整數:");
            }
        }
    }

    public static String readGmail(){
        String pat = "[0-9a-zA-Z]{5,15}@gmail.com";
        while (true) {
            String input = sc.next();
            if (input.matches(pat)) {
                return input;

            } else if (input.equals("無")) {
                return input;

            } else System.out.print("格式錯誤，請輸入"+pat+"格式:");
        }
    }

    public static String readGmail(String origin){
        while (true) {
            String input = sc.nextLine();
            if (input.equals("")){
                return origin;
            }

            String pat = "[0-9a-zA-Z]{5,15}@gmail.com";

            if (input.matches(pat)) {
                return input;

            } else if (input.equals("無")) {
                return input;

            } else System.out.print("格式錯誤，請輸入"+pat+"格式:");
        }
    }
}


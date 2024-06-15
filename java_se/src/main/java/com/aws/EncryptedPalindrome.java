package com.aws;

public class EncryptedPalindrome {
    public static void main(String[] args) {
        System.out.println(findEncryptedPassword("babab"));//abbba
        System.out.println(findEncryptedPassword("ababa"));//ababa
        System.out.println(findEncryptedPassword("yxxy"));//xyyx
        System.out.println(findEncryptedPassword("ded"));//ded
    }

    public static String findEncryptedPassword(String password) {
        // 创建一个数组来存储每个字符的出现次数
        int[] arr = new int[26];
        for (char c : password.toCharArray()) {
            arr[c - 'a']++;
        }
        // 初始化左右部分和中间字符
        String l = "";
        String m = "";
        String r = "";
        // 遍历字符计数数组
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue; // 跳过未出现的字符
            char ch = (char) (i + 'a'); // 将索引转换为字符
            //如果字符出现次数为奇数，设置为中间字符，并减一使其变为偶数; 因为password本身就是回文，奇数的情况只会有一次
            if (arr[i] % 2 != 0) {
                m = String.valueOf(ch);
                arr[i]--;
            }
            // 将剩余的字符一半加到左边，一半加到右边
            for (int j = 0; j < arr[i] / 2; j++) {
                l = l + ch;
                r = ch + r;
            }
        }
        // 返回拼接后的字符串
        return l + m + r;
    }
}

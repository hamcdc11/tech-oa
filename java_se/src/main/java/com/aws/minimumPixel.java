package com.aws;

public class minimumPixel {
    public static void main(String[] args) {
        String image = "0100110";
        System.out.println(findMinimumOperations(image));  // 输出应为 3
    }

    public static int findMinimumOperations(String image) {
        // 反转输入字符串以获得目标序列
        String reverseImage = new StringBuilder(image).reverse().toString();

        // 初始化两个指针分别指向反转字符串和原字符串
        int i = 0;
        int j = 0;

        // 遍历两个字符串以找到匹配的字符
        while (i < reverseImage.length() && j < image.length()) {
            if (reverseImage.charAt(i) == image.charAt(j)) {
                i++;  // 如果字符匹配，移动反转字符串的指针
            }
            j++;  // 始终移动原字符串的指针
        }

        // 最小操作数是原字符串的长度减去最长匹配子序列的长度
        return image.length() - i;
    }

}

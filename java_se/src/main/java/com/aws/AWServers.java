package com.aws;

public class AWServers {
    public static void main(String[] args) {
        int[] arr1={3,4,1,6,2};//7
        int[] arr2={3,3,2,1};//2
        System.out.println(makePowerNonDecreasing(arr1));
        System.out.println(makePowerNonDecreasing(arr2));
    }

    public static int makePowerNonDecreasing(int[] power) {
        int res = 0;
        for (int i = 1; i < power.length; i++) {
            // 将之前累积的增加量加到当前元素
            power[i] += res;
            // 如果当前元素小于前一个元素
            if (power[i] < power[i - 1]) {
                // 计算需要增加的值
                int diff = power[i - 1] - power[i];
                // 更新总的增加量
                res += diff;
                // 更新当前元素的值
                power[i] += diff;
            }
        }

        return res;
    }
}

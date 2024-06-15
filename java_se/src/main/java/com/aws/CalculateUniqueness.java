package com.aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CalculateUniqueness {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(findMedianOfSubarrayUniqueness(arr));  // 输出应该是 1

        int[] arr1 = {1, 2, 1};
        System.out.println(findMedianOfSubarrayUniqueness(arr));  // 输出应该是 1

        int[] arr2 = {1, 1};
        System.out.println(findMedianOfSubarrayUniqueness(arr));  // 输出应该是 1
    }

    public static int findMedianOfSubarrayUniqueness(int[] arr) {
        int length = arr.length;
        int[] frequencyMap = new int[length + 1];
        List<Integer> frequencies = new ArrayList<>();

        for (int i = 0; i < length; ++i) {
            int currentFrequency = 0;
            Arrays.fill(frequencyMap, 0);

            for (int j = 0; j <= i; ++j) {
                if (frequencyMap[arr[j]] == 0) {
                    ++currentFrequency;
                }
                ++frequencyMap[arr[j]];
            }
            frequencies.add(currentFrequency);

            int l = 0;
            for (int r = i + 1; r < length; ++r) {
                if (frequencyMap[arr[r]] == 0) {
                    ++currentFrequency;
                }
                ++frequencyMap[arr[r]];

                if (frequencyMap[arr[l]] == 1) {
                    --currentFrequency;
                }
                --frequencyMap[arr[l]];
                ++l;
                frequencies.add(currentFrequency);
            }
        }

        Collections.sort(frequencies);
        int size = frequencies.size();
        if (size % 2 == 0) {
            return frequencies.get(size / 2 - 1);
        } else {
            return frequencies.get(size / 2);
        }
    }
}

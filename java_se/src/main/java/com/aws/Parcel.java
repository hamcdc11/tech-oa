package com.aws;

public class Parcel {
    public static void main(String[] args) {
        int[] weights = {8, 5, 4, 7, 2};
        System.out.println(maxNumberOfBalancedShipments(weights));

        int[] weights1 = {4, 7, 2, 7};
        System.out.println(maxNumberOfBalancedShipments(weights1));
    }

    public static int maxNumberOfBalancedShipments(int[] weights) {
        int maxWeight = -1;
        int shipments = 0;
        for (int weight : weights) {
            if (weight < maxWeight) {
                shipments++;  // End the current shipment and start a new one
                maxWeight = -1;  // Reset for the next shipment
            } else {
                maxWeight = Math.max(maxWeight, weight);  // Update the max weight
            }
        }
        // If the last parcel's weight is not the maximum, it can form a balanced shipment
        if (maxWeight != -1 && weights[weights.length - 1] != maxWeight) {
            shipments++;
        }
        return shipments;
    }
}

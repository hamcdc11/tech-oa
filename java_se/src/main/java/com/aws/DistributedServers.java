package com.aws;

import java.util.*;
import java.util.List;

public class DistributedServers {
    public static void main(String[] args) {
        // 测试用例
        int[] servers1 = {2, 6, 8};
        int totalServers1 = 8;
        System.out.println(getMinTime(totalServers1, servers1));  // 输出: 4

        int[] servers2 = {4, 6, 2, 9};
        int totalServers2 = 10;
        System.out.println(getMinTime(totalServers2, servers2));  // 输出: 7

        int[] servers3 = {1, 5};
        int totalServers3 = 5;
        System.out.println(getMinTime(totalServers3, servers3));  // 输出: 1
    }

    public static int minCost(List<Integer> path, int totalServers) {
        int cost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            int directDist = Math.abs(path.get(i + 1) - path.get(i));
            int wrapAroundDist = totalServers - directDist;
            cost += Math.min(directDist, wrapAroundDist);
        }

        return cost;
    }

    public static int getMinTime(int total_servers, int[] servers) {
        List<Integer> serverList = new ArrayList<>();
        for (int server : servers) {
            serverList.add(server);
        }
        Collections.sort(serverList);

        List<Integer> path1 = new ArrayList<>(serverList);
        List<Integer> path2 = new ArrayList<>();

        path2.add(serverList.get(0));
        for (int i = serverList.size() - 1; i >= 1; i--) {
            path2.add(serverList.get(i));
        }

        return Math.min(minCost(path1, total_servers), minCost(path2, total_servers));
    }
}

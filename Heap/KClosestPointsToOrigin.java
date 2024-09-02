package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, 
return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<Double, List<Integer>>> minHeap = new PriorityQueue<>(
            Comparator.comparingDouble(Map.Entry::getKey)
        );
        
        for (int[] point: points) {
            double distance = Math.sqrt(Math.pow(point[0] , 2) + Math.pow(point[1] , 2));
            Map<Double, List<Integer>> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(point[0]);
            list.add(point[1]);
            map.put(distance, list);
            minHeap.addAll(map.entrySet());
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = minHeap.remove().getValue().stream().mapToInt(Integer::intValue).toArray();
            res[i] = point;
        }
        return res;
    }
}

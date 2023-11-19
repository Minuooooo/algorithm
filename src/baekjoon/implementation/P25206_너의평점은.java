package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P25206_너의평점은 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Double> map = initializeMap();
        double sum = 0.0;
        double totalGrade = 0.0;

        for (int i = 0; i < 20; i++) {

            String[] arr = br.readLine().split(" ");

            if (arr[2].equals("P"))
                continue;

            totalGrade += Double.parseDouble(arr[1]);
            sum += (Double.parseDouble(arr[1]) * map.get(arr[2]));
        }

        System.out.println(sum / totalGrade);
    }

    static Map<String, Double> initializeMap() {

        Map<String, Double> map = new HashMap<>();

        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        return map;
    }
}
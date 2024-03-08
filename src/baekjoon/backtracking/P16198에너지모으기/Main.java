package baekjoon.backtracking.P16198에너지모으기;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static List<Integer> energyList = new ArrayList<>();
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            energyList.add(Integer.parseInt(st.nextToken()));
        }
        getMaxValue(0);
        System.out.println(max);
    }

    private static void getMaxValue(int energy) {
        if (energyList.size() == 2) {
            max = Math.max(max, energy);
            return;
        }
        for (int i = 1; i < energyList.size() - 1; i++) {
            energy += energyList.get(i - 1) * energyList.get(i + 1);
            int removedElement = energyList.remove(i);
            getMaxValue(energy);
            energyList.add(i, removedElement);
            energy -= energyList.get(i - 1) * energyList.get(i + 1);
        }
    }
}
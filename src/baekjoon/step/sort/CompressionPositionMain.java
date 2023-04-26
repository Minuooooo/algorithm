package baekjoon.step.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CompressionPositionMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] position = new int[N];
        int[] sortedPostion = new int[N];

        HashMap<Integer, Integer> rankingMap = new HashMap<>();

        for (int i = 0; i < N; i++)
            position[i] = sortedPostion[i] = scanner.nextInt();

        Arrays.sort(sortedPostion);

        int rank = 0;
        for (int v : sortedPostion) {
            if (!rankingMap.containsKey(v)) {
                rankingMap.put(v, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : position) {
            int ranking = rankingMap.get(key);
            sb.append(ranking).append(" ");
        }

        System.out.println(sb);
    }
}

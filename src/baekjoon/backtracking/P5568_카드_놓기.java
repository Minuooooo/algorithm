package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P5568_카드_놓기 {

    private static int n, k;
    private static int[] arr;
    private static boolean[] visited;
    private static int[] card;
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        card = new int[k];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        combination(0);

        System.out.println(set.size());
    }

    private static void combination(int depth) {

        if (depth == k) {

            addCombination();
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                card[depth] = arr[i];

                visited[i] = true;
                combination(depth + 1);

                visited[i] = false;
            }
        }
    }

    private static void addCombination() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            sb.append(card[i]);
        }

        set.add(sb.toString());
    }
}
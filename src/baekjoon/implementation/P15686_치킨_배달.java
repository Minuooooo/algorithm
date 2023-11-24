package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15686_치킨_배달 {

    static int N, M;
    static int[][] map;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> choice = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1)
                    house.add(new int[] {i, j});

                if (map[i][j] == 2)
                    chicken.add(new int[] {i, j});
            }
        }

        visited = new boolean[chicken.size()];

        backTracking(0, 0);

        System.out.println(result);
    }

    static void backTracking(int depth, int start) {

        if (depth == M) {

            int sum = 0;

            for (int[] h : house) {

                int min = Integer.MAX_VALUE;

                for (int[] c : choice) {

                    int distance = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(min, distance);
                }

                sum += min;
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {

            if (!visited[i]) {

                visited[i] = true;
                choice.add(chicken.get(i));

                backTracking(depth + 1, i + 1);

                choice.remove(choice.size() - 1);
                visited[i] = false;
            }
        }
    }
}
package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P2529_부등호 {

    static int k;
    static String[] sign = new String[10];
    static boolean[] visited = new boolean[10];
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        sign = new String[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken();
        }

        dfs(0, "");

        Collections.sort(list);

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    public static void dfs(int depth, String num) {

        if (depth == k + 1) {
            list.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {

            if (visited[i])
                continue;

            if (depth == 0 || check(num.charAt(depth - 1) - '0', i, sign[depth - 1])) {

                visited[i] = true;
                dfs(depth + 1, num + i);

                visited[i] = false;
            }
        }
    }

    public static boolean check(int a, int b, String str) {

        if (str.equals("<")) {
            if (a > b)
                return false;
        }

        if (str.equals(">")) {
            if (a < b)
                return false;
        }

        return true;
    }
}
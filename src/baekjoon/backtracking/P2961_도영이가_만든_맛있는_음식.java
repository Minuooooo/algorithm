package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2961_도영이가_만든_맛있는_음식 {

    private static int N;
    private static int[][] food;
    private static int[][] choice;
    private static int choiceCount;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        food = new int[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {

            choiceCount = i;
            choice = new int[i][2];

            combination(0, 0);
        }

        System.out.println(min);
    }

    private static void combination(int start, int depth) {

        if (depth == choiceCount) {

            min = Math.min(min, cal());
            return;
        }

        for (int i = start; i < N; i++) {

            choice[depth][0] = food[i][0];
            choice[depth][1] = food[i][1];

            combination(i + 1, depth + 1);
        }
    }

    private static int cal() {

        if (choiceCount == 1)
            return Math.abs(choice[0][0] - choice[0][1]);

        int mul = 1;
        int sum = 0;

        for (int i = 0; i < choiceCount; i++) {

            mul *= choice[i][0];
            sum += choice[i][1];
        }

        return Math.abs(mul - sum);
    }
}
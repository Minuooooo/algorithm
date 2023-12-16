package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16139_인간_컴퓨터_상호작용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] arr = new int[S.length() + 1][26];

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 0; j < 26; j++) {
                arr[i][j] = arr[i - 1][j];
            }

            arr[i][S.charAt(i - 1) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int alphabetIndex = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(arr[r + 1][alphabetIndex] - arr[l][alphabetIndex]).append("\n");
        }

        System.out.println(sb);
    }
}
package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888_연산자끼워넣기 {

    static int N;
    static int[] seq;
    static int[] operator = new int[4];  // 연산자
    static int min = Integer.MAX_VALUE;  // 21억
    static int max = Integer.MIN_VALUE;  // -21억

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        cal(seq[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void cal(int num, int idx) {  // 연산 결과 num, 다음 수를 가르키는 idx

        if(idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i < 4; i++) {

            if(operator[i] > 0) {

                operator[i]--;

                switch (i) {

                    case 0:
                        cal(num + seq[idx], idx + 1);
                        break;

                    case 1:
                        cal(num - seq[idx], idx + 1);
                        break;

                    case 2:
                        cal(num * seq[idx], idx + 1);
                        break;

                    case 3:
                        cal(num / seq[idx], idx + 1);
                }

                operator[i]++;  // 한 경우를 마친 뒤 연산자 수 복구
            }
        }
    }
}
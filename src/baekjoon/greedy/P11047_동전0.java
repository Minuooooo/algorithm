package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047_동전0 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 동전 종류
        int K = Integer.parseInt(st.nextToken());  // 가치의 합

        int[] coin = new int[N];

        for(int i = 0; i < N; i++) {  // 동전의 가치
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;  // 필요 동전 개수
        int coinIndex = N - 1;  // Greedy 기법 적용 (내림차순)

        while(K > 0) {  // Greedy 기법을 사용할 수 있을 때 까지

            if(K >= coin[coinIndex]) {

                count += K / coin[coinIndex];  // 해당 가치에 대한 동전 개수
                K %= coin[coinIndex];  // 가치의 합 차감

            } else
                coinIndex--;
        }

        System.out.println(count);
    }
}
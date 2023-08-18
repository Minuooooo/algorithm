package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305_주유소 {  // int 범위를 벗어날 수 있어서 long
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());  // 도시의 수
        long[] price = new long[N];  // 리터 당 가격
        long[] distance = new long[N + 1];  // 다음 도시로 이동할 거리

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        int city = 0;
        long minPrice = Integer.MAX_VALUE;  // 리터 당 가격의 최소
        long cost = 0;

        while(city < N - 1) {

            minPrice = Math.min(minPrice, price[city]);
            cost += distance[city] * minPrice;  // 비용 = 거리 * 리터 당 가격
            city++;
        }

        System.out.println(cost);
    }
}
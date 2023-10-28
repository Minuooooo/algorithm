package baekjoon.lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P12738_가장긴증가하는부분수열3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        list.add(-1000000001);

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            int val = Integer.parseInt(st.nextToken());

            if (list.get(list.size() - 1) < val)
                list.add(val);

            else {

                int left = 1;
                int right = list.size() - 1;

                while (left < right) {

                    int mid = (left + right) / 2;

                    if (list.get(mid) < val)
                        left = mid + 1;

                    else
                        right = mid;
                }

                list.set(right, val);
            }
        }

        System.out.println(list.size() - 1);
    }
}
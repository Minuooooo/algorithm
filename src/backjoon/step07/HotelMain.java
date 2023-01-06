package backjoon.step07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HotelMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int floor = 1;
            int room = 1;
            int count = 1;

            while (true) {
                if(count == N)
                    break;
                else {
                    floor++;
                    count++;
                    if (floor > H) {
                        floor = 1;
                        room++;
                    }
                }
            }
            if(room < 10)
                System.out.println(floor + "0" + room);
            else
                System.out.println(floor + "" + room);
        }
    }
}

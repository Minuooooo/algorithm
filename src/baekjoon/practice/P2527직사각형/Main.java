package baekjoon.practice.P2527직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2= Integer.parseInt(st.nextToken());
            if (x1 > p2 || p1 < x2 || y1 > q2 || q1 < y2)
                sb.append("d");
            else if ((x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2) || (x1 == p2 && y1 == q2))
                sb.append("c");
            else if (x1 == p2 || p1 == x2 || y1 == q2 || q1 == y2)
                sb.append("b");
            else
                sb.append("a");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
package baekjoon.step.math1;

import java.io.*;
import java.util.StringTokenizer;

public class SnailMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = (V - B) / (A - B);
        if((V - B) % (A - B) != 0)
            day++;

        bw.write(day + "\n");
        bw.flush();
        bw.close();
    }
}

package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1063_킹 {

    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int ky, kx;
    static int sy, sx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] init = br.readLine().split(" ");

        kx = init[0].charAt(0) - 'A';
        ky = init[0].charAt(1) - '0' - 1;

        sx = init[1].charAt(0) - 'A';
        sy = init[1].charAt(1) - '0' - 1;

        int N = Integer.parseInt(init[2]);

        for (int i = 0; i < N; i++) {

            String command = br.readLine();
            List<Integer> pos = move(ky, kx, command);

            if (!check(pos.get(0), pos.get(1)))
                continue;

            if (pos.get(0) == sy && pos.get(1) == sx) {

                List<Integer> sPos = move(sy, sx, command);

                if (check(sPos.get(0), sPos.get(1))) {

                    sy = sPos.get(0);
                    sx = sPos.get(1);

                    ky = pos.get(0);
                    kx = pos.get(1);
                }
            }

            else {

                ky = pos.get(0);
                kx = pos.get(1);
            }
        }

        sb.append((char) (kx + 'A')).append(ky + 1).append("\n");
        sb.append((char) (sx + 'A')).append(sy + 1);
        System.out.println(sb);
    }

    public static List<Integer> move(int y, int x, String c) {

        int nx = 0;
        int ny = 0;

        List<Integer> pos = new ArrayList<>();

        switch (c) {

            case "R":
                ny = y + dy[0];
                nx = x + dx[0];
                break;

            case "L":
                ny = y + dy[1];
                nx = x + dx[1];
                break;

            case "B":
                ny = y + dy[2];
                nx = x + dx[2];
                break;

            case "T":
                ny = y + dy[3];
                nx = x + dx[3];
                break;

            case "RT":
                ny = y + dy[4];
                nx = x + dx[4];
                break;

            case "LT":
                ny = y + dy[5];
                nx = x + dx[5];
                break;

            case "RB":
                ny = y + dy[6];
                nx = x + dx[6];
                break;

            case "LB":
                ny = y + dy[7];
                nx = x + dx[7];
                break;
        }

        pos.add(ny);
        pos.add(nx);

        return pos;
    }

    public static boolean check(int y, int x) {

        if (y < 0 || y >= 8 || x < 0 || x >= 8)
            return false;

        return true;
    }
}
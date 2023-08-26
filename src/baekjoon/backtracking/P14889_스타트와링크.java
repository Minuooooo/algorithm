package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889_스타트와링크 {

    static int N;
    static int[][] S;
    static boolean[] isVisited;  // 스타트, 링크 팀 구분
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        isVisited = new boolean[N];

        for(int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        startOrLink(0, 0);
        System.out.println(min);
    }

    static void startOrLink(int idx, int condition) {  // 스타트, 링크 팀을 나누는 모든 경우 탐색

        if(condition == N / 2) {  // 팀이 나눠졌을 경우
            gap();
            return;
        }

        for(int i = idx; i < N; i++) {

            if(!isVisited[i]) {

                isVisited[i] = true;  // 스타트 팀
                startOrLink(i + 1, condition + 1);
                isVisited[i] = false;  // 한 가지 경우 탐색 후 초기화
            }
        }
    }

    static void gap() {  // 스타트, 링크 팀의 능력치 차이

        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {

                if (isVisited[i] && isVisited[j]) {  // 스타트 팀
                    start += S[i][j];
                    start += S[j][i];
                }

                else if (!isVisited[i] && !isVisited[j]) {  // 링크 팀
                    link += S[i][j];
                    link += S[j][i];
                }
            }
        }

        int val = Math.abs(start - link);

        if(val == 0) {  // 스타트, 링크 팀의 능력치 차이가 0이라면 최소이므로 종료
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(val, min);  // 경우마다 능력치 차이 갱신
    }
}
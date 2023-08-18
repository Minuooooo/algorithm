package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1931_회의실배정 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 회의 수
        int[][] meeting = new int[N][2];  // 회의 시간

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, (o1, o2) -> {
            if(o1[1] == o2[1])  // 회의 종료 시간이 같을 때는 시작 시간을 기준으로 오름차순 정렬
                return o1[0] - o2[0];

            return o1[1] - o2[1];
        });

        int selectedMeeting = 0;  // 선택된 회의
        int comparedMeeting = 1;  // 시작 시간을 비교할 회의
        int count = 1;  // 회의 수

        while(comparedMeeting < N) {

            if(meeting[comparedMeeting][0] >= meeting[selectedMeeting][1]) {  // 선택된 회의 종료 시간과 비교할 회의의 시작 시간 비교
                count++;
                selectedMeeting = comparedMeeting;  // 선택된 회의 갱신
            }

            comparedMeeting++;
        }

        System.out.println(count);
    }
}
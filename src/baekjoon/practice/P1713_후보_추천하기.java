package baekjoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P1713_후보_추천하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int recommend = Integer.parseInt(br.readLine());
        int[] student = new int[101];
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < recommend; i++) {
            int recommendedStudent = Integer.parseInt(st.nextToken());

            if(list.size() < N) {
                if (list.contains(recommendedStudent)) {
                    student[recommendedStudent]++;
                    continue;
                }

                list.add(recommendedStudent);
                student[recommendedStudent] = 1;
                continue;
            }

            if (list.contains(recommendedStudent)) {
                student[recommendedStudent]++;
                continue;
            }

            int minRecommend = 1_001;
            int removedStudent = 0;
            int removedIndex = 0;

            for (int j = 0; j < N; j++) {
                if (student[list.get(j)] < minRecommend) {
                    minRecommend = student[list.get(j)];
                    removedStudent = list.get(j);
                    removedIndex = j;
                }
            }

            list.remove(removedIndex);
            student[removedStudent] = 0;
            list.add(recommendedStudent);
            student[recommendedStudent] = 1;
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        for (int photoStudent : list) {
            sb.append(photoStudent).append(" ");
        }

        System.out.println(sb);
    }
}
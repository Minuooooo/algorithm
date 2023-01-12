package backjoon.step10;

import java.util.Scanner;

public class AgeSortMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        StringBuilder[] member = new StringBuilder[201];

        for (int i = 0; i < 201; i++) {
            member[i] = new StringBuilder();
        }

        for (int i = 0; i < N; i++) {
            int age = scanner.nextInt();
            String name = scanner.next();

            member[age].append(age).append(" ").append(name).append("\n"); //age를 index로 하여 member[]에 string 생성
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder value : member) {
            sb.append(value);
        }
        System.out.println(sb);
    }
}

package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1158_요세푸스_문제 {

    private static int N, K;
    private static List<Integer> person = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        for (int i = 1; i <= N; i++) {
            person.add(i);
        }

        sb.append("<");

        remove();

        sb.append(">");

        System.out.println(sb);
    }

    private static void remove() {

        int removedIndex = K - 1;

        while (!person.isEmpty()) {

            if (removedIndex >= person.size()) {

                removedIndex -= person.size();
                continue;
            }

            if (person.size() != 1)
                sb.append(person.get(removedIndex)).append(", ");

            else
                sb.append(person.get(removedIndex));

            person.remove(removedIndex);
            removedIndex += (K - 1);
        }
    }
}
package baekjoon.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P11723_집합 {

    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {

            String input = br.readLine();
            String operator = input.split(" ")[0];

            switch (operator) {

                case "add" :
                    add(Integer.parseInt(input.split(" ")[1]));
                    break;

                case "remove" :
                    remove(Integer.parseInt(input.split(" ")[1]));
                    break;

                case "check" :
                    sb.append(check(Integer.parseInt(input.split(" ")[1]))).append("\n");
                    break;

                case "toggle" :
                    toggle(Integer.parseInt(input.split(" ")[1]));
                    break;

                case "all" :
                    all();
                    break;

                case "empty" :
                    empty();
            }
        }

        System.out.println(sb);
    }

    private static void clear() {
        set.clear();
    }

    private static void add(int element) {
        set.add(element);
    }

    private static void remove(int element) {
        set.remove(element);
    }

    private static int check(int element) {

        if (set.contains(element))
            return 1;

        return 0;
    }

    private static void toggle(int element) {

        if (check(element) == 1)
            set.remove(element);

        else
            set.add(element);
    }

    private static void all() {

        clear();

        final int START = 1;
        final int END = 20;

        for (int i = START; i <= END; i++) {
            set.add(i);
        }
    }

    private static void empty() {
        clear();
    }
}
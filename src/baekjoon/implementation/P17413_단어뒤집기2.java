package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17413_단어뒤집기2 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        boolean check = false;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == '<') {

                reverse(stack);
                check = true;

                sb.append(ch);
            }

            else if (ch == '>') {
                check = false;
                sb.append(ch);
            }

            else if (check)
                sb.append(ch);

            else {

                if (ch == ' ') {
                    reverse(stack);
                    sb.append(ch);
                }

                else
                    stack.push(ch);
            }
        }

        reverse(stack);

        System.out.println(sb);
    }

    static void reverse(Stack<Character> stack) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
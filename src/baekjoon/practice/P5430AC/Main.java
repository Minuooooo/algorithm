package baekjoon.practice.P5430AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            String[] elements = arr.substring(1, arr.length() - 1).split(",");
            Deque<Integer> deque = new LinkedList<>();
            for (String element : elements) {
                if (!element.isEmpty())
                    deque.offer(Integer.parseInt(element));
            }
            boolean isZero = false;
            boolean isReverse = false;
            for (int j = 0; j < command.length(); j++) {
                if (command.charAt(j) == 'R') {
                    isReverse = !isReverse;
                }
                else {
                    if (deque.isEmpty()) {
                        isZero = true;
                        break;
                    }
                    if (isReverse) {
                        deque.removeLast();
                    }
                    if (!isReverse) {
                        deque.removeFirst();
                    }
                }
            }
            if (isZero) {
                sb.append("error").append("\n");
                continue;
            }
            sb.append("[");
            while (!deque.isEmpty()) {
                if (isReverse) {
                    sb.append(deque.removeLast());
                }
                if (!isReverse) {
                    sb.append(deque.removeFirst());
                }
                if (!deque.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }
}
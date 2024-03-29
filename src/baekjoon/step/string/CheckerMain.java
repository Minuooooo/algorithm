package baekjoon.step.string;

import java.util.Scanner;

public class CheckerMain {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int count = 0;
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            if(chack() == true)
                count++;
        }

        System.out.println(count);

    }

    public static boolean chack() {

        boolean[] check = new boolean[26];
        int prev = 0;
        String str = scanner.next();

        for (int i = 0; i < str.length(); i++) {

            int now = str.charAt(i);

            if(prev != now) {
                if(check[now -'a'] == false){
                    check[now - 'a'] = true;
                    prev = now;
                } else
                    return false;
            }

        }

        return true;
    }
}

package baekjoon.greedy;

import java.util.Scanner;

public class P1541_잃어버린괄호 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int result = 0;

        if(str.charAt(0) == '-') {

            String[] strArr = str.split("-");

            for(String num : strArr) {

                String[] numArr = num.split("\\+");
                int sum = 0;

                for(String calNum : numArr) {
                    sum += Integer.parseInt(calNum);
                }

                result -= sum;
            }

        } else {

            int count = 1;
            String[] strArr = str.split("-");

            for(String num : strArr) {

                String[] numArr = num.split("\\+");
                int sum = 0;

                for(String calNum : numArr) {
                    sum += Integer.parseInt(calNum);
                }

                if(count == 1)
                    result += sum;
                else
                    result -= sum;

                count++;
            }
        }

        System.out.println(result);
    }
}

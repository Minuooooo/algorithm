package basic.greedy;

import java.util.Scanner;

public class P1541_최솟값을만드는괄호배치 {

    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String example = scanner.nextLine();
        String[] str = example.split("-");

        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);

            if(i == 0)
                answer += temp;
            else
                answer -= temp;
        }
        System.out.println(answer);
    }

    private static int mySum(String s) {
        int sum = 0;
        String[] temp = s.split("[+]");  // split 함수가 동작하지 않는 문자는 []로 묶기

        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }

        return sum;
    }
}

package university;

import java.util.Scanner;

public class BackTrackingCoin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] d = {500, 100, 50, 10};
        int size = d.length;

        System.out.println("Count : " + coin(0, n, size, d));
    }
    public static int coin(int index, int n, int m, int[] d) {
        if(index == m)
            return 0;
        else {
            int count = 0;
            count = n / d[index];
            n %= d[index];
            return (count + coin(index + 1, n, m, d));
        }
    }
}

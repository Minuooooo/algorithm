package university;

import java.util.Scanner;

public class BackTrackingDice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the dice count : ");
        int N = scan.nextInt();
        int[] diceNum = new int[N];

        System.out.println("Print " + N + " dice");
        print_dice(diceNum, N, 0);
    }
    public static void print_dice(int[] diceNum, int N, int num) {
        if(num == N) {
            for(int i = 0; i < N; i++) {
                if(i != (N - 1))
                    System.out.print(diceNum[i] + ", ");
                else
                    System.out.println(diceNum[i]);
            }
        } else {
            for(int i = 1; i <= 6; i++) {
                diceNum[num] = i;
                print_dice(diceNum, N, num + 1);
            }
        }
    }
}

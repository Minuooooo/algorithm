package university;

import java.util.Arrays;
import java.util.Scanner;

public class GreedySelectEvent {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));

        System.out.print("Enter the event count : ");
        int n = scan.nextInt();
        int[] s = new int[n];
        int[] f = new int[n];

        System.out.print("Enter the event's start time : ");
        for(int i = 0; i < n; i++)
            s[i] = scan.nextInt();

        System.out.print("Enter the event's end time : ");
        for(int i = 0; i < n; i++)
            f[i] = scan.nextInt();

        System.out.println("Event count max : " + selectEvent(n, s, f));
    }
    public static int selectEvent(int n, int[] s, int[] f) {
        int[] fPrime = new int[n];
        int fPrimeIndex = 0;
        int evNum = 0;
        int maxEvCount = 1;
        boolean check = true;

        for(int i = 0; i < n; i++)
            fPrime[i] = f[i];
        Arrays.sort(fPrime);

        while(true) {
            if(check) {
                for (int i = 0; i < n; i++) {
                    if (fPrime[fPrimeIndex] == f[i])
                        evNum = i;
                }
            }

            if(fPrimeIndex == n - 1)
                break;
            else
                fPrimeIndex++;

            for(int i = 0; i < n; i++) {
                if((i != evNum) && (f[i] == fPrime[fPrimeIndex])) {
                    if(f[evNum] <= s[i]) {
                        maxEvCount++;
                        check = true;
                        break;
                    }
                    else {
                        check = false;
                        break;
                    }
                }
            }
        }

        return maxEvCount;
    }
}

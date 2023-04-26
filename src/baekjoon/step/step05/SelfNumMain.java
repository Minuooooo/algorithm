package baekjoon.step.step05;

public class SelfNumMain {
    public static void main(String[] args) {
        selfNumber();
    }
    public static void selfNumber() {
        int[] arr = new int[15000];
        int i = 1;
        int temp = i;
        int constructor = 0;

        while (i <= 10000) {
            constructor = i;
            temp = i;

            while (temp > 0) {
                constructor += (temp % 10);
                temp /= 10;
            }
            arr[constructor] = 1;
            i++;
        }

        for (int j = 1; j < 10001; j++) {
            if(arr[j] == 0)
                System.out.println(j);
        }
    }
}

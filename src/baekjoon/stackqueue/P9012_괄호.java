package baekjoon.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9012_괄호 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {

            String checkVPS = br.readLine();
            int left = 0;
            boolean vps = true;

            for(int j = 0; j < checkVPS.length(); j++) {

                if(j == 0) {
                    if(checkVPS.charAt(j) == ')') {
                        vps = false;
                        break;
                    } else
                        left++;
                } else {
                    if(checkVPS.charAt(j) == '(')
                        left++;
                    else {
                        if(left == 0) {
                            vps = false;
                            break;
                        }
                        else
                            left--;
                    }
                }
            }

            if(vps && left == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
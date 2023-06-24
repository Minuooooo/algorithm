package basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {

    static int[] checkArr;
    static int[] myArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int result = 0;
        checkArr = new int[4];  // 조건
        myArr = new int[4];  // 입력받은 문자열에서의 카운팅
        checkSecret = 0;  // 4가 되면 조건 충족

        char[] A = br.readLine().toCharArray();  // 입력 받은 문자열을 character array 로 변환
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0)
                checkSecret++;
        }

        for (int i = 0; i < P; i++) {
            add(A[i]);
        }

        if(checkSecret == 4)
            result++;

        // 슬라이딩 윈도우 -> O(n)
        for (int i = P; i < S; i++) {
            int j = i - P;
            add(A[i]);
            remove(A[j]);

            if(checkSecret == 4)
                result++;
        }

        System.out.println(result);
        br.close();
    }

    private static void add(char c) {
        switch (c) {
            case 'A' -> {
                myArr[0]++;
                if (myArr[0] == checkArr[0])
                    checkSecret++;
            }
            case 'C' -> {
                myArr[1]++;
                if (myArr[1] == checkArr[1])
                    checkSecret++;
            }
            case 'G' -> {
                myArr[2]++;
                if (myArr[2] == checkArr[2])
                    checkSecret++;
            }
            case 'T' -> {
                myArr[3]++;
                if (myArr[3] == checkArr[3])
                    checkSecret++;
            }
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A' -> {
                if (myArr[0] == checkArr[0])
                    checkSecret--;
                myArr[0]--;
            }
            case 'C' -> {
                if (myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;
            }
            case 'G' -> {
                if (myArr[2] == checkArr[2])
                    checkSecret--;
                myArr[2]--;
            }
            case 'T' -> {
                if (myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
            }
        }
    }
}

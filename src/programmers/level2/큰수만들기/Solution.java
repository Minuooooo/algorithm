package programmers.level2.큰수만들기;

public class Solution {
    public String solution(String number, int k) {
        int len = number.length() - k;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (len-- > 0) {
            int max = -1;
            for (int i = index; i < number.length() - len; i++) {
                int num = number.charAt(i) - '0';
                if (num > max) {
                    if (num == 9) {
                        max = num;
                        index = i;
                        break;
                    }
                    max = num;
                    index = i;
                }
            }
            sb.append(max);
            index++;
        }
        return sb.toString();
    }
}
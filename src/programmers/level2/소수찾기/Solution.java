package programmers.level2.소수찾기;

import java.util.*;

public class Solution {
    private Set<Integer> set = new HashSet<>();
    private boolean[] check = new boolean[7];

    public int solution(String numbers) {
        int answer = 0;
        for (int i = 1; i <= numbers.length(); i++) {
            dfs(numbers, "", i);
        }
        for (int num : set) {
            boolean isPrime = false;
            if (num < 2)
                continue;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = true;
                    break;
                }
            }
            if (!isPrime)
                answer++;
        }
        return answer;
    }

    private void dfs(String str, String temp, int limit) {
        if (temp.length() == limit) {
            int num = Integer.parseInt(temp);
            set.add(num);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (check[i])
                continue;
            check[i] = true;
            temp += str.charAt(i);
            dfs(str, temp, limit);
            check[i] = false;
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}
package programmers.level2.메뉴리뉴얼;

import java.util.*;

public class Solution {
    private int[] alphabets = new int[26];
    private Map<String, Integer> wordMap = new HashMap<>();
    private int max;

    public String[] solution(String[] orders, int[] course) {
        for (String str : orders) {
            for (int i = 0; i < str.length(); i++) {
                alphabets[str.charAt(i) - 'A']++;
            }
        }
        List<String> words = new ArrayList<>();
        for (int limit : course) {
            wordMap.clear();
            max = 0;
            dfs('A', "", 0, limit, orders);
            if (max == 1)
                continue;
            for (String key : wordMap.keySet()) {
                if (wordMap.get(key) == max)
                    words.add(key);
            }
        }
        String[] answer = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            answer[i] = words.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private void dfs(char start, String temp, int depth, int limit, String[] orders) {
        if (depth == limit) {
            int count = getCount(temp, orders);
            if (count != 0) {
                wordMap.put(temp, count);
                max = Math.max(max, count);
            }
            return;
        }
        for (char ch = start; ch <= 'Z'; ch++) {
            if (alphabets[ch - 'A'] == 0)
                continue;
            temp += ch;
            dfs((char) (ch + 1), temp, depth + 1, limit, orders);
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    private int getCount(String combi, String[] orders) {
        int count = 0;
        for (String order : orders) {
            boolean check = true;
            for (int i = 0; i < combi.length(); i++) {
                if (!order.contains(combi.charAt(i) + "")) {
                    check = false;
                    break;
                }
            }
            if (check)
                count++;
        }
        return count;
    }
}
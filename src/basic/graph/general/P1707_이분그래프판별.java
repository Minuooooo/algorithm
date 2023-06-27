package basic.graph.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1707_이분그래프판별 {

    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {  // 주어진 테스트 케이스만큼 loop
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);
            A = new ArrayList[v + 1];
            visited = new boolean[v + 1];
            check = new int[v + 1];
            isEven = true;

            for (int i = 1; i <= v; i++) {
                A[i] = new ArrayList<>();
            }

            // Edge 데이터 저장
            for (int i = 0; i < e; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            // 모든 노드에서 DFS 실행
            for (int i = 1; i <= v; i++) {
                if(isEven)
                    dfs(1);
                else
                    break;
            }

            if(isEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int i : A[start]) {  // 인접리스트로 받아서 start 에서 연뎔된 모든 노드 탐색
            if(!visited[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류하는 것이 필요
                check[i] = (check[start] + 1) % 2;
                dfs(i);
            } else if (check[start] == check[i])
                isEven = false;
        }
    }
}

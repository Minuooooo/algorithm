package basic.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724_연결요소의개수구하기 {

    static ArrayList<ArrayList<Integer>> A;  // 인접 리스트, ArrayList 는 제네릭 타입이므로 배열 선언 시 이와 같이 선언
    static boolean[] visited;  // 방문 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        A = new ArrayList<>(n + 1);

        for (int i = 0; i < n + 1; i++) {
            A.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A.get(s).add(e);
            A.get(e).add(s);  // 양방향
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int v) {
        if(visited[v])
            return;

        visited[v] = true;
        for (int i : A.get(v)) {
            if (!visited[i])
                dfs(i);
        }
    }
}

package basic.graph.union;

import java.util.Scanner;

public class P1717_집합표현하기 {

    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {  // 대표 노드 초기화
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {  // 질의 계산
            int question = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if(question == 0)  // union
                union(a, b);
            else {  // 두 원소 같은지 검증
                boolean result = checkSame(a, b);

                if(result)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    private static void union(int a, int b) {
        // 대표 노드 찾아서 연결
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;  // 연결
    }

    private static int find(int a) {
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);  // value -> index 로 하여 탐색
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);

        return a == b;
    }
}

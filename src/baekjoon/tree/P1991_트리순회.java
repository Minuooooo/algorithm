package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991_트리순회 {

    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);  // 노드 삽입
        }

        preOrder(head);
        System.out.println();

        inOrder(head);
        System.out.println();

        postOrder(head);
    }

    static class Node {
        char value;
        Node left;
        Node right;

        Node (char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private static void insertNode (Node temp, char root, char left, char right) {  // 노드 삽입

        if (temp.value == root) {
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        }

        else {

            if (temp.left != null)
                insertNode(temp.left, root, left, right);

            if (temp.right != null)
                insertNode(temp.right, root, left, right);
        }
    }

    private static void preOrder (Node node) {  // 전위 순회

        if (node == null)
            return;

        System.out.print(node.value);

        preOrder(node.left);
        preOrder(node.right);
    }

    private static void inOrder (Node node) {  // 중위 순회

        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.value);

        inOrder(node.right);
    }

    private static void postOrder (Node node) {  // 후위 순회

        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);

        System.out.print(node.value);
    }
}
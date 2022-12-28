package backjoon.datastructure01;

import java.io.*;
import java.util.Stack;

public class StackMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push":
                    stack.push(Integer.parseInt(input[1]));
                    break;

                case "pop":
                    if(stack.empty())
                        bw.write("-1" + "\n");
                    else
                        bw.write(stack.pop() + "\n");
                    break;

                case "size":
                    bw.write(stack.size() + "\n");
                    break;

                case "empty":
                    if(stack.empty())
                        bw.write("1" + "\n");
                    else
                        bw.write("0" + "\n");
                    break;

                case "top":
                    if(stack.empty())
                        bw.write("-1" + "\n");
                    else
                        bw.write(stack.peek() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}

/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.15
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * BOJ 1427_소트인사이드
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line = br.readLine();
        //우선순위 큐 사용.
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < line.length(); i++){
            que.add(line.charAt(i) - '0');
        }
        for(int i = 0; i < line.length(); i++){
            sb.append(que.poll());
        }
        System.out.print(sb);
    }
}

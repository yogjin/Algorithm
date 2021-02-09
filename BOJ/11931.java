/* 
 * Author: Park Yeong-Jin
 * Date: 2021.2.9
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 11931_수 정렬하기4
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            q.add(Integer.parseInt(br.readLine()));
        }
        for(int i = 0; i < n; i++){
            sb.append(q.poll()).append('\n');   
        }
        System.out.print(sb);
    }
}

/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.16
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * BOJ 2752_세수정렬
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //우선순위큐로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(Integer.parseInt(st.nextToken()));
        pq.add(Integer.parseInt(st.nextToken()));
        pq.add(Integer.parseInt(st.nextToken()));
        sb.append(pq.poll()).append(" ");
        sb.append(pq.poll()).append(" ");
        sb.append(pq.poll()).append(" ");
        System.out.print(sb);
    }
}
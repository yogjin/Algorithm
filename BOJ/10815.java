/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.14
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
* BOJ 10815_숫자 카드
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int input = Integer.parseInt(st.nextToken());
            if(set.contains(input)) sb.append("1 ");
            else sb.append("0 ");
        }
        System.out.print(sb);
    }
}
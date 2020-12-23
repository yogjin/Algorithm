/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.23
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 2587_대표값2
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int sum = 0;
        int[] as = new int[5];
        for(int i = 0; i < 5; i++){
            int a = Integer.parseInt(br.readLine());
            sum += a;
            as[i] = a;
        }
        Arrays.sort(as);
        sb.append(sum/5).append('\n');
        sb.append(as[2]);
        System.out.print(sb);
    }
}

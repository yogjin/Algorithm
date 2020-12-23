/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.23
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 2576_홀수
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int min = 101;
        int sum = 0;
        for(int i = 0; i < 7; i++){
            int a = Integer.parseInt(br.readLine());
            if(a % 2 == 1){//홀수
                sum += a;
                if(a < min) min = a;
            }
        }
        if(sum == 0){//홀수가 없는경우
            sb.append(-1).append('\n');
        }
        else{
            sb.append(sum).append('\n');    
            sb.append(min);
        }
        System.out.print(sb);
    }
}

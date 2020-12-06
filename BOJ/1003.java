/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.6
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[41][2];//[][0]:0이 출력되는 횟수.[][1]:1이 출력되는 횟수
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 2; i <= 40; i++){
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            sb.append(dp[a][0]).append(" ").append(dp[a][1]).append("\n");
        }
        System.out.print(sb);
    }
}

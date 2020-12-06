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
        //dp사용 ,오버플로우 고려(long).
        long[] dp = new long[91];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.print(dp[n]);
    }
}

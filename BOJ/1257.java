/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.18
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * BOJ 1247_부호
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int i = 0; i < 3; i++){
            int n = Integer.parseInt(br.readLine());
            BigInteger sum = new BigInteger("0");
            for(int k = 0; k < n; k++){
                sum = sum.add(new BigInteger(br.readLine()));
            }
            if(sum.compareTo(new BigInteger("0")) == 1){//sum이 0보다 더 크면
                sb.append("+").append("\n");
            }
            else if(sum.compareTo(new BigInteger("0")) == 0){//0이면
                sb.append("0").append("\n");
            }
            else{
                sb.append("-").append("\n");
            }
        }
        System.out.print(sb);
    }
}
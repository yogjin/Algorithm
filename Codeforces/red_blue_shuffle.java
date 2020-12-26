/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.19
 * email: youngjin988@gmail.com
 * Codeforces Round #691 (Div. 2), problem: (A) Red-Blue Shuffle
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
        for(int i = 0; i< n; i++){
          int k = Integer.parseInt(br.readLine());//자릿수
          int[] red = new int[k];
          int[] blue = new int[k];
 
          String line = br.readLine();
          for(int j = 0; j < k;j++){
            red[j] = line.charAt(j)-'0';
          }
          line = br.readLine();
          for(int j = 0; j < k;j++){
            blue[j] = line.charAt(j)-'0';
          }
          int bw = 0;//blue win
          int rw = 0;
          for(int a = 0; a < k; a++){
            if(red[a] < blue[a]) bw++;
            else if(red[a] > blue[a])rw++;
          }
          if(rw == bw) sb.append("EQUAL").append("\n");
          else if(rw > bw) sb.append("RED").append("\n");
          else sb.append("BLUE").append("\n");
        }
        System.out.print(sb);
    }
}
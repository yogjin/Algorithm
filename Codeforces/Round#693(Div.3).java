//Codeforces Round #693 (Div. 3)
/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.4
 * email: youngjin988@gmail.com
 * 1472A - Cards for Friends
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());//t 테스트케이스 수
        
        for(int i = 0; i < t; i++){
          st = new StringTokenizer(br.readLine());
          int w = Integer.parseInt(st.nextToken());//가로
          int h = Integer.parseInt(st.nextToken());//세로
          int n = Integer.parseInt(st.nextToken());//만드는 개수
          
          int count = 1;
          while(w%2 == 0){
            w /= 2;
            count *= 2;
          }
          while(h%2 == 0){
            h /= 2;
            count *= 2;
          }
 
          if(count >= n) sb.append("YES\n");
          else sb.append("NO\n");
        }
        System.out.print(sb);
    }
}
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());//t 테스트케이스 수
        
        for(int i = 0; i < t; i++){
          int n = Integer.parseInt(br.readLine());//배열크기
          st = new StringTokenizer(br.readLine());
          int[] arr = new int[n+1];
          boolean[] b = new boolean[n+1];
          for(int j = 1; j <= n; j++){
            arr[j] = Integer.parseInt(st.nextToken());//수 넣기
          }
          long max = 0;
          long score = 0;
          for(int k = 1; k <= n; k++){
            score = 0;
            int index = k;//시작 인덱스
            while(index <= n && !b[index]){//인덱스가 베열크기를 넘어가지 않을정도로만
              b[index] = true;
              score += arr[index];
              index += arr[index];
            }
            max = Math.max(max,score);
          }
          sb.append(max).append("\n");
        }
        System.out.print(sb);
  }
}
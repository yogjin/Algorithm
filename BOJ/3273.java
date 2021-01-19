/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.19
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 3273_두 수의 합
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
        
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < list.length; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());//일치해야하는 합
        Arrays.sort(list);//정렬
        //투 포인터
        int start = 0;//포인터
        int end = n-1;//포인터
        int sum = 0;//두 수의 합
        int result = 0;//정답 수
        while(start < end){
          sum = list[start] + list[end];
          if(sum == m) result++;
          if(sum >= m) end--;
          else start++;
        }
        System.out.print(result);
    }
}

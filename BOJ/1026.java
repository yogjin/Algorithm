/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.3
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * BOJ 1026_보물
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    
        int n = Integer.parseInt(br.readLine());
        
        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer sta = new StringTokenizer(br.readLine());
        StringTokenizer stb = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(sta.nextToken());
            b[i] = Integer.parseInt(stb.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);//내림차순 정렬하려면 list로 바꿔서.. 해야하는데 복잡하다.
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += a[i]*b[n-1-i];
        }
        System.out.print(sum);
    }
}

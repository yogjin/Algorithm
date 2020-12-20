/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.20
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 20361_일우는 야바위꾼
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//컵개수
        int x = Integer.parseInt(st.nextToken());//공있는 컵
        int k = Integer.parseInt(st.nextToken());//수행횟수
        
        int[] cups = new int[n+1];
        cups[x] = 1;//공 == 1
        for(int i = 0; i<k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = cups[a];
            cups[a] = cups[b];
            cups[b] = temp;
        }
        
        for(int i = 1; i < n+1; i++){
            if(cups[i] == 1){//공이 있다면
                System.out.print(i);
                break;
            }
        }
    }
}

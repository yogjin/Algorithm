/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.23
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 2480_주사위 세개
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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int m = 0;
        if(a == b && b == c){
           m = 10000+a*1000;
        }
        else if(a == b || b == c || a == c){
            if(a == b){
                m = 1000+a*100;
            }
            if(b == c){
                m = 1000+b*100;
            }
            if(a == c){
                m = 1000+a*100;
            }
        }
        else{//다 다른경우
            m = Math.max(a,Math.max(b,c))*100;
        }
        System.out.print(m);
    }
}

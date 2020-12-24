/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.23
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 1267_핸드폰 요금
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
        st = new StringTokenizer(br.readLine());
        int y = 0;
        int m = 0;
        for(int i = 0; i < n; i++){
            int s = Integer.parseInt(st.nextToken());//통화시간
            y += 10*(s/30+1);//영식요금제
            m += 15*(s/60+1);//민식요금제
        }
        if(y < m){
            sb.append("Y ").append(y);
        }
        else if(m < y){
            sb.append("M ").append(m);
        }
        else{//요금이 같을때
            sb.append("Y M ").append(y);
        }
        System.out.print(sb);
    }
}

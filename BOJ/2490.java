/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.23
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 2490_윷놀이
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int i = 0; i < 3; i++){
            int count = 0;
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 0) count++;
            }
            if(count == 1) sb.append("A").append('\n');
            else if(count == 2) sb.append("B").append('\n');
            else if(count == 3) sb.append("C").append('\n');
            else if(count == 4) sb.append("D").append('\n');
            else sb.append("E").append('\n');
        }
        System.out.print(sb);
    }
}

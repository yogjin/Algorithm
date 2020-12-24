/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.24
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 10804_카드 역배치
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
   
        int[] card = new int[21];
        for(int i = 1; i <= 20; i++){//수 넣기
            card[i] = i;
        }
        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            while(a <= b){//대칭으로 바꾸기 
                int temp = card[a];
                card[a] = card[b];
                card[b] = temp;
                a++;
                b--;
            }
        }
        for(int i = 1; i <= 20; i++){
            sb.append(card[i]).append(" ");
        }
        System.out.print(sb);
    }
}

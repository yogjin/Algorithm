/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.23
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 2309_일곱 난쟁이
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int[] ms = new int[9];
        int all = 0;
        for(int i = 0; i < 9; i++){
            int a = Integer.parseInt(br.readLine());
            all += a;
            ms[i] = a;
        }
        int i = 0;
        int j = 0;
        Arrays.sort(ms);//정렬 후
        Loop1:
        for(i = 0; i < 9; i++){
            Loop2:
            for(j = i+1; j < 9; j++){//인덱스 2개를 빼가면서 100이되는지 체크
                if(all - (ms[i]+ms[j]) == 100) break Loop1;
            }
        }
        for(int a = 0; a < 9; a++){
            //i,j에 해당하는 인덱스 빼고 출력
            if(a == i || a == j){
                continue;
            }
            else{
                sb.append(ms[a]).append('\n');
            }
        }
        System.out.print(sb);
    }
}

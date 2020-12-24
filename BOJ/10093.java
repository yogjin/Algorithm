/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.23
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 10093_숫자
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
        
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        
        if(a.compareTo(b) == 1){//a가 b보다 크면 1
            //BigInteger는 immutable
            BigInteger temp = b;
            b = a;
            a = temp;
        }
        else if(a.compareTo(b) == 0){//a==b면
            System.out.print(0);
            return;
        }
        //BigInteger를 int로
        int n = b.subtract(a).subtract(BigInteger.ONE).intValue();
        sb.append(n).append("\n");//a b 사이에 있는 수의 개수
        for(int i = 0; i < n; i++){
            a = a.add(BigInteger.ONE);
            sb.append(a).append(" ");
        }
        System.out.print(sb);
    }
}

/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.7
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //a,b,c가 21억 이하로 주어지기 때문에 서로 연산하면 오버플로우가 날 수 있다.
        //따라서 long 자료형을 쓴다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.valueOf(Integer.parseInt(st.nextToken()));
        long b = Long.valueOf(Integer.parseInt(st.nextToken()));
        long c = Long.valueOf(Integer.parseInt(st.nextToken()));
        
        if(b >= c){
            System.out.println(-1);//손익분기점 존재x
            return;
        }
        int count = 0;
        while(a + b*count >= c*count){
            count++;
        }
        System.out.print(count);
    }
}

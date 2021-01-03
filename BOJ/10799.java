/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.3
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 10799_쇠막대기
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
       
        String line = br.readLine();//괄호표현
        
        Stack<Character> stk = new Stack<>();
        int count = 0;//조각 수
        boolean isRazer = true;
        for(int i = 0; i < line.length(); i++){
            char a = line.charAt(i);//( 또는 )
            
            if(a == '('){
                stk.push(a);
                isRazer = true;
            }
            else if(a == ')' && isRazer){// '(' 직후 ')'나오면 레이저
                stk.pop();
                //스택이 비었으면 막대기가 없음.
                if(!stk.isEmpty()) count += stk.size();
                isRazer = false;
            }
            else if(a == ')' && !isRazer){
                stk.pop();
                count++;
            }
        }
        System.out.print(count);
    }
}

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
        
        boolean[] num = new boolean[20000];
        num[0] = true;
        num[1] = false;//셀프 넘버면 false
        for(int i = 1; i < 10001; i++){
            int index = i;//자기자신으로 초기화
            int k = i;
            if(i < 10){//각 자릿수 더해주기.
                index += k;
                num[index] = true;
            } 
            else if(i < 100){
                index += k%10;//1번째 자릿수
                k /= 10;
                index += k;//2번째 자릿수
                num[index] = true;
            }
            else if(i < 1000){
                index += k%10;//1
                k /= 10;
                index += k%10;//2
                k /= 10;
                index += k;//3
                num[index] = true;
            }
            else if(i < 10000){
                index += k%10;//1
                k /= 10;
                index += k%10;//2
                k /= 10;
                index += k%10;//3
                k /= 10;
                index += k;//4
                num[index] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10001; i++){
            if(!num[i]) sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}

/* Author: Park Yeong-Jin
 * Date: 2020.12.5
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getComputerNum(a%10, b%4)).append("\n");
        }
        System.out.print(sb);
    }
    public static int getComputerNum(int a,int b){//제곱했을때 첫번째 자리수는 순환한다.
        int[] two = {6,2,4,8};
        int[] three = {1,3,9,7};
        int[] four = {6,4,6,4};
        int[] seven = {1,7,9,3};
        int[] eight = {6,8,4,2};
        int[] nine = {1,9,1,9};
        if(a == 1 || a == 5 || a == 6) return a;
        else if(a == 0) return 10;//나머지가 0이면 10번 컴퓨터
        else if(a == 2) return two[b];
        else if(a == 3) return three[b];
        else if(a == 4) return four[b];
        else if(a == 7) return seven[b];
        else if(a == 8) return eight[b];
        else return nine[b];
    }
}

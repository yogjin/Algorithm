/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.14
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * BOJ 1654_랜선 자르기
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());//만드는 개수
        
        long max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            int input = Integer.parseInt(br.readLine());
            if(input > max) max = input;
            list.add(input);
        }
        
        long min = 1;
        long mid = 0;
        while(max >= min){
            mid = (max+min)/2;
            int count = 0;
            for(int i : list){
                count += i/mid;
            }
            if(count >= n) min = mid + 1;
            else max = mid - 1;
        }
        System.out.print(max);
    }
}

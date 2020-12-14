/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.14
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * BOJ 2805_나무 자르기
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());//나무수
        int m = Integer.parseInt(st.nextToken());//필요한 나무 길이
        
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        long max = 0;
        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(st.nextToken());
            list.add(input);
            if(input > max) max = input;//제일 큰 나무길이
        }
        
        long min = 0;//절단기의 최소높이.
        long mid = 0;
        while(max >= min){
            mid = (max+min)/2;
            long len = 0;///int형으로 선언하면 오버플로우. 나무길이가 int형을 넘을수 있다.
            for(int i : list){
                long diff = i-mid;
                if(diff > 0) len += diff;
            }
            if(len >= m){
              min = mid+1;
            }
            else max = mid-1;
        }
        System.out.print(max);
    }
}

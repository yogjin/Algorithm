/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.18
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * BOJ 1920_수 찾기
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());//자연수개수
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        //이분탐색기본
        for(int i=0; i<m;i++){
            int max = n-1;
            int min = 0;
            int mid = 0;
            int input = Integer.parseInt(st.nextToken());//입력된 수
            while(min <= max){
                mid = (max+min)/2;
                if(input < arr[mid]){
                    max=mid-1;
                }
                else if(input > arr[mid]){
                    min=mid+1;
                }
                else{//input == arr[mid]
                    sb.append(1).append("\n");
                    break;
                }
                //input이 없는경우
                if(min > max) sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
    }
}
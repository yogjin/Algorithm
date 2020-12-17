/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.17
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * BOJ 1561_놀이 공원
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());//아이 수
        int m = Integer.parseInt(st.nextToken());//놀이기구 종류
        
        st = new StringTokenizer(br.readLine());
        int[] rides = new int[m];//놀이기구 시간
        for(int i = 0; i < m; i++){
            rides[i] = Integer.parseInt(st.nextToken());
        }
        if(n <= m){
          System.out.print(n);
          return;
        }
        long max = 2000000000L*30L;//20억명 * 30분
        long min = 0;
        long mid = 0;
        long cd = 0;//지금 놀이기구를 타고있는 아이 수
        while(min <= max){
            mid = (max+min)/2;
            cd = m;//0분에 m명의 아이가 동시에 탄다.
            for(int t : rides){
                cd += (mid-1)/t;//mid-1분 까지 각 놀이기구 별 타는 사람 수.
            }
            long cd_m = 0;//mid분에 타는 사람 수
            for(int t : rides){
                if(mid%t == 0) cd_m += 1;//나머지가 0일때 탄다.
            }
            //System.out.println(mid-1+"분 : "+cd+"명 "+mid+"분 : "+cd_m+"명 ");
            if(cd < n && n <= cd+cd_m) break;//mid분에 마지막 아이가 있다.
            //cd가 n보다 적으면 시간이 더 필요
            if(cd < n){
                min = mid+1;
            }
            else{
                max = mid-1;
            }
        }
        
        //mid분에 마지막 아이가 있다. 놀이기구 시간은 순서대로 주어지므로 
        //순서대로 구하면 됨.
        for(int i = 0; i < m; i++){
            if(mid%rides[i] == 0) cd++;
            if(cd == n){
                System.out.print(i+1);
                break;
            }
        }
        
    }
}
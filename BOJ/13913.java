/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.19
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 13913_숨바꼭질 4
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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(n == k){
          System.out.println(0);
          System.out.print(n);
          return;
        }
        int[] dist = new int[100001];
        Arrays.fill(dist,-1);//거리 -1로 초기화.
        dist[n] = 0;//수빈이
        
        int[] pa = new int[100001];//부모위치 저장
        Deque<Integer> q = new LinkedList<>();
        q.offer(n);
        while(!q.isEmpty()){
            int cx = q.poll();//현재 수빈이 위치
            //동생을 찾음
            if(cx == k){
                int[] out = new int[dist[cx]+1];
                sb.append(dist[cx]+"\n");
                int index = 0;
                out[index++] = cx;
                while(pa[cx] != n){
                  out[index++] = pa[cx];
                  cx = pa[cx];
                }
                out[index] = n;
                for(int i = out.length-1; i >= 0; i--){
                  sb.append(out[i]+" ");
                }
                System.out.print(sb);
            }
            for(int i = 0; i < 3; i++){
                int nx = getN(cx,i);
                if(nx <= -1 || nx >= 100001) continue;
                else if(dist[nx] >= 0) continue;
                q.offer(nx);
                dist[nx] = dist[cx]+1;
                pa[nx] = cx;//부모의 인덱스 저장.
            }
        }
    }
    public static int getN(int cx,int i){
        //i가 0 : x-1 / 1: x+1 / 2: 2*x
        if(i == 0) return cx-1;
        else if(i == 1) return cx+1;
        else return 2*cx;
    }
}

/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.19
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 13549_숨바꼭질 3
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
        if(n == k){//같은지점이면 0초
            System.out.print(0);
            return;
        }
        int[] list = new int[100001];
        boolean[] vis = new boolean[100001];
        Deque<Integer> q = new LinkedList<>();
        
        q.offer(n);
        vis[n] = true;
        while(!q.isEmpty()){
            int cx = q.poll();//현재 수빈이 위치

            if(cx == k){//찾은경우
              System.out.print(list[cx]);
              return;
            }
            for(int i = 2; i >= 0; i--){
                int nx = getN(cx,i);
                //범위,방문여부 고려
                if(nx <= -1 || nx >= 100001) continue;
                if(vis[nx]) continue;
                if(i == 2){//순간이동을 한 경우 0초
                  list[nx] = list[cx];
                  q.offerFirst(nx);
                }
                else{
                  list[nx] = list[cx] + 1;
                  q.offerLast(nx);
                }
                vis[nx] = true;
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

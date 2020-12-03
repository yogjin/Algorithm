/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.3
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 *
 * BOJ 1697 : 숨바꼭질
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//수빈이 위치
        int k = Integer.parseInt(st.nextToken());//동생 위치
        
        int[] visited = new int[100001];
        visited[n] = 1;//depth와 boolean을 동시에 해결. 값 == depth. 1 이상이면 탐색한 것.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);//수빈이 위치에서 시작.
        
        //bfs식으로 탐색.
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            if(now == k){//도착했다면 시간출력
                System.out.println(visited[now]-1);
                return;
            }
            //이동할 위치가 방문하지않았고, 범위에 들어가는지 검사
            if(now-1 >= 0){
                if(visited[now-1] == 0){
                    queue.add(now-1);
                    visited[now-1] = visited[now] + 1;
                }
            }
            if(now+1 <= 100000){
                if(visited[now+1] == 0){
                    queue.add(now+1);
                    visited[now+1] = visited[now] + 1;
                }
            }
            if(2*now <= 100000){  
                if(visited[2*now] == 0){
                    queue.add(2*now);
                    visited[2*now] = visited[now] + 1;
                }   
            }
        }
    }
    
}

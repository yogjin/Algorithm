/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.2
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 18352_특정 거리의 도시 찾기
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
        int n = Integer.parseInt(st.nextToken());//도시개수
        int m = Integer.parseInt(st.nextToken());//도로개수
        int k = Integer.parseInt(st.nextToken());//거리정보
        int x = Integer.parseInt(st.nextToken());//출발도시 번호
        
        //배열안에 리스트삽입
        LinkedList<Integer>[] list = new LinkedList[n+1];
        for(int i = 1; i <= n; i++){
          list[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < m; i++){//도로입력
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);//undirected
        }
        int[] visited = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = 1;//x->x를 1로 간주
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : list[now]){
                if(visited[i] == 0){
                    q.add(i);
                    visited[i] = visited[now] + 1;
                }
            }
        }
        boolean flag = false;//하나라도 있는지
        for(int i = 1; i <= n; i++){
            if(visited[i] == k+1){//x->x를 1로 간주했으니 k+1인 노드 찾기
                sb.append(i).append("\n");
                flag = true;
            }
        }
        if(!flag) sb.append(-1);
        System.out.print(sb);
    }
}

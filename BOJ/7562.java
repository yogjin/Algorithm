/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.6
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 7562_나이트의 이동
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static boolean[][] vis;
    static int[][] dist;
    static int[] dx = {-1,-1,1,1,2,2,-2,-2};
    static int[] dy = {2,-2,2,-2,1,-1,1,-1};
    static Queue<Dot> q = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String args[]) throws IOException {
        int t = Integer.parseInt(br.readLine());//테스트케이스
        
        for(int i = 0; i < t; i++){
            int l = Integer.parseInt(br.readLine());//한변의 길이
            dist = new int[l][l];//체스판
            for(int k = 0; k < dist.length; k++){
                Arrays.fill(dist[k], -1);//거리 -1로 초기화.
            }
            q = new LinkedList<>();//큐 초기화
            //현재 칸
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 0;//시작점거리 0
            //도착 칸
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(a == c && b == d){//도착점 == 시작점
              sb.append(0);
              sb.append("\n");
              continue;
            }
            q.offer(new Dot(a,b));
            loop:
            while(!q.isEmpty()){
                Dot now = q.poll();
                for(int o = 0; o < 8; o++){
                    int nx = now.x + dx[o];
                    int ny = now.y + dy[o];
                    if(nx <= -1 || ny <= -1 || nx >= l || ny >= l){
                        continue;
                    }
                    else if(dist[nx][ny] >= 0){
                        continue;
                    }
                    else if(nx == c && ny == d){
                        sb.append(dist[now.x][now.y] + 1);
                        sb.append("\n");
                        break loop;//이중 루프탈출
                    }
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                    q.offer(new Dot(nx,ny));
                }
            }
        }
        System.out.print(sb);
    }
}
class Dot{
    int x,y;
    public Dot(int x,int y){
        this.x = x;
        this.y = y;
    }
}

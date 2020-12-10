/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.11
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * BOJ 2206_벽 부수고 이동하기
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//행
        int m = Integer.parseInt(st.nextToken());//열
        
        int[][] map = new int[n+1][m+1];
        int[][] discovered = new int[n+1][m+1];//0(1)이면 drill(부순횟수)가 0(1)인 녀석이 지나갔다는 뜻.
        for(int i=1;i<=n;i++){
            String line = br.readLine();
            for(int j=1;j<=m;j++){
                map[i][j] = line.charAt(j-1) - '0';
                discovered[i][j] = Integer.MAX_VALUE;//최대 값으로 초기화.
            }
        }
        
        Queue<Dot> que = new LinkedList<>();
        que.add(new Dot(1,1,1,0));
        while(!que.isEmpty()){
            Dot now = que.poll();
            if(now.x == n && now.y == m){//(n,m)에 도착했다면 출력.
                System.out.print(now.dis);
                return;
            }
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx > n || ny > m || nx <= 0 || ny <= 0){
                    continue;
                }
                
                //나와 drill이 같은 다른 녀석이 이미 nx,ny를 지나간 경우는 다시 갈 필요x 
                //->heap메모리(queue) 초과방지.
                //그러나 이 문제는 (n,m)의 상,좌 에 벽이 있으면 (그전에 다른벽을 부순경우) 애초에 못가므로
                //벽을 안부수고 도착한 애가 우선권을 갖는다.
                if(discovered[nx][ny] <= now.drill){
                    continue;
                }
                if(map[nx][ny] == 0){//벽이 없는경우
                    que.add(new Dot(nx,ny,now.dis+1,now.drill));
                    discovered[nx][ny] = now.drill;
                }
                else{
                    if(now.drill == 0){//전에 벽을 부순적이 없는경우만 이동
                        que.add(new Dot(nx,ny,now.dis+1,1));//벽을 부쉈으니 큐에들어갈 녀석은 이미 한번의 기회를 썼다.
                        discovered[nx][ny] = 1;//벽을 부쉈다.
                    }
                }
            }
        }
        System.out.print(-1);//도착못하면 -1출력
    }
}
class Dot{
    int x,y,dis,drill;
    public Dot(int x,int y,int dis,int drill){
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.drill = drill;
    }
}
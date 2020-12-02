/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.2
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    private static boolean[][] visited;
    private static int[][] map;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static ArrayList<Integer> list = new ArrayList<>();
    private static ArrayList<Integer> Dangi = new ArrayList<>();//단지 저장
    private static int count = 0;//단지 내 집 개수 cnt
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int y = n-1; y >= 0; y--){
            String line = br.readLine();
            for(int x = 0; x <= n-1; x++){
                map[x][y] = line.charAt(x) - '0';//char to int
            }
        }
        /*한 노드에 대해 dfs를 하면 연결되어 있는 모든 노드를 방문하므로
          dfs를 하면 한 단지를 찾은 것과 같다. 따라서 모든 Dot을 순회하면서 dfs를 한다. 
        */
        for(int x = 0; x <= n-1; x++){
            for(int y = 0; y <= n-1; y++){
                count = 0;
                if(!visited[x][y] && map[x][y] == 1){//방문하지 않고 집이 있는 노드만 dfs시작.
                    dfs(x,y);
                    Dangi.add(count);//단지추가.
                }
            }
        }
        Collections.sort(Dangi);//ascending order
        System.out.println(Dangi.size());
        for(int i : Dangi){
            System.out.println(i+1);
        }
    }
    private static void dfs(int x, int y){
        visited[x][y] = true;
        int n = visited[x].length;
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX <= -1 || nextX >= n || nextY <= -1 || nextY >= n){//맵 범위 이탈
                continue;
            }
            else if(map[nextX][nextY] == 0){//집x
                continue;
            }
            else if(!visited[nextX][nextY]){
                dfs(nextX, nextY);
                count++;
            }
        }
    }
}

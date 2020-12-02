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
  private static LinkedList<LinkedList<Integer>> list = new LinkedList<>();
  private static boolean[] visited;
  private static int leafNode = 0;
  private static int deleteNode = 0;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      list.add(new LinkedList<Integer>());
    }
    int root = 0;
    for (int i = 0; i < n; i++) {
      int parent = Integer.parseInt(st.nextToken());
      if (parent == -1) {// 루트노드
        root = i;
      } else {
        // undirected graph로 tree 구현
        list.get(i).add(parent);
        list.get(parent).add(i);
      }
    }
    visited = new boolean[n];
    deleteNode = Integer.parseInt(br.readLine());
    if (deleteNode == root)
      System.out.println(0);
    else {
      dfs(root);//루트노드부터 탐색
      System.out.println(leafNode);
    }
  }

  public static void dfs(int start) {
    visited[start] = true;
    int child = 0;//자식 개수
    for (int i : list.get(start)) {
      if (!visited[i] && i != deleteNode) {//다음 탐색할 노드가 deleteNode이면 dfs 하지않음.
        child++;
        dfs(i);
      }
    }
    if(child == 0) leafNode++;
  }
}

/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.29
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 1158_요세푸스 문제
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
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        ListIterator it = list.listIterator();
        sb.append('<');
        while(!list.isEmpty()){
            for(int i = 0; i < k; i++){
                if(it.hasNext()){//list끝까지
                    if(i == k-1) sb.append(it.next()).append(", ");
                    else it.next();
                }
                else{//원형 큐
                    it = list.listIterator();//처음으로
                    if(i == k-1) sb.append(it.next()).append(", ");
                    else it.next();
                }
            }
            it.remove();//remove()는 그냥 삭제만하고 return이 없다.
        }
        //마지막 ", "삭제 : 출력조건
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");
        System.out.print(sb);
    }
}

/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.30
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 1021_회전하는 큐
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
        int n = Integer.parseInt(st.nextToken());//원소 개수
        int m = Integer.parseInt(st.nextToken());//뽑는 수 개수
        
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        
        ListIterator it = list.listIterator();
        int count = 0;
        int now = 0;
        int len = 0;//it.next()한 횟수
        if(it.hasNext()){
            now = (int)it.next();//1부터 시작. Object to int 강제형변환.
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int a = Integer.parseInt(st.nextToken());//뽑는 수
            while(now != a){
              if(it.hasNext()){
                now = (int)it.next();
                len++;
              }
              else{
                it = list.listIterator();//처음으로.
              }
            }
            if(list.size()-len < len) len = list.size()-len;//더 짧게 회전하는 방향 선택
            count += len;
            len = 0;//길이 초기화.
            it.remove();//뽑는 수 remove.
            //이동(이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.)
            if(it.hasNext()){
                now = (int)it.next();
            }
            else{
                it = list.listIterator();//처음으로.
                if(it.hasNext()) it.next();
            }
        }
        System.out.print(count);
    }
}
/*
다른 분 코드
출처 : https://1-7171771.tistory.com/35
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ~n까지 덱에 넣을 수
		int k = sc.nextInt(); // testCase

		int count = 0;

		Deque q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		for (int i = 0; i < k; i++) {
			int num = sc.nextInt();

			while (true) {
				int index = 0; // 몇번쨰 인덱스인지 찾기
				Iterator it = q.iterator();
				while (it.hasNext()) {
					if ((int)it.next() == num) break;
					index++;
				}

				if (index == 0) {
					q.pollFirst();
					break;
				}

				else if (index > q.size() / 2) {
					q.addFirst(q.removeLast());
					count++;
				}

				else {
					q.addLast(q.removeFirst());
					count++;
				}

			}

		}

		System.out.println(count);

	}

}
*/
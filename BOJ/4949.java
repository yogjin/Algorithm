/* 
 * Author: Park Yeong-Jin
 * Date: 2020.11.4
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 4949_균형잡힌 세상
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line;
        while(!(line = br.readLine()).equals(".")){
            printBalance(line);
        }
    }
    public static void printBalance(String line){//문자열이 균형인지 판단 후 yes,no 출력.
        if(checkBalance(line)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
    public static Boolean checkBalance(String line){//문자열이 균형인지 판단
        Stack<Integer> stack = new Stack<>();// ( : 0, ) : pop(); [ : 1.
        
        for(int i : line.toCharArray()){//toCharArray: char형 배열로 만드는 메소드
            if(i == '(' || i == '['){
                if(i == '(') stack.push(0);
                else stack.push(1);
            }
            else if(i == ')' || i == ']'){
                if(stack.empty()) return false;
                else if(i == ')' && stack.peek() == 0) stack.pop();
                else if(i == ']' && stack.peek() == 1) stack.pop();
                else return false;
            }
        }
        if(stack.empty()) return true;
        else return false;
    }
}
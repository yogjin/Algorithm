import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class insertionSort {
	

	public static void main(String[] args) {
		
		/***************************************파일 읽기*****************************************/
		String arrayElement = ""; 
		String path = System.getProperty("user.dir");//상대경로 구하기.
	    System.out.println("Working Directory = " + path);
	    
		try {
			//파일 객체 생성
			File file = new File(path+"\\data02.txt");
			//스캐너로 파일 읽기
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				arrayElement += scan.nextLine();//file내용 읽기.
        	}
		}catch(FileNotFoundException e) {
			
        }
	
		//System.out.println(arrayElement);
		String[] stringArray = arrayElement.split(",");//,을 기준으로 나눠서 배열에 넣기

		int[] array = new int[stringArray.length];//int형 배열을 만들어서
		for(int i = 0; i < stringArray.length; i++) {
			array[i] = Integer.parseInt(stringArray[i]);//String을 int로 변환해서 값 넣기
		}
		System.out.println("배열크기 : " + array.length);
        
		int[] insertionSortedArray;//정렬된 배열.
		
		System.out.println("Original_Array: "+Arrays.toString(array));	
		insertionSortedArray = insertionSort(array);//insertionSort해서 저장.
		System.out.println("Insertion_Sort: "+Arrays.toString(insertionSortedArray));
		
		/***************************************파일 저장*****************************************/
	      
		try{
            //파일 객체 생성
            File file = new File(path+"\\\\hw01_05_201702015_insertion.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            
            if(file.isFile() && file.canWrite()){
                //쓰기
            	for(int i = 0; i < insertionSortedArray.length; i++) {
            		if(i == insertionSortedArray.length-1) {
            			bufferedWriter.write(String.valueOf(insertionSortedArray[i]));//버퍼에 int를 String으로 변환해서 넣어줌.
            		}
            		else {
            			bufferedWriter.write(insertionSortedArray[i]+",");
            		}
            	}
                bufferedWriter.close();
            }
        }catch (IOException e) {
            System.out.println(e);
        }
		
	}
	public static int[] insertionSort(int[] array) {//insertionSort 함수
		int key = 0;
		for(int j = 1; j < array.length; j++) {//j는 1부터 시작.
			key = array[j];//key설정.
			int i = j-1;//key왼쪽부터 탐색
			while(i >= 0 && array[i]>key) {//key보다 크면 오른쪽으로 옮김
				array[i+1] = array[i];
				i--;
			}
			array[i+1] = key;//key보다 작거나 비교할 게 없으면 key를 넣음
		}
		return array;
	}
	

	
 }

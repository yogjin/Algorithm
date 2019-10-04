import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class mergeSort {
	public static int[] mergeSortedArray;//정렬된 원소를 집어넣는곳.
	public static int recursiveCount = 0;//merge함수가 호출될때마다 1씩 늘어남
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arrayElement = "";
		String path = System.getProperty("user.dir");//상대경로 구하기.
	    System.out.println("Working Directory = " + path);
	    
		try {
			//파일 객체 생성
			File file = new File(path+"\\data02.txt");
			//스캐너로 파일 읽기
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				arrayElement += scan.nextLine();
        	}
		}catch(FileNotFoundException e) {
			
        }
		String[] stringArray = arrayElement.split(",");

		int[] array = new int[stringArray.length];
		for(int i = 0; i < stringArray.length; i++) {
			array[i] = Integer.parseInt(stringArray[i]);
		}
        
		
		int arraySize = array.length;
		mergeSortedArray = new int[arraySize];//마지막에 merge함수 호출횟수 기록.
		System.out.println("Original_Array: "+Arrays.toString(array));
		System.out.println("배열 크기 : " + array.length);
		MergeSort(array,0,arraySize-1);//mergeSort
		System.out.println("merge 호출횟수 : " + recursiveCount);
		System.out.println("Merge_Sort: "+Arrays.toString(mergeSortedArray));
	    
		try{
            //파일 객체 생성
            File file = new File(path+"\\\\hw01_05_201702015_merge.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            
            if(file.isFile() && file.canWrite()){
                //쓰기
            	for(int i = 0; i < mergeSortedArray.length; i++) {
            			bufferedWriter.write(mergeSortedArray[i]+",");
            	}
            	bufferedWriter.write(String.valueOf(recursiveCount));//버퍼에 int를 String으로 변환해서 넣어줌.
                bufferedWriter.close();
            }
        }catch (IOException e) {
            System.out.println(e);
        }
		
	}
	public static void MergeSort(int[] array, int leftIndex, int rightIndex) {
		int midIndex;
		
		if(leftIndex < rightIndex) {//원소가 한개 남을때 까지 분할함.
			midIndex = (leftIndex + rightIndex)/2;
			//Divide
			MergeSort(array, leftIndex, midIndex);//왼쪽 분할
			MergeSort(array, midIndex+1, rightIndex);//오른쪽 분할
			//merge
			merge(array,leftIndex,midIndex,rightIndex);//1->2->4 ...로 늘어나면서 merge
		}
	}
	public static void merge(int[] array, int leftIndex, int midIndex,int rightIndex) {
		int p = leftIndex;//왼쪽 배열
		int q = midIndex + 1;//오른쪽배열
		int sortedArrayIndex = leftIndex;//정렬된 배열에 넣을 인덱스
		recursiveCount++;
		
		while(p <= midIndex && q <= rightIndex) {//오른쪽과 왼쪽 배열을 비교하면서 mergeSortedArray에 크기순대로 집어넣음
			if(array[p] < array[q]) {
				mergeSortedArray[sortedArrayIndex] = array[p];
				p++;
			}
			else {
				mergeSortedArray[sortedArrayIndex] = array[q];
				q++;
			}
			sortedArrayIndex++;
		}
		if(p <= midIndex) {//비교하고 남은 쪽의 원소를 순서대로 집어넣음.
			for(int i = p; i <= midIndex; i++) {
				mergeSortedArray[sortedArrayIndex++] = array[i];
			}
		}
		else {
			for(int j = q; j <= rightIndex; j++) {
				mergeSortedArray[sortedArrayIndex++] = array[j];
			}
		}
		for(int i = leftIndex; i <= rightIndex; i++) {
			array[i] = mergeSortedArray[i];
		}
	}
}

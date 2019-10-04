import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Counting_Inversions {
	public static int[] mergeSortedArray;//���ĵ� ���Ҹ� ����ִ°�.
	public static int inversionCount = 0;//inversion�϶����� 1�� �þ
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arrayElement = "";
		String path = System.getProperty("user.dir");//����� ���ϱ�.
	    System.out.println("Working Directory = " + path);
	    
		try {
			//���� ��ü ����
			File file = new File(path+"\\data03_inversion.txt");
			//��ĳ�ʷ� ���� �б�
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
		mergeSortedArray = new int[arraySize];//�������� merge�Լ� ȣ��Ƚ�� ���.
		System.out.println("Input Data: "+Arrays.toString(array));
		MergeSort(array,0,arraySize-1);//mergeSort
	    System.out.println("Output Data: "+inversionCount);
		
	}
	public static void MergeSort(int[] array, int leftIndex, int rightIndex) {
		int midIndex;
		
		if(leftIndex < rightIndex) {//���Ұ� �Ѱ� ������ ���� ������.
			midIndex = (leftIndex + rightIndex)/2;
			//Divide
			MergeSort(array, leftIndex, midIndex);//���� ����
			MergeSort(array, midIndex+1, rightIndex);//������ ����
			//merge
			merge(array,leftIndex,midIndex,rightIndex);//1->2->4 ...�� �þ�鼭 merge
		}
	}
	public static void merge(int[] array, int leftIndex, int midIndex,int rightIndex) {
		int p = leftIndex;//���� �迭
		int q = midIndex + 1;//�����ʹ迭
		int sortedArrayIndex = leftIndex;//���ĵ� �迭�� ���� �ε���
		
		
		while(p <= midIndex && q <= rightIndex) {//�����ʰ� ���� �迭�� ���ϸ鼭 mergeSortedArray�� ũ������ �������
			if(array[p] < array[q]) {
				mergeSortedArray[sortedArrayIndex] = array[p];
				p++;
			}
			else {
				mergeSortedArray[sortedArrayIndex] = array[q];
				inversionCount += midIndex - p + 1;//���ϰ� ���� p�迭�� ���ҵ��� q���� ũ�ٴ� ���� �и��ϴ�.
				q++;
			}
			sortedArrayIndex++;
		}
		if(p <= midIndex) {//���ϰ� ���� ���� ���Ҹ� ������� �������.
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

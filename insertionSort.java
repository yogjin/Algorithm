import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class insertionSort {
	

	public static void main(String[] args) {
		
		/***************************************���� �б�*****************************************/
		String arrayElement = ""; 
		String path = System.getProperty("user.dir");//����� ���ϱ�.
	    System.out.println("Working Directory = " + path);
	    
		try {
			//���� ��ü ����
			File file = new File(path+"\\data02.txt");
			//��ĳ�ʷ� ���� �б�
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				arrayElement += scan.nextLine();//file���� �б�.
        	}
		}catch(FileNotFoundException e) {
			
        }
	
		//System.out.println(arrayElement);
		String[] stringArray = arrayElement.split(",");//,�� �������� ������ �迭�� �ֱ�

		int[] array = new int[stringArray.length];//int�� �迭�� ����
		for(int i = 0; i < stringArray.length; i++) {
			array[i] = Integer.parseInt(stringArray[i]);//String�� int�� ��ȯ�ؼ� �� �ֱ�
		}
		System.out.println("�迭ũ�� : " + array.length);
        
		int[] insertionSortedArray;//���ĵ� �迭.
		
		System.out.println("Original_Array: "+Arrays.toString(array));	
		insertionSortedArray = insertionSort(array);//insertionSort�ؼ� ����.
		System.out.println("Insertion_Sort: "+Arrays.toString(insertionSortedArray));
		
		/***************************************���� ����*****************************************/
	      
		try{
            //���� ��ü ����
            File file = new File(path+"\\\\hw01_05_201702015_insertion.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            
            if(file.isFile() && file.canWrite()){
                //����
            	for(int i = 0; i < insertionSortedArray.length; i++) {
            		if(i == insertionSortedArray.length-1) {
            			bufferedWriter.write(String.valueOf(insertionSortedArray[i]));//���ۿ� int�� String���� ��ȯ�ؼ� �־���.
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
	public static int[] insertionSort(int[] array) {//insertionSort �Լ�
		int key = 0;
		for(int j = 1; j < array.length; j++) {//j�� 1���� ����.
			key = array[j];//key����.
			int i = j-1;//key���ʺ��� Ž��
			while(i >= 0 && array[i]>key) {//key���� ũ�� ���������� �ű�
				array[i+1] = array[i];
				i--;
			}
			array[i+1] = key;//key���� �۰ų� ���� �� ������ key�� ����
		}
		return array;
	}
	

	
 }

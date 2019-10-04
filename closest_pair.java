import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class closest_pair {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		/***************************************���� �б�*****************************************/
		
		String path = System.getProperty("user.dir");//����� ���ϱ�.
	    System.out.println("Working Directory = " + path);
	    
		//���� ��ü ����
		File file = new File(path+"\\data03_closest.txt");

		//��ĳ�ʷ� ���� �б�
		Scanner scan = new Scanner(file);
		ArrayList<Point> datas = new ArrayList<Point>();
		String line,stringX,stringY;//��ȯ�ϱ����� �ӽ������ϴ� ��Ʈ��.
		double x;//���� x,y��ǥ�� �ӽ�����
		double y;
		double result;
		while(scan.hasNextLine()){
			line = scan.nextLine();
			stringX = line.split(",")[0];
			stringY = line.split(",")[1];
			x = Double.parseDouble(stringX);//string�� double������ ��ȯ.
			y = Double.parseDouble(stringY);
			Point point = new Point(x,y);
			datas.add(point);
    	}
		//�ܼ� ���
		System.out.print("Input Data :");
		for(int i = 0; i < datas.size(); i++) {
			if(i == 0) {
				System.out.println(datas.get(i).getX()+", "+datas.get(i).getY());
			}
			else {
				System.out.println("            "+datas.get(i).getX()+", "+datas.get(i).getY());
			}
		}
		
		//1. X�� �������� ����
		Collections.sort(datas);
		
		//2. ��������
		result = closest_pair(datas);
		System.out.println("Output Data : "+result);
	}
	public static double closest_pair(ArrayList<Point> datas) {
		int numberOfPoint = datas.size();//�� ����
		
		if(numberOfPoint <= 3) {//��ǥ ���� 3���ϸ� Brute force�� ���
			double d,d1,d2,d3;
			if(datas.size() == 2) {//���� 2���� �׳� �Ÿ������ ����.
				d = distanceCalc(datas.get(0),datas.get(1));
				return d;
			}
			else if(numberOfPoint == 3) {//3���� �� ������
				d1 = distanceCalc(datas.get(0),datas.get(1));
				d2 = distanceCalc(datas.get(0),datas.get(2));
				d3 = distanceCalc(datas.get(1),datas.get(2));
				d = min(min(d1,d2),d3);//�� �������� d
				return d;
			}
		}
		//��ǥ ������ n/2�� �ش��ϴ� ������ �������� ����.
		ArrayList<Point> leftdatas = new ArrayList<Point>();
		for(int i = 0; i < numberOfPoint/2; i++) {
			leftdatas.add(datas.get(i));
		}
		ArrayList<Point> rightdatas = new ArrayList<Point>();
		for(int j = numberOfPoint/2; j < numberOfPoint; j++) {
			rightdatas.add(datas.get(j));
		}
		
		//�� �������� ������ �ִܰŸ� ���
		double d1 = closest_pair(leftdatas);
		double d2 = closest_pair(rightdatas);
		double d = min(d1,d2);//���ʰ� ������ �߿��� �ּҰŸ�
		
		// n/2 �������� x��ǥ ������ ���� d �̳��� �ִ� ��ǥ�� �и�
		double xOfLine = (leftdatas.get(leftdatas.size()-1).getX() + rightdatas.get(0).getX())/2;//leftdata ������ ������ x��ǥ���� rightdata ù��° ������ x��ǥ���� ����� ������ L�� x��ǥ�� ���ߴ�.
		
		ArrayList<Point> separatedDatas = new ArrayList<Point>();//window�ȿ� �ִ� ���� �ִ� arrayList
		for(int k = 0;k < numberOfPoint;k++) {
			if(xOfLine-d <= datas.get(k).getX() && datas.get(k).getX() <= xOfLine+d) {//window����
				separatedDatas.add(datas.get(k));
			}
		}
		
		//�и��� ��ǥ�� Y�� �������� Sort
		myComparator myComparator = new myComparator();
		Collections.sort(separatedDatas, myComparator);
		
		//Window ������ �ִܰŸ��� ���Ѵ�.
		int count = 0;
		for(int i = 0; i < separatedDatas.size(); i++) {
			for(int j = i+1; j < separatedDatas.size(); j++) {
				if(separatedDatas.get(j).getY() - separatedDatas.get(i).getY() <= d) {//y���� �������� d������ ���� �Ÿ��� �ִ� ���鸸 ��.
					d = min(d,distanceCalc(separatedDatas.get(j),separatedDatas.get(i)));
				}
				else {
					break;//y��ǥ���� ���̰� d���� ũ�� ���� �ʿ�x
				}
			}
		}
		
		return d;
		
	}
	private static double distanceCalc(Point p,Point q) {//�� �� ���� �Ÿ����.
		double d = Math.sqrt(Math.pow(p.getX()-q.getX(), 2) + Math.pow(p.getY()-q.getY(), 2));
		return d;
	}
	private static double min(double d1,double d2) {//�� ����� �Ÿ� ��ȯ.
		if(d1 < d2) {
			return d1;
		}
		else {
			return d2;
		}
	}
	static class Point implements Comparable<Point>{//�� ��ü.
		private double x;
		private double y;
		
		Point(double x,double y){
			this.x = x;
			this.y = y;
		}
		public double getX() {
			return this.x;
		}
		public double getY() {
			return this.y;
		}
		public int compareTo(Point point) {//x�� �������� ����.
			// TODO Auto-generated method stub
			if(this.x < point.getX()) {
				return -1;
			}else if(this.x > point.getX()) {
				return 1;
			}
			return 0;
		}
		
	}
	
	static class myComparator implements Comparator<Point>{
		public int compare(Point p1, Point p2) {//y�� �������� ����.
			// TODO Auto-generated method stub
			if(p1.getY() > p2.getY()) {
				return 1;
			}
			else if(p1.getY() < p2.getY()) {
				return -1;
			}
			return 0;
		}
	}
}

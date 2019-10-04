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
		/***************************************파일 읽기*****************************************/
		
		String path = System.getProperty("user.dir");//상대경로 구하기.
	    System.out.println("Working Directory = " + path);
	    
		//파일 객체 생성
		File file = new File(path+"\\data03_closest.txt");

		//스캐너로 파일 읽기
		Scanner scan = new Scanner(file);
		ArrayList<Point> datas = new ArrayList<Point>();
		String line,stringX,stringY;//변환하기위해 임시저장하는 스트링.
		double x;//점의 x,y좌표값 임시저장
		double y;
		double result;
		while(scan.hasNextLine()){
			line = scan.nextLine();
			stringX = line.split(",")[0];
			stringY = line.split(",")[1];
			x = Double.parseDouble(stringX);//string을 double형으로 변환.
			y = Double.parseDouble(stringY);
			Point point = new Point(x,y);
			datas.add(point);
    	}
		//콘솔 출력
		System.out.print("Input Data :");
		for(int i = 0; i < datas.size(); i++) {
			if(i == 0) {
				System.out.println(datas.get(i).getX()+", "+datas.get(i).getY());
			}
			else {
				System.out.println("            "+datas.get(i).getX()+", "+datas.get(i).getY());
			}
		}
		
		//1. X축 기준으로 정렬
		Collections.sort(datas);
		
		//2. 분할정복
		result = closest_pair(datas);
		System.out.println("Output Data : "+result);
	}
	public static double closest_pair(ArrayList<Point> datas) {
		int numberOfPoint = datas.size();//점 개수
		
		if(numberOfPoint <= 3) {//좌표 수가 3이하면 Brute force로 계산
			double d,d1,d2,d3;
			if(datas.size() == 2) {//점이 2개면 그냥 거리계산후 리턴.
				d = distanceCalc(datas.get(0),datas.get(1));
				return d;
			}
			else if(numberOfPoint == 3) {//3개면 젤 작은값
				d1 = distanceCalc(datas.get(0),datas.get(1));
				d2 = distanceCalc(datas.get(0),datas.get(2));
				d3 = distanceCalc(datas.get(1),datas.get(2));
				d = min(min(d1,d2),d3);//젤 작은값이 d
				return d;
			}
		}
		//좌표 개수의 n/2에 해당하는 지점을 기준으로 나눔.
		ArrayList<Point> leftdatas = new ArrayList<Point>();
		for(int i = 0; i < numberOfPoint/2; i++) {
			leftdatas.add(datas.get(i));
		}
		ArrayList<Point> rightdatas = new ArrayList<Point>();
		for(int j = numberOfPoint/2; j < numberOfPoint; j++) {
			rightdatas.add(datas.get(j));
		}
		
		//각 구역에서 점들의 최단거리 계산
		double d1 = closest_pair(leftdatas);
		double d2 = closest_pair(rightdatas);
		double d = min(d1,d2);//왼쪽과 오른쪽 중에서 최소거리
		
		// n/2 지점에서 x좌표 값으로 부터 d 이내에 있는 좌표만 분리
		double xOfLine = (leftdatas.get(leftdatas.size()-1).getX() + rightdatas.get(0).getX())/2;//leftdata 마지막 원소의 x좌표값과 rightdata 첫번째 원소의 x좌표값의 평균을 수직선 L의 x좌표로 정했다.
		
		ArrayList<Point> separatedDatas = new ArrayList<Point>();//window안에 있는 값을 넣는 arrayList
		for(int k = 0;k < numberOfPoint;k++) {
			if(xOfLine-d <= datas.get(k).getX() && datas.get(k).getX() <= xOfLine+d) {//window범위
				separatedDatas.add(datas.get(k));
			}
		}
		
		//분리한 좌표를 Y값 기준으로 Sort
		myComparator myComparator = new myComparator();
		Collections.sort(separatedDatas, myComparator);
		
		//Window 내부의 최단거리를 구한다.
		int count = 0;
		for(int i = 0; i < separatedDatas.size(); i++) {
			for(int j = i+1; j < separatedDatas.size(); j++) {
				if(separatedDatas.get(j).getY() - separatedDatas.get(i).getY() <= d) {//y값을 기준으로 d값보다 작은 거리에 있는 값들만 비교.
					d = min(d,distanceCalc(separatedDatas.get(j),separatedDatas.get(i)));
				}
				else {
					break;//y좌표값의 차이가 d보다 크면 비교할 필요x
				}
			}
		}
		
		return d;
		
	}
	private static double distanceCalc(Point p,Point q) {//두 점 사이 거리계산.
		double d = Math.sqrt(Math.pow(p.getX()-q.getX(), 2) + Math.pow(p.getY()-q.getY(), 2));
		return d;
	}
	private static double min(double d1,double d2) {//더 가까운 거리 반환.
		if(d1 < d2) {
			return d1;
		}
		else {
			return d2;
		}
	}
	static class Point implements Comparable<Point>{//점 객체.
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
		public int compareTo(Point point) {//x축 기준으로 정렬.
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
		public int compare(Point p1, Point p2) {//y축 기준으로 정렬.
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

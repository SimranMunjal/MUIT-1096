package priority_queues;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Student{
	String name;
	double marks;
	
	Student(String name, double marks){
		this.name = name;
		this.marks = marks;
	}
}

class MyComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.marks<o2.marks) {
			return 1;
		}
		else if(o1.marks>o2.marks) {
			return -1;
		}
		return 0;
	}
	
}

public class Lecture1 {
	
	public static void main(String[] args) {
		
//		PriorityQueue pq = new PriorityQueue(Collections.reverseOrder());
//		pq.add(3);
//		pq.add(2);
//		pq.add(6);
//		pq.add(1);
//		System.out.println(pq.remove());
		
//		PriorityQueue<Student> pq = new PriorityQueue<>(new MyComparator());
//		pq.add(new Student("abc",56));
//		pq.add(new Student("cde",67));
//		pq.add(new Student("ced",81));
//		pq.add(new Student("bcw",23));
//		System.out.println(pq.remove().name);
//		System.out.println(pq.remove().name);
//		System.out.println(pq.peek().name);
		
		MinPriorityQueue mpq = new MinPriorityQueue();
		mpq.insert(4);
		mpq.insert(0);
		mpq.insert(3);
		mpq.insert(8);
		mpq.insert(2);
//		System.out.println(mpq.getMin());
//		mpq.removeMin();
//		System.out.println(mpq.getMin());
		int arr[] = new int[mpq.size()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = mpq.removeMin();
		}
		for(int i: arr) {
			System.out.print(i+"  ");
		}
	}
	
}

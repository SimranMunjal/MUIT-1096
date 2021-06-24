package priority_queues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

class NewComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		if(o1.data<o2.data)
			return -1;
		else
			return 1;
	}
	
}
public class Question1 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		int size = s.nextInt();
		
		ArrayList<Node> list = new ArrayList();
		
		for(int i=0;i<k;i++) {
			Node head = null;
			Node tail = null;
			for(int j=0;j<size;j++) {
				int data = s.nextInt();
				Node curr = new Node(data);
				if(head==null) {
					head = curr;
					tail = curr;
				}
				else {
					tail.next = curr;
					tail = tail.next;
				}
			}
			list.add(head);
		}
		Node ans = merge(list);
		while(ans!=null) {
			System.out.print(ans.data+" -> ");
			ans = ans.next;
		}
		System.out.println("null");
	}

	private static Node merge(ArrayList<Node> list) {
		
		Node head = null;
		Node tail = null;
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new NewComparator());
		
		for(int i=0;i<list.size();i++) {
			Node temp = list.get(i);
			pq.add(temp);
		}
		while(!pq.isEmpty()) {
			Node curr = pq.remove();
			if(curr.next!=null) {
				pq.add(curr.next);
			}
			if(head==null) {
				head = curr;
				tail = curr;
			}
			else {
				tail.next = curr;
				tail = tail.next;
			}
		}
		return head;
	}
}

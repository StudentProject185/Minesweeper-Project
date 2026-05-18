package Part01;

public class CoordinateQueue {
	
	private CoordinateNode front;
	private CoordinateNode rear;
	private int size;
	
	private static class CoordinateNode{
		int x;
		int y;
		CoordinateNode next;
		
		public CoordinateNode(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}

	public static class Coordinate{
		private int x;
		private int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
		
		
	}
	
	public CoordinateQueue() {
		front = null;
		rear = null;
		size=0;
	}
	
	public void enqueue(int x, int y) {
		CoordinateNode newNode = new CoordinateNode(x, y);
		
		if(this.rear == null) {
			front=newNode;
			rear=newNode;
		}
		else {
			rear.next=newNode;
			rear=newNode;
			
		}
		size++;
	}
	
	public Coordinate dequeue() {
		if(front == null) {
			throw new IllegalStateException("Queue is empty");
		}
		
		CoordinateNode node = front;
		front = front.next;
		
		size--;
		
		if(front == null) rear = null;
		
		return new Coordinate(node.x, node.y);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	
}

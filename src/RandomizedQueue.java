import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private Item[] q;
	private int n = 0;
	private int first = 0;
	private int last = 0;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue(){
		q = (Item[]) new Object[2];
	}
	
	public boolean isEmpty() {
	        return n == 0;
    	}
	
	public int size(){
		return n;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int max) {
		assert n <= max;
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < n; i++) 
			temp[i] = q[(first+i) % q.length];
		q = temp;
		first = 0;
		last = n;
	}

	public void enqueue(Item item){
		if(item == null) throw new java.lang.NullPointerException();
		if(n == q.length)
			resize (2*q.length);
		q[last++] = item;
		if(last == q.length)
			last = 0;	//wrap around when the array is fully filled
		n++;
	}
	
	public Item dequeue(){
		if(isEmpty()) throw new NoSuchElementException();
		int rand = (first + StdRandom.uniform(n)) % q.length;
		Item item = q[rand];
		q[rand] = q[first];		//to prevent lotering, we are replacing the removed value with first element
		q[first] = null;		// and first element to null
		n--;
		first++;
		if (n > 0 && n <= q.length/4)
			resize(q.length/2);
		return item;
		
	}
	
	public Item sample() {
		if(isEmpty()) throw new NoSuchElementException();
		int rand = first + StdRandom.uniform(n) % q.length;
		Item item = q[rand];
		return item;
	}
	
	public void printAll(){
		StringBuilder s = new StringBuilder();
		for(Item i : this) 
			s.append(i + " ");
		StdOut.println(s);
	}

	public Iterator<Item> iterator() {return new RandomIterator();}

	private class RandomIterator implements Iterator<Item> {
		private int[] order;
		private int rand;
		public RandomIterator(){
			order = new int[n];
			for (int i = 1; i < n; i++){
				order[i] = (first+i) % q.length;
				System.out.println("first " + first + " order " + order[i]);	
				
			}
			StdRandom.shuffle(order);
			for (int i = 1; i < n; i++)
				System.out.println("first " + first + " order " + order[i] );								
			rand = 0;
		}
		
		public boolean hasNext(){
			return rand < order.length;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next(){
			if(!hasNext()) throw new NoSuchElementException();
			System.out.println("first " + first + " rand " + rand );
			Item item = q[order[rand++]];
			System.out.println(order[rand-1]);
			return item;
		}
	}

	public static void main(String[] args) {
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		for (int i = 0; i < 19; ++i) {
			q.enqueue(String.valueOf(i));
			if (i % 2 == 0)
				System.out.println(q.dequeue());
		}
		q.printAll();
	}


}

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node first, last;
	private int n = 0;
	private class Node{
		Item item;
		Node next = null;
		Node prev = null;
	}
	
	public Deque(){
		first = null;
		last = null;
	}
		
	public boolean isEmpty(){
		return n == 0;
	}
	
	public int size(){
		return n;
	}
	
	public void addFirst(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item  = item;
		first.next = oldFirst;
		if (isEmpty()) last = first;
			else oldFirst.prev = first;
		n++;
	}
	
	public void addLast(Item item){
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.prev = oldLast;
		if(isEmpty()) first = last;
			else oldLast.next = last;
		n++;
	}
	
	public Item removeFirst(){
		if (isEmpty()) throw new NoSuchElementException("Deque underflow");
		Item item = first.item;
		first = first.next;
		first.prev = null;
		n--;
		if (isEmpty()) last = null;   // to avoid loitering
		return item;
	}

	public Item removeLast(){
		if (isEmpty()) throw new NoSuchElementException("Deque underflow");
		Item item = last.item;
		last = last.prev;
		last.next = null;
		n--;
		if (isEmpty()) first = null;   // to avoid loitering
		return item;
	}
	
	public void printAll(){
		StringBuilder s = new StringBuilder();
		for(Item i : this) 
			s.append(i + " ");
		StdOut.println(s);
	}
	
	public Iterator<Item> iterator() {return new ListIterator();}
	
	private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

	
	public static void main(String[] args) {
	
	}


}

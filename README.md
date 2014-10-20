Deck
====

Programming assignment-2 in the Algorithms course

Programming Assignment 2:  Randomized Queues and Deques

Deadline: 11:55PM, 25 October 2014

Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary data structures using arrays and linked lists, and to introduce you to generics and iterators. 

Deque
Dequeue. A double-ended queue or deque (pronounced "deck") is a generalization of a stack and a queue that supports inserting and removing items from either the front or the back of the data structure. Create a generic data type Deque that implements the following API:

public class Deque<Item> implements Iterable<Item> {
   public Deque()                           // construct an empty deque// function number 1
   public boolean isEmpty()                 // is the deque empty?// function number 2
   public int size()                        // return the number of items on the deque// function number 3
   public void addFirst(Item item)          // insert the item at the front// function number 4
   public void addLast(Item item)           // insert the item at the end// function number 5
   public Item removeFirst()                // delete and return the item at the front// function number 6
   public Item removeLast()                 // delete and return the item at the end// function number 7
   public void printAll()  // print all the Item objects in the Deque using the iterator// function number 8
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   public static void main(String[] args)   // unit testing
}
Throw a NullPointerException if the client attempts to add a null item; throw a java.util.NoSuchElementException if the client attempts to remove an item from an empty deque; throw an UnsupportedOperationException if the client calls the remove() method in the iterator.

Performance requirements:  Your deque implementation must support each deque operation (including construction) in constant worst-case time and use space proportional to the number of items currently in the deque. Additionally, your iterator implementation must support each operation (including construction) in constant worst-case time.

main function:  Write the main function in such a way that it reads the standard input (i.e. the input you give to the program when it prompts for input) which consists of several line. Each line contains one integer which is the function number from Deque that you need to call and in the case the function has an input, it is followed by one space and then the input. Please note that in the case of testing the input is a simple string (a word).
For your convenience, the first line of input is always 1 (which means you have to create a deque) and the last line is 8 (which means there is no more line in the input and you have to print the deque). Additionally, you do not need to print anything for the other functions
when printing the elements of deque they should be separated by a single space(not tab, double space, comma or anything else) 

Note: you have to stick with this pattern for the input otherwise you will not get any score even if you add only one extra space

% java Deque       
1
5 Live                                            
5 Together
5 Die
5 Alone
8
output:
Live Together Die Alone
                                               
% java Deque
1
4 Fight
4 The
4 Dead
5 Fear
5 The
5 Living
6
6
6                                            
8
output:
Fear The Living                                              


Randomized queue
Randomized queue. A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random from items in the data structure. Create a generic data type RandomizedQueue that implements the following API:

public class RandomizedQueue<Item> implements Iterable<Item> {
   public RandomizedQueue()                 // construct an empty randomized queue// function number 1
   public boolean isEmpty()                 // is the queue empty?// function number 2
   public int size()                        // return the number of items on the queue// function number 3
   public void enqueue(Item item)           // add the item// function number 4
   public Item dequeue()                    // delete and return a random item// function number 5
   public Item sample()                     // return (but do not delete) a random item// function number 6
   public void printAll()  // print all the Item objects in the Deque using the iterator// function number 7
   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   public static void main(String[] args)   // unit testing
}
The order of two or more iterators to the same randomized queue must be mutually independent; each iterator must maintain its own random order. Throw a NullPointerException if the client attempts to add a null item; throw a java.util.NoSuchElementException if the client attempts to sample or dequeue an item from an empty randomized queue; throw an UnsupportedOperationException if the client calls the remove() method in the iterator.

Performance requirements:  Your randomized queue implementation must support each randomized queue operation (besides creating an iterator) in constant amortized time and use space proportional to the number of items currently in the queue. That is, any sequence of M randomized queue operations (starting from an empty queue) must take at most cM steps in the worst case, for some constant c. Additionally, your iterator implementation must support next() and hasNext() in constant worst-case time and construction in linear time; you may use a linear amount of extra memory per iterator.

main function:  Write the main function in such a way that it reads the standard input (i.e. the input you give to the program when it prompts for input) which consists of several line. Each line contains one integer which is the function number from RandomizedQueue that you need to call and in the case the function has an input, it is followed by one space and then the input. Please note that in the case of testing the input is a simple string (a word).
For your convenience, the first line of input is always 1 (which means you have to create a RandomizedQueue) and the last line is "7" (which means there is no more line in the input and you have to print the RandomizedQueue). Additionally, you do not need to print anything for the other functions
when printing the elements of RandomizedQueue they should be separated by a single space(not tab, double space, comma or anything else). In this case there might be different correct outputs because you choose elements to dequeue randomly.

Note: you have to stick with this pattern for the input otherwise you will not get any score even if you add one extra space.

% java RandomizedQueue       
1
4 Live
4 Together
4 Die
4 Alone
7
output:
Alone Live Together Die
                                               
% java RandomizedQueue
1
4 Fight
4 The
4 Dead
5
5
7
one of correct outputs:
The Dead                                              


Clients
Client. Write a client program Subset.java that takes a command-line integer k; reads in a sequence of strings from standard input using StdIn.readString(); and prints out exactly k of them, uniformly at random. Each item from the sequence can be printed out at most once. Furthermore, there are different acceptable outputs.

% echo A B C D E F G H I | java Subset 3       % echo AA BB CC  | java Subset 3
C                                              BB
G                                              AA
A                                              CC
% echo A B C D E F G H I | java Subset 3       
E                                              
F                                              
G                                              
Your program must implement the following API:
public class Subset {
   public static void main(String[] args)
}
You may assume that k ≥ 0 and no greater than the number of string N on standard input.
Performance requirements:  The running time of Subset must be linear in the size of the input. You may use only a constant amount of memory plus either one Deque or RandomizedQueue object of maximum size at most N. (For an extra challenge, limit the maximum size to k.)

Write a program Palindrome.java that reads in a sequence of characters from standard input, using StdIn.readChar(), and determines whether that sequence represents a Watson-Crick complemented palindrome: the { A, C, T, G }-sequence equals its reverse when you replace each base with its complement: A-T, C-G). Watson-Crick palindromes have many important biological roles. For example, tumor cells frequently amplify their genes by forming Watson-Crick palindromes.
% echo AAAACGTTTT | java Palindrome            % echo AAAACTTTT | java Palindrome
true                                           false

% echo AGCTAGCT | java Palindrome              % echo agctagct | java Palindrome
true                                           false

% echo GC | java Palindrome                    % echo AGCTTCGA | java Palindrome
true                                           false

% echo | java Palindrome                       % echo A | java Palindrome
true                                           false
Performance requirements:  The running time of Palindrome must be linear in the size of the input. You may use only a constant amount of memory plus either one Deque or RandomizedQueue object of maximum size at most N, where N is the number of characters on standard input.

Palindrome must implement the following API:

public class Palindrome {
   public static void main(String[] args)
}


Group policy
You may pick a partner for this assignment, but only 1 partner. You may also choose to work alone. Either choice is acceptable. 
If you choose to work alone, then in the last section of the readme.txt deliverable, please state that you worked alone. If you choose to work with a partner, then in the last section of the readme.txt, please briefly describe what each partner did. (One sentence should suffice). 

Deliverables

You have to create a folder and put RandomizedQueue.java and Deque.java and Palindrome.java and Subset.java in it. Your folder's name should be equal to the following pattern: <your net id>_<your partner netid> . If you do not ahve any partner your folder name should look like <your net id> 
Finally, add readme.txt file to the folder and answer the questions. 
Then you have to compress the folder with tar.gz format. (if decompressed there will a folder containing four java file and one readme.txt file) For instance: on1_ab2.tar.gz or on1.tar.gz are examples for the file you have to submit.
Either you or your partner have to submit the file to owlspace. 
Each of the two data type (RandomizedQueue and Deque) must include its own main() which is discussed previously. You may not call any library functions other than those in stdlib.jar and Integer.parseInt(). Note: If you fail to follow the rules, you will not get any score for the assignment
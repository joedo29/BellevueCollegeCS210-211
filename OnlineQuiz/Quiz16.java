 /* 
  * Phuong Do (Joe)
  * Date: August 01, 2017
  * Course: CS211
  * Quiz #16
  * Purpose: A. isPerfectStutter();  returns true if this list has exactly two int data throughout the list (like stutter() was just used on the list).
  * B. undoStutter(); a void method that will undo the stutter() operation for a list where isPerfectStutter() is true.
 */ 
import java.util.*;

// A LinkedIntList object can be used to store a list of integers.
public class LinkedIntList {
    private ListNode front;   // node holding first value in list (null if empty)
    private String name = "front";   // string to print for front of list
    
    // Constructs an empty list.
    public LinkedIntList() {
        front = null;
    }
    
    // Constructs a list containing the given elements.
    // For quick initialization via Practice-It test cases.
    public LinkedIntList(int... elements) {
        this("front", elements);
    }
    
    public LinkedIntList(String name, int... elements) {
        this.name = name;
        if (elements.length > 0) {
            front = new ListNode(elements[0]);
            ListNode current = front;
            for (int i = 1; i < elements.length; i++) {
                current.next = new ListNode(elements[i]);
                current = current.next;
            }
        }
    }
    
    // Constructs a list containing the given front node.
    // For quick initialization via Practice-It ListNode test cases.
    private LinkedIntList(String name, ListNode front) {
        this.name  = name;
        this.front = front;
    }
    
    // Appends the given value to the end of the list.
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            } 
            current.next = new ListNode(value);
        }
    }
    
    // Inserts the given value at the given index in the list.
    // Precondition: 0 <= index <= size
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            } 
            current.next = new ListNode(value, current.next);
        }
    }
    
    public boolean equals(Object o) {
        if (o instanceof LinkedIntList) {
            LinkedIntList other = (LinkedIntList) o;
            return toString().equals(other.toString());
        } else {
            return false;
        }
    }
    
    // Returns the integer at the given index in the list.
    // Precondition: 0 <= index < size
    public int get(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Removes the value at the given index from the list.
    // Precondition: 0 <= index < size
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }
    
    // Returns the number of elements in the list.
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Returns a text representation of the list, giving
    // indications as to the nodes and link structure of the list.
    // Detects student bugs where the student has inserted a cycle
    // into the list.
    public String toFormattedString() {
        ListNode.clearCycleData();
        
        String result = this.name;
        
        ListNode current = front;
        boolean cycle = false;
        while (current != null) {
            result += " -> [" + current.data + "]";
            if (current.cycle) {
                result += " (cycle!)";
                cycle = true;
                break;
            }
            current = current.__gotoNext();
        }

        if (!cycle) {
            result += " /";
        }
        
        return result;
    }
    
    // Returns a text representation of the list.
    public String toString() {
        return toFormattedString();
    }
    
    // Returns a shorter, more "java.util.LinkedList"-like text representation of the list.
    public String toStringShort() {
        ListNode.clearCycleData();
        
        String result = "[";
        
        ListNode current = front;
        boolean cycle = false;
        while (current != null) {
            if (result.length() > 1) {
				result += ", ";
			}
            result += current.data;
            if (current.cycle) {
                result += " (cycle!)";
                cycle = true;
                break;
            }
            current = current.__gotoNext();
        }

        if (!cycle) {
            result += "]";
        }
        
        return result;
    }
    

    // ListNode is a class for storing a single node of a linked list.  This
    // node class is for a list of integer values.
    // Most of the icky code is related to the task of figuring out
    // if the student has accidentally created a cycle by pointing a later part of the list back to an earlier part.

    public static class ListNode {
        private static final List<ListNode> ALL_NODES = new ArrayList<ListNode>();
        
        public static void clearCycleData() {
            for (ListNode node : ALL_NODES) {
                node.visited = false;
                node.cycle = false;
            }
        }
        
        public int data;          // data stored in this node
        public ListNode next;     // link to next node in the list
        public boolean visited;   // has this node been seen yet?
        public boolean cycle;     // is there a cycle at this node?

        // post: constructs a node with data 0 and null link
        public ListNode() {
            this(0, null);
        }

        // post: constructs a node with given data and null link
        public ListNode(int data) {
            this(data, null);
        }

        // post: constructs a node with given data and given link
        public ListNode(int data, ListNode next) {
            ALL_NODES.add(this);
            this.data = data;
            this.next = next;
            this.visited = false;
            this.cycle = false;
        }
        
        public ListNode __gotoNext() {
            return __gotoNext(true);
        }
        
        public ListNode __gotoNext(boolean checkForCycle) {
            if (checkForCycle) {
                visited = true;
                
                if (next != null) {
                    if (next.visited) {
                        // throw new IllegalStateException("cycle detected in list");
                        next.cycle = true;
                    }
                    next.visited = true;
                }
            }
            return next;
        }
    }

// YOUR CODE GOES HERE
    
    // isPerfectStutter();  returns true if this list has exactly two int data throughout the list 
    // (like stutter() was just used on the list).
    public boolean isPerfectStutter(){
    	boolean result = true;
    	if (front == null || front.next == null || size() % 2 != 0){
    		return false;
    	}
    	ListNode check = front;
    	while(check != null){
    		if(check.data != check.next.data){
    			result = false;
    			break;
    		} 
    		check = check.next.next;
    	}
    	return result;
    } // closes isPerfectStutter method
    
    // undoStutter() will undo the stutter effect created by the stutter() method, 
    // and needs to first check if isPerfectStutter() is true, because you cannot undo the stutter() signature 
    // if it's not present. 
	public void undoStutter() {
		
		if(isPerfectStutter() == true){
			int n = size() / 2;
			for (int i = 0; i < n; i++){
				remove(i);
			}
		}
	} // closes undoStutter method
	
    
    // Write a method isSorted that returns true if the list is in sorted (nondecreasing) order 
    // and returns false otherwise. An empty list is considered to be sorted.
    public boolean isSorted(){
    	boolean result = true;
    	if(front == null){
    		return true;
    	}
    	ListNode prev = front;
    	ListNode curr = prev.next;
    	while(curr != null){
    		if(prev.data > curr.data){
    			result = false;
    			break;
    		}
    		prev = curr;
    		curr = prev.next;
    	} // closes while loop
    	return result;
    } // closes isSorted method
    
    // Write a method set that accepts an index and a value and 
    // sets the list's element at that index to have the given value.
    public void set(int index, int value){
    	ListNode current = front;
    	for(int i = 0; i < index; i++){
    		current = current.next;
    	}
    	current.data = value;
    } // closes set method
    
    // #2 write a method called min that returns the minimum value in a list of integers
    // if a list is empty, throws a NoSuchElementException
    public int min(){
    	if(front == null){
    		throw new NoSuchElementException();
    	}
    	int min = front.data; // first value in the list
    	ListNode check = front.next;
    	while(check != null){
    		if(check.data < min){
    			min = check.data;
    		}
    		check = check.next;
    	}
    	return min;
    } // closes min method
    
    // #5 write a method called countDuplicates that returns the number of duplicates in a sorted list
    public int countDuplicates() {
        if(front == null)
            return 0;
            
        int total = 0;
        ListNode prev = front; // 1
        ListNode current = prev.next; // 19
        int count = 0;
        
        while(current != null) {
            if(current.data == prev.data) {
                count++;
            } else {
                total += count;
                count = 0;
            }
            prev = prev.next; // 19
            current = prev.next; // 1
        } // closes while loop
        total += count;
        return total;
    } // closes countDuplicates method
    
    // stutter
    public void stutter() {
        if(front == null)
            return;
            
        ListNode current = front;
        
        while(current != null) {
            ListNode n = new ListNode(current.data);
            n.next = current.next;
            current.next = n;
            current = n.next;
        }
    } // closes stutter method
    
    // removeAll
    public void removeAll(int val) {
        ListNode prev = null;
        ListNode current = front;
        
        while(current != null) {
            if(current.data == val) {
                if(prev == null) {
                    front = current.next;
                } else {
                    prev.next = current.next;
                }
                current = current.next;
            } else {
                prev = current;
                current = prev.next;
            }
        }
    } // closes removeAll



}
 /* 
  * Phuong DO (Joe)
  * Date: July 26, 2017
  * Course: CS211
  * Assignment #15a
  * Purpose: Create your own Stack Class, call it ArrayIntStack.java and 
  * write the standard four public Stack methods: empty(), peek(); pop(), push()
 */ 

import java.util.*;

/**
 *@author Phuong Do (Joe)
 *@date July 26 2017
 */
public class ArrayIntStack {
    private int[] elementData;  // list of integers
    private int size = 0;       // current number of elements in the stack
    
    public static final int DEFAULT_CAPACITY = 20;
   
    // Stuart Reges
    // 4/4/05
    //
    /** 
     *Constructs an empty stack of default capacity
     */ 
    public ArrayIntStack() {
        this(DEFAULT_CAPACITY);
        size = 0;
    }

    // Stuart Reges
    // 4/4/05
    //    
    // pre : capacity >= 0
    // post: constructs an empty stack with the given capacity

    private ArrayIntStack(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be at least 0: " + capacity);
        }
        elementData = new int[capacity];
    }
    
    /** 
     * Tests if this stack is empty.
     * @return true or false
     */
    public boolean empty(){
    	if(size == 0){
    		return true;
    	} else{
    		return false;
    	}
    } // closes empty method
    
    /**
     * Pushes an item onto the top of this stack.
     * @return newly added item
     * @thrown StackOverflowError Error thrown when Stack size is more than 20
     */
    public int push(int item){
    	if(size > 20){
    		throw new StackOverflowError("Stack size is now 20. You can not add any more value to the stack.");
    	} else{
        	elementData[size] = item;
        	size++;
        	return item;
    	}

    } // closes push method
    
    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     * @return value at the top of this stack
     * @throws EmptyStackException Error thrown when size is less than 1
     */
    public int pop(){
    	if(size < 1){
    		throw new EmptyStackException();
    	}
    	int n = elementData[size - 1];
    	size --;
    	return n;
    } // closes pop method
    
    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * @return the top value of the stack
     */
    public int peek(){
    	return elementData[size - 1];
    } // closes peek method
    
    // Stuart Reges
    // 4/4/05
    //
    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result += ", ";
            }
            if (i < elementData.length) {
                result += elementData[i];
            } else {
                // student's code is bogus; OOB
                result += "OOB!";
            }
        }
        result += "]";
        return result;
    } // closes toString method
    
    // Stuart Reges
    // 4/4/05
    //
    // The ArrayIntListIterator class provides a set of utilities for iterating
    // over an ArrayIntList and possibly removing values from the list.
    
    public static class IntStackIterator implements Iterator<Integer> {
        private ArrayIntStack list;    // list to iterate over
        private int position;          // current position within the list
        //private boolean removeOK;      // whether it's okay to remove now
        
        // pre : list != null
        // post: constructs an iterator for the given list
        public IntStackIterator(ArrayIntStack list) {
            this.list = list;
            position = list.size() - 1;
            //removeOK = false;
        }
        
        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
        	if(position < 0){
        		return false;
        	} else {
        		return position < list.size();
        	}
        }
        
        // pre : hasNext()
        // post: returns the next element in the iteration
        public Integer next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            } else{
                int result = list.elementData[position];
                position--;
                //removeOK = true;
                return result;
            }    
        } 
    } // closes ArrayIntListIterator method

	public int size() {
		return size;
	}
    
	public IntStackIterator iterator() {
		IntStackIterator n = new IntStackIterator(this);
		return n;
	}
 
} // closes class ArrayIntStack, completed assignment 15 part a 

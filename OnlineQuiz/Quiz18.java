/* 
 * Phuong Do (Joe)
 * Date: August 08, 2017
 * Course: CS211
 * Quiz #18
 * Purpose: Write two methods called contentEqual and longestLinkedList
 * contentEqual returns true if the other HashSet contains exactly the same element
 * longestLinkedList returns the number of nodes in the longest linked list of this HashSet
 */ 

// Implements a set of objects using a hash table.
// The hash table uses separate chaining to resolve collisions.
public class HashSet<E> {
	private static final double MAX_LOAD_FACTOR = 0.75;
	private HashEntry<E>[] elementData;
	private int size;

	// Constructs an empty set.
	@SuppressWarnings("unchecked")
	public HashSet() {
		elementData = new HashEntry[10];
		size = 0;
	}

	// ADD METHODS HERE for exercise solutions:

	// .toString2() provides a String return that will print similar to Figure 18.6 
	// on page 1077, BJP 4th edition
	public String toString2() {
		String result = "";
		if (!isEmpty()) { // if size != 0
			for (int i = 0; i < elementData.length; i++) { // elementData.length is the array's length
				System.out.print (String.format("%-10s","[" + i + "]"));
			}
			System.out.println();

			// begin printing each element
			int element = size; // size = total element
			int level = 1;
			HashEntry<E> current = null;
			while (element != 0){
				for(int i = 0; i < elementData.length; i++){
					current = elementData[i];
					if(current != null && current.data.hashCode() % elementData.length == i){ // check if parent has a child
						for(int j = 1; j < level; j++){
							if(current.next != null && current.next.data.hashCode() % elementData.length == i){
								current = current.next;
							} else{
								current = null;
								System.out.print(String.format("%" + 10 + "s", ""));
								break;
							}
						}
						if(current != null){
							System.out.print(String.format( "%-10s", (current.data)));
							element--;
						}
					} else{ // print each element here
						System.out.print(String.format("%" + 10 + "s", ""));
						result = "";
					}
				} // closes for loop
				System.out.println();
				level ++;
			} // closes while loop
		}
		return result = result + "";
	} // closes toString2 method, completed assignment #18


	// Returns a string representation of this queue, such as "[10, 20, 30]";
	// The elements are not guaranteed to be listed in sorted order.
	public String toString() {
		String result = "[";
		boolean first = true;
		if (!isEmpty()) {
			for (int i = 0; i < elementData.length; i++) {
				HashEntry<E> current = elementData[i];
				while (current != null) {
					if (!first) {
						result += ", ";
					}
					result += current.data;
					first = false;
					current = current.next;
				}
			}
		}
		return result + "]";
	}


	// Adds the given element to this set, if it was not already
	// contained in the set.
	public void add(E value) {
		if (!contains(value)) {
			if (loadFactor() >= MAX_LOAD_FACTOR) {
				rehash();
			}

			// insert new value at front of list
			int bucket = hashFunction(value);
			elementData[bucket] = new HashEntry<E>(value, elementData[bucket]);
			size++;
		}
	}

	// Removes all elements from the set.
	public void clear() {
		for (int i = 0; i < elementData.length; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	// Returns true if the given value is found in this set.
	public boolean contains(E value) {
		int bucket = hashFunction(value);
		HashEntry<E> current = elementData[bucket];
		while (current != null) {
			if (current.data.equals(value)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Returns true if there are no elements in this queue.
	public boolean isEmpty() {
		return size == 0;
	}

	// Removes the given value if it is contained in the set.
	// If the set does not contain the value, has no effect.
	public void remove(E value) {
		int bucket = hashFunction(value);
		if (elementData[bucket] != null) {
			// check front of list
			if (elementData[bucket].data.equals(value)) {
				elementData[bucket] = elementData[bucket].next;
				size--;
			} else {
				// check rest of list
				HashEntry<E> current = elementData[bucket];
				while (current.next != null && !current.next.data.equals(value)) {
					current = current.next;
				}

				// if the element is found, remove it
				if (current.next != null && current.next.data.equals(value)) {
					current.next = current.next.next;
					size--;
				}
			}
		}
	}

	// Returns the number of elements in the queue.
	public int size() {
		return size;
	}



	// Returns the preferred hash bucket index for the given value.
	private int hashFunction(E value) {
		return Math.abs(value.hashCode()) % elementData.length;
	}

	private double loadFactor() {
		return (double) size / elementData.length;
	}

	// Resizes the hash table to twice its former size.
	@SuppressWarnings("unchecked")
	private void rehash() {
		// replace element data array with a larger empty version
		HashEntry<E>[] oldElementData = elementData;
		elementData = new HashEntry[2 * oldElementData.length];
		size = 0;

		// re-add all of the old data into the new array
		for (int i = 0; i < oldElementData.length; i++) {
			HashEntry<E> current = oldElementData[i];
			while (current != null) {
				add((E)current.data);
				current = current.next;
			}
		}
	}

	// Represents a single value in a chain stored in one hash bucket.
	@SuppressWarnings("hiding")
	private class HashEntry<E> {
		public E data;
		public HashEntry<E> next; 
		@SuppressWarnings("unused")
		public HashEntry(E data) {
			this(data, null);
		}

		public HashEntry(E data, HashEntry<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	// contentEqual method accepts another HashSet as a parameter 
	// and returns true if the other HashSet contains exactly the same elements as this HashSet. 
	// The internal hash table size and ordering of the elements does not matter, 
	// only the sets of elements themselves.
	public boolean contentsEqual(HashSet<E> test1) {
		boolean check = true;
		if(test1 instanceof HashSet) {
			HashSet<E> anotherSet = (HashSet<E>) test1;
			if(size != anotherSet.size()){
				check = false;
				return check;
			}
			for(int i = 0; i < elementData.length; i++) {
				HashSet<E>.HashEntry<E> current = elementData[i];
				while(current != null) {
					if(!anotherSet.contains(current.data)){
						check = false;
						return check;
					} else{
						current = current.next;
					}
				} // closes while loop
			} // closes for loop
			return check;
		} // closes if statement 
		return check;
	} // closes contentEqual method


	// longgestLinkedList method returns the number of nodes in the longest linked list of this HashSet.  
	// The empty set returns zero, most small sets return one, 
	// but sets where hash code collisions are common can have long linked lists..
	public int longestLinkedList() {
		int numNode = 0;
		if(size == 0){
			return 0;
		} else {
			int element = size;
			int level = 1;
			HashEntry<E> current = null;
			while (element != 0){
				for(int i = 0; i < elementData.length; i++){
					current = elementData[i];
					if(current != null && current.data.hashCode() % elementData.length == i){
						for(int j = 1; j < level; j++){
							if(current.next != null && current.next.data.hashCode() % elementData.length == i){
								current = current.next;
							} else{
								current = null;
								break;
							}
						}
						if(current != null){
							element--;
						}
					}
				} // closes for loop
				level ++;
				numNode = level;
			} // closes while loop
		} // closes else statement
		return numNode - 1;
	} // closes longestLinkedList method

} // closes HashSet class

package DataStructureHashes;

import java.util.HashMap;

public class HashTable<K, V> {  // infers generic typing, any object can be assigned
	
	/**
	 * We need to create a container for the hash entries, for that we will use an array!
	 */
	private HashEntry[] table;
	
	/**
	 * We also need to create variables for:
	 *  - how many elements in table
	 *  - how big the table is
	 *  Respectively as...
	 */
	private int size;
	private int capacity;
	
	/**
	 * Now we to have a constructor and what will happen when HashTable<K, V> is called
	 */
	public HashTable(int tableSize){
		capacity = tableSize;
		table = new HashEntry[capacity];
		size = 0;
	}
	
	/**
	 * Now the most important part of a hash map/table/set is the hash code!
	 */
	private int hash(K k) {
		int hash = k.hashCode() % capacity;  // getting the integer that will represent the value of key
		
		/**
		 * Here, they used OPEN ADDRESSING, which finds the open NULL space in the array
		 */
		while(table[hash] != null && !table[hash].getK().equals(k)) {
			// if the spot has an element and the keys are NOT equal, continue
			hash = (hash + 1) % capacity;
		}
		return hash;
	}
	
	/**
	 * Methods for a hash type!
	 * - put
	 * - get
	 * - delete
	 * - size
	 */
	public void put(K k, V v) {
		/**
		 * First we need to find an index for this element!
		 */
		int index = hash(k);
		
		/**
		 * After finding index, put inside table!
		 */
		table[index] = new HashEntry<K, V>(k, v);
		
		//increase size of table
		size++;
	}
	
	public V get(K k) {
		/**
		 * First we need to get the hashCode (index) so we have something to compare to!
		 */
		int index = hash(k);
		
		/**
		 * If the table is null, return null!
		 */
		if(table[index] == null) {
			return null;
		}
		/**
		 * Else, return the value!!
		 */
		else {
			return (V)table[index].getV();
		}
	}
	
	public V delete(K k) {
		V value = get(k);
		
		if(value != null) {  // that just means there's an element
			/**
			 * Find out the hash code (index)
			 */
			int index = hash(k);
			
			//now setting that spot to NULL because we deleted it!
			table[index] = null;
			
			//decrease size by 1
			size--;
			
			/**
			 * Cleaning up!!
			 */
			
			index = (index + 1) % capacity;  // moves up by one to the next hashcode (index)
			
			while(table[index] != null) {
				HashEntry he = table[index];  // 'he' will get the info from table[index]
				
				
				table[index] = null;  // now we're deleting it off as well!
				
				//repositioning the deleted element!!
				// don't forget the 'put' method creates new hashcode, new index!
				put( (K)he.getK(), (V)he.getV() );  // type casting 
				
				size--;  // the 'put' method increases the size by one, but we're not adding!
				
				//move up again! 
				//so we can clean the array and the hash code will be correct for each value
				
				index = (index + 1) % capacity;
				
				
			}
		}
		return value;
	}
	
	public int size() {
		return size;
	}
	
	
	/**
	 * K - key
	 * V - value
	 */
	private class HashEntry<K, V>{
		
		private K k; 
		private V v;
		
		public HashEntry(K k, V v) {
			this.k = k;
			this.v = v;
		}

		/**
		 * Below was generated through 'source' --> 'Generate getters and setters'
		 */
		public K getK() {
			return k;
		}

		public void setK(K k) {
			this.k = k;
		}

		public V getV() {
			return v;
		}

		public void setV(V v) {
			this.v = v;
		}
		
		
		
	}
	
}

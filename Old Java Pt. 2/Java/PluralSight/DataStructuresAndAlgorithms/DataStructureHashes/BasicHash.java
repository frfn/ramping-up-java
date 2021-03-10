package DataStructureHashes;

/**
 * RECODE this.
 * @author Flexer
 *
 * @param <K>
 * @param <V>
 * 
 * It is noted that you'd always want a table bigger than needed, always only up to 70% should be occupied, that is our threshold!
 */

public class BasicHash<K, V> {  // K = KEY , V = VALUE or item in the entry
	
	private HashEntry[] data; // An array that holds key and value pairs, 
	
	// capacity is different from size
	private int capacity;  // how big the Table will be
	private int size;  // how many elements in the table
	
	// there it is. int tableSize
	public BasicHash(int tableSize) {
		capacity = tableSize;
		data = new HashEntry[capacity];  // this will appropriately index the values, our "bucket"
		size = 0;
	}
	
	public void put(K key, V value) {
		int hash = calculateHash(key);
		data[hash] = new HashEntry<K, V>(key, value);
		size++;
	}
	
	public V delete(K key) {  // Big O Notation -- depends on rehashing, can be linear to quadratic!
		V value = get(key);
		
		if(value != null) {
			int hash = calculateHash(key);
			data[hash] = null;  // will set to null to remove
			size--;  // decrement size
			hash = (hash + 1) % capacity;  // moves hash up by one to see if next slot has value, also scans if there are collisions in the data
			
			// if next slot isn't empty we should re add it so we can keep the hash algorithm clean
			while (data[hash] != null) {
				HashEntry he = data[hash];
				data[hash] = null;
				
				System.out.println("Rehashing: " + he.getKey() + " - " + he.getValue());
				
				put((K)he.getKey(), (V)he.getValue());
				// repositioned the hash item, we did not add anything to size
				size--;
				hash = (hash + 1) % capacity;
			}
		}
		return value;
	}
	
	public boolean hasValue(V value) {
		/**
		 * We are doing capacity because if we do size, it will look at the size
		 * of array and not the actual slots that has information in it.
		 */
		
		for(int i = 0; i < capacity; i++) {
			HashEntry entry = data[i];
			
			if(entry != null && entry.getValue().equals(value)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasKey(K key) {
		int hash = calculateHash(key);
		
		if(data[hash] == null) {
			return false;  // means that there are no element
		}
		
		else {
				if (data[hash].getKey().equals(key)) {
				return true;  // the key are the same
			}
		}
		return false;  // means there are no key
	}
	
	public V get(K key) {
		int hash = calculateHash(key);  // this will return hash code of Key
		
		// if no element on the hash index of Key, based on calculate hash, means no element in data array
		if(data[hash] == null) {  
			return null;
		}
		//otherwise get the hash entry
		else {
			return (V)data[hash].getValue();
		}
	}
	
	public int size() {
		return size;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 * 
	 * I don't like, just do closed addressing with linked lists!
	 * 
	 * Collisions... right, if the same bucket just start a singly linked list!!
	 */
	private int calculateHash(K key) {
		int hash = (key.hashCode() % capacity);  
		
		
		// this is necessary to deal with COLLISIONS, or data being in the spot already.
		// finding a slot in the hash table, hash slot is different from hash code, hash code is UNIQUE and hash slot may be the same. So capacity should be bigger than size
		
		// hashCode is HELLA long, so we will modulo with capacity. 
		// example:  1234235346 % 12 = 6
		// will give us a single digit or a smaller size integer.
		// that will be the memory address of element, that is where it will go in array, in spot 6.
		
		/**
		 * if not null, keep going -- means the slot has an element already and will be a COLLISION
		 * 
		 * !data[hash].getKey() -- getting the Key of the element in data[hash] 
		 *  .equals(key)		-- comparing the two keys, and if they're not the same, keep looping
		 */
		while (data[hash] != null && !data[hash].getKey().equals(key)) {
			// if no hash is appropriate for key, do this.
			// this is why we want CAPACITY to be bigger than SIZE
			hash = (hash + 1) % capacity;
			/**
			 * We're going up by 1 till we find a blank space in the array so we can put new element in,
			 * it is called OPEN ADDRESSING because it finds an open address, also called linear probing.
			 */
			
		}
		return hash;
		
	}
	
	
	private class HashEntry<K, V> {
		
		private K key;
		private V value;
		
		public HashEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		
	}
	
}

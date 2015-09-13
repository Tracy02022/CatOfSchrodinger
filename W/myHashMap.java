public class HashTable_Sample_1 {
	public static class myMap<K, V> {
		private static int initialCapacity = 64;
		// Math.pow(x, n) x的n次幂
		// 0.6 or 0.75
		/*
		private double DEFAULT_LOAD_FACTOR = (Math.pow(5, 0.5) - 1) / 2;
		*/
		// private double DEFAULT_LOAD_FACTOR = 0.75;
		
		private int capacity;
		
		private Node<K, V>[] buckets;
		
		public myMap() {
			this(initialCapacity);
		}
		// @SuppressWarnings 批注允许您选择性地取消特定代码段（即，类或方法）中的警告。其中的想法是当您看到警告时，您将调查它，如果您确定它不是问题，您就可以添加一个 @SuppressWarnings 批注，以使您不会再看到警告。虽然它听起来似乎会屏蔽潜在的错误，但实际上它将提高代码安全性，因为它将防止您对警告无动于衷 — 您看到的每一个警告都将值得注意。 
		// unchecked 执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型。
		@SuppressWarnings("unchecked")
		public myMap(int capacity) {
			if (capacity <= 0) {
				throw new IllegalArgumentException("illegal input");
			}
			/*
			int tmp = 1;
			// tmp * 2^2
			while (tmp < capacity) {
				tmp <<= 2;
			}
			this.capacity = tmp;
			*/
			this.capacity = capacity;
			buckets = new Node[this.capacity];
		}
		
		public class Node<K, V> {
			private final K key;
			private V value;
			private Node<K, V> next;
			
			public Node(K key, V value) {
				this.key = key;
				this.value = value;
			}
			
			public void setNext(Node<K, V> next) {
				this.next = next;
			}
		}
		
		public void put(K key, V value) {
			if (key == null) {
				throw new IllegalArgumentException("key can not be null");
			}
			
			int position = index(key);
			
			Node<K, V> node = buckets[position];
			
			while (node != null) {
				if (node.key.equals(key)) {
					node.value = value;
					return;
				}
				node = node.next;
			}
			
			Node<K, V> newNode = new Node<K, V>(key, value);
			if (buckets[position] != null) {
				newNode.setNext(buckets[position]);
			}
			
			buckets[position] = newNode;
		}
		
		public V get(K key) {
			if (key == null) {
				throw new IllegalArgumentException("key can not be null");
			}
			
			int position = index(key);
			Node<K, V> node = buckets[position];
			
			while (node != null) {
				if (node.key.equals(key)) {
					return node.value;
				}
				node = node.next;
			}
			
			return null;
		}
		// hash(key)%size
		private int index(K key) {
			
			int hashCode = key.hashCode();
			/*
			double tmp = hashCode * DEFAULT_LOAD_FACTOR;
			double digit = tmp - Math.floor(tmp);
			// The method floor gives the largest integer that is less than or equal to the argument.
			return (int)Math.floor(digit * capacity);
			*/
			int index = (hashCode % capacity + capacity) % capacity;
			return index;
		}
	}
	
	public static void main(String[] args) {
		myMap<String, String> map1 = new myMap<String, String>();
		map1.put("school", "umass");
		map1.put("school", "whut");
		map1.put("job", "sde");
		map1.put("employer", "Linkedin");
		myMap<Integer, String> map2 = new myMap<Integer, String>();
		map2.put(-12, "wuhan");
		map2.put(-13, "hankow");
		System.out.print(map1.get("school") + "\n");
		System.out.print(map1.get("job") + "\n");
		System.out.print(map2.get(-13) + "\n");
	} 
}

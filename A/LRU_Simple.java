/*
LRU Cache
给一个array, 给一个cache max size, 输出miss count.
miss count是指整个array读完之后一共有多少个miss. e.g. 给定一个stack size是4, 一开始的时候是空的, 那每从array里读一个数, 就是一个miss, 之后如果和array里第五个相同的数正好有在LRU stack里, 就是hit, 如果不在, 就又是miss, 期间不断更新那个stack. 
(ArrayList的不足是当set的时候没法添加到任意位置，所以要用Double LinkedList)
*/
public class LRU_Simple {
	
	public static class LRUCache {
		
		ArrayList<Integer> cache = new ArrayList<Integer>();
		int capacity;
		int miss;
		int hit;
		
		public LRUCache(int capacity, int miss, int hit) {
			this.capacity = capacity;
			this.miss = miss;
			this.hit = hit;
		}
	
		public void plus(int value) {
			
			if (cache.contains(value)) {
				cache.remove(cache.indexOf(value));
				cache.add(value);
				hit++;
			} else {
				cache.add(value);
				miss++;
			}
			
			if (cache.size() > capacity) {
				cache.remove(0);
			}
		}
		
		public ArrayList<Integer> print() {
			return cache;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 4, 5, 7, 3};
		
		LRUCache test = new LRUCache(3, 0, 0);
		test.plus(2);
		test.plus(4);
		test.plus(4);
		
		System.out.print(test.hit);		
	}
}

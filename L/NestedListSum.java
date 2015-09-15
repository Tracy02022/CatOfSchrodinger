/** 
* Given a nested list of integers, returns the sum of all integers in the list weighted by their depth 
* For example, given the list {(1,1),2,(1,1)} the function should return 10 (four 1's at depth 2, one 2 at depth 1) 
* Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3) 
*/ 
public int depthSum (List<NestedInteger> input) { 
  // ur implementation here
} 


/** 
* This is the interface that represents nested lists. 
* You should not implement it, or speculate about its implementation. 
*/ 
public interface NestedInteger { 
  /** @return true if this NestedInteger holds a single integer, rather than a nested list */ 
  boolean isInteger(); 
  
  /** @return the single integer that this NestedInteger holds, if it holds a single integer 
  * Return null if this NestedInteger holds a nested list */ 
  Integer getInteger(); 
  
  /** @return the nested list that this NestedInteger holds, if it holds a nested list
  * Return null if this NestedInteger holds a single integer */ 
  List<NestedInteger> getList(); 
}

// DFS
// time O(N), space O(depth). ?
public class NestedListSum {
	// the algo
	public static int depthSum (List<NestedInteger> inputList) {
		return dfs(inputList, 1);
	}
	
	public static int dfs (List<NestedInteger> list, int weight) {
		int sum = 0;
		for (NestedInteger ni : list) {
			if (ni.isInteger()) {
				sum += ni.getInteger() * weight;
			} else {
				sum += dfs(ni.getList(), weight + 1);
			}
		}
		return sum;
	}
	// interface and Impl
	public static interface NestedInteger {
		
		boolean isInteger();
		
		Integer getInteger();
		
		List<NestedInteger> getList();
	}
	
	public static class NestedIntegerImpl implements NestedInteger {
		
		int num;
		List<NestedInteger> list = new ArrayList<NestedInteger>();
		
		public NestedIntegerImpl(int number) {
			num = number;
			list = null;
		}
		
		public NestedIntegerImpl(List<NestedInteger> inputList) {
			num = -1;
			list = inputList;
		}
		
		@Override
		public boolean isInteger() {
			return list == null;
		}
		
		@Override
		public Integer getInteger() {
			if (isInteger()) {
				return num;
			}
			return -1;
		}
		
		@Override
		public List<NestedInteger> getList() {
			return list;
		}
	}
	
	public static void main(String[] args) {
		// {1,{4,{6}}}
		NestedInteger n1 = new NestedIntegerImpl(1);
		NestedInteger n2 = new NestedIntegerImpl(4);
		NestedInteger n3 = new NestedIntegerImpl(6);
		List<NestedInteger> inputList = new ArrayList<NestedInteger>();
		inputList.add(n1);
		List<NestedInteger> List1 = new ArrayList<NestedInteger>();
		List1.add(n2);
		List<NestedInteger> List2 = new ArrayList<NestedInteger>();
		List2.add(n3);
		NestedInteger n4 = new NestedIntegerImpl(List2);
		List1.add(n4);
		NestedInteger n5 = new NestedIntegerImpl(List1);
		inputList.add(n5);
		
		System.out.print(depthSum(inputList));
	}
}

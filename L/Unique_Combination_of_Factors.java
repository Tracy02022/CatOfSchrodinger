/*
Unique Combination of Factors
打印一个数的所有乘数组合，从大到小，不要有重复
Print all unique combinations of factors of a positive integer. For example given 24:
24*1
12*2
8*3
6*4
6*2*2
4*3*2
3*2*2*2
*/
// DFS
// back tracking 
// time O(2^N), space O(N). ?
public class FactorsCombination {
	
	public static List<List<Integer>> factorCombinations(int n) {
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		dfs(ans, n, n / 2, new ArrayList<Integer>());
		return ans;
	}
	
	private static void dfs(List<List<Integer>> ans, int num, int largestFactor, List<Integer> path) {
		if (num == 1) {
			ans.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = largestFactor; i > 1; i--) {
			if (num % i == 0) {
				path.add(i);
				dfs(ans, num / i, i, path);
				path.remove(path.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.print(factorCombinations(24));
	}
}
/* 
output:
[[12, 2], [8, 3], [6, 4], [6, 2, 2], [4, 3, 2], [3, 2, 2, 2]]
*/

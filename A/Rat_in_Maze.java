/*
Rat in Maze
*/
/*
Naive Algorithm
while there are untried paths
{
   generate the next path
   if this path has all blocks as 1
   {
      print this path;
   }
}

Backtrackng Algorithm
If destination is reached
    print the solution matrix
Else
   a) Mark current cell in solution matrix as 1. 
   b) Move forward in horizontal direction and recursively check if this 
       move leads to a solution. 
   c) If the move chosen in the above step doesn't lead to a solution
       then move down and check if  this move leads to a solution. 
   d) If none of the above solutions work then unmark this cell as 0 
       (BACKTRACK) and return false.
*/
/*
boolean return type if statement 条件判断成功即返回，不成功继续下面 different with other return type
public class IFTest {
	public static boolean iFTest(int x) {
		if (x + 1 == 7) {
			return false;
		}
		if (x - 1 == 5) {
			return true;
		}
		if (x / 2 == 3) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.print(iFTest(6));
	}
}
// output: false
public class IFTest {
	public static boolean iFTest(int x) {
		boolean flag = false;
		if (x + 1 == 7) {
			return true;
		}
		if (x - 1 == 5) {
			return true;
		}
		if (x / 2 == 3) {
			return false;
		}
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.print(iFTest(6));
	}
}
// output: true
public class IFTest {
	public static String iFTest(int x) {
		if (x + 1 == 7) {
			System.out.print("Hello");
		}
		if (x - 1 == 5) {
			System.out.print("UMass");
		}
		if (x / 2 == 3) {
			System.out.print("Good");
		}
		return null;
	}
	
	public static void main(String[] args) {
		iFTest(6);
	}
}
// output: HelloUMassGood
public class IFTest {
	public static String iFTest(int x) {
		String y = null;
		if (x + 1 == 7) {
			y = "Hello";
		}
		if (x - 1 == 5) {
			y = "UMass";
		}
		if (x / 2 == 3) {
			y = "Good";
		}
		return y;
	}
	
	public static void main(String[] args) {
		System.out.print(iFTest(6));
	}
}
// output: Good
public class IFTest {
	public static boolean iFTest(int x) {
		boolean flag = false;
		if (x + 1 == 7) {
			flag = false;
		}
		if (x - 1 == 5) {
			flag = false;
		}
		if (x / 2 == 3) {
			flag = true;
		}
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.print(iFTest(6));
	}
}
// output: true
*/
public class Rat_in_Maze {
	
	public static boolean solveMaze(int[][] grid) {

		int rows = grid.length;
		int cols = grid[0].length;
		// boolean[][] visited = new boolean[rows][cols];
		int[][] visited = new int[rows][cols];
		
		if (!dfsHelper(0, 0, grid, visited)) {
			return false;
		}
		return true;
	}
	
	public static boolean dfsHelper(int i, int j, int[][] grid, int[][] visited) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 9) {
			visited[i][j] = 1;
			return true;
		}
		
		if (isSafe(grid, i, j) == true && visited[i][j] == 0) {
			visited[i][j] = 1;
			if (dfsHelper(i - 1, j, grid, visited)) {
				return true;
			} 
			if (dfsHelper(i, j + 1, grid, visited)) {
				return true;
			} 
			if (dfsHelper(i + 1, j, grid, visited)) {
				return true;
			}
			if (dfsHelper(i, j - 1, grid, visited)) {
				return true;
			} 
			visited[i][j] = 0;
			return false;
		}
		return false;
	}
	
	public static boolean isSafe(int[][] grid, int i, int j) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] maze = {
		                {1, 0, 1, 1, 1},
		                {1, 1, 0, 0, 1},
		                {0, 1, 0, 0, 1},
		                {0, 9, 1, 1, 1}};
		
		System.out.print(solveMaze(maze));	
	}
}

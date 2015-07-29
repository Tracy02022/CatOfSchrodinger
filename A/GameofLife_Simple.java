/*
给一个长度为8的array, 每个元素代表一个cell, 可为0或1, 如果该cell相邻两边的cell都一样, 那么该cell就变0, 反之变1. 最左边和最右边的左边和右边就算做0. 给你一个初始状态和天数, 一天一变, 输出最终的array结果.
e.g. 00111001 -> 01101110
*/
public class Game_of_Life {
	public static int[] gameOfLife(int[] start, int nights) {
		
		int cnt = 0;
	
		while (cnt < nights) {
			exchange(start);
			cnt++;
		}

		return start;
	}
	
	public static void exchange(int[] start) {
		
		int[] cells = new int[start.length];
		
		for (int i = 0; i < start.length; i++) {
			
			if (i - 1 < 0 && i + 1 <= start.length - 1) {
				if (start[i + 1] != 0) {
					cells[i] = 1;
				} else {
					cells[i] = 0;
				}
			} else if (i - 1 >= 0 && i + 1 > start.length - 1) {
				if (start[i - 1] != 0) {
					cells[i] = 1;
				} else {
					cells[i] = 0;
				}
			} else if (i - 1 >= 0 && i + 1 <= start.length - 1) {
				if (start[i + 1] != start[i - 1]) {
					cells[i] = 1;
				} else {
					cells[i] = 0;
				}
			}
		}
		
		for (int i = 0; i < start.length; i++) {
			if (cells[i] == 1) {
				start[i] = 1;
			} else if (cells[i] == 0) {
				start[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] start = {0, 0, 1, 1, 1, 0, 0, 1};
		
		int[] arr = gameOfLife(start, 7);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

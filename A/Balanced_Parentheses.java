public class Balanced_Parentheses {
	// time O(n) space O(n / 2) n is length of the string
	public static boolean isValid1(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		
		Stack<Character> stack = new Stack<Character>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {
				if (c == ')' || c == ']' || c == '}') {
					return false;
				} 
				stack.push(c);
				continue;
			} 
			
			if (c == ')' && stack.peek() == '('
					|| c == ']' && stack.peek() == '[' 
					|| c == '}' && stack.peek() == '{') {
				stack.pop();
			} else if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				return false; // notice here test string can not have blank or other chars.
			}
		}
		return stack.isEmpty();
	}
	
	public static boolean isValid2(String s) {
		if (s == null || s.length() % 2 == 1) {
			return false;
		}
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (map.containsValue(c)) {
				if (!stack.isEmpty() && map.get(stack.peek()) == c) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String test = "(())";
		System.out.print(isValid1(test));
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;
import java.util.Map.Entry; 

public class EmailCrawler_2 {
	
	private static class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
		
		@Override
		public int compare(Map.Entry<String, Integer> m, Map.Entry<String, Integer> n) {
			return n.getValue() - m.getValue(); // sort from large to small
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		String pattern = "^[a­zA­Z][\\d\\w\\.]{1,17}@[\\d\\w\\.]{1,}";
		File file = new File("regular_experssion.txt");
		Scanner input = new Scanner(file);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int val;
		while (input.hasNext()) {
			String s = input.next();
			s.trim();
			if (s.matches(pattern)) {
				System.out.println(s);
				s = s.substring(s.lastIndexOf('@') + 1);
				if (map.get(s) == null) {
					map.put(s, 1);
				} else {
					val = (Integer)map.get(s) + 1;
					map.put(s, val);
				}
			}
		}
		
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		EmailCrawler_2.ValueComparator vc = new ValueComparator();
		Collections.sort(list, vc);
		Iterator listItr = list.iterator();
		while (listItr.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)listItr.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}

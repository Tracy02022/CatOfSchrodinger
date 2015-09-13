import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCrawler {
	public static void main(String[] args) throws Exception {
		getMails_1();
	}
	
	public static void getMails_1() throws Exception {
		URL url = new URL("http://jingyan.baidu.com/article/647f01157ea4ca7f2148a8ce.html");
		URLConnection Conn = url.openConnection();
		BufferedReader bufin = new BufferedReader(new InputStreamReader(Conn.getInputStream()));
		String line = null;
		// String mailregex = "\\w+@\\w+(\\.\\w+)+";
		String mailregex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(mailregex);
		while ((line = bufin.readLine()) != null) {
			Matcher m = p.matcher(line);
			while (m.find()) {
				System.out.println(m.group());
			}
		}
	}
}

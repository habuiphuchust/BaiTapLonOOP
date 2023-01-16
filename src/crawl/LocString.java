package crawl;

public class LocString {
	static public String locSup (String s) {
		int star, end;
		while (s.indexOf('[') != -1) {
			star = s.indexOf('[');
			end = s.indexOf(']');
			s = s.substring(0, star) + s.substring(end+1);
		}
		return s;
		
	}

}

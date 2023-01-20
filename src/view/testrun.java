package view;


public class testrun {
	public static void main (String[] args) {
		String s = "sdh sa d  4 3 )";
		String v = s.replaceFirst("\\(.*\\)", "").trim();
		int i = s.indexOf('(');
//		String r = s.substring(i);
		System.out.println(v);
	}

}

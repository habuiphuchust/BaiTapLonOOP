package view;


public class testrun {
	public static void main (String[] args) {
		String text = "toi yeu viet nam";
//		for (int i = 3; i < text.length(); i = i + 4) {
//			while (text.charAt(i) != '\n' && text.charAt(i) == )
		text = text.replaceAll("(.{1,9})\\s+", "$1\n");
		System.out.println(text);
	}
}

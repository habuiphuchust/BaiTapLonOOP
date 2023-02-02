package view;

import utility.LowerCaseReplace;

public class testrun {
	public static void main (String[] args) {
		String s, v = " toi Yeu Viet Nam";
		s = LowerCaseReplace.replace(v, "yeu", "nam");
		System.out.println(s);
	}
}

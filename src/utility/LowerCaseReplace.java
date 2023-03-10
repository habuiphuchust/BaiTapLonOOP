package utility;
// thay the substring khong phan biet chu hoa chu thuong
//source https://stackoverflow.com/questions/5054995/how-to-replace-case-insensitive-literal-substrings-in-java
public class LowerCaseReplace {
	 public static String replace(String source, String target, String replacement)
	    {
	        StringBuilder sbSource = new StringBuilder(source);
	        StringBuilder sbSourceLower = new StringBuilder(source.toLowerCase());
	        String searchString = target.toLowerCase();

	        int idx = 0;
	        while((idx = sbSourceLower.indexOf(searchString, idx)) != -1) {
	            sbSource.replace(idx, idx + searchString.length(), replacement);
	            sbSourceLower.replace(idx, idx + searchString.length(), replacement);
	            idx+= replacement.length();
	        }
	        sbSourceLower.setLength(0);
	        sbSourceLower.trimToSize();
	        sbSourceLower = null;

	        return sbSource.toString();
	    }

}

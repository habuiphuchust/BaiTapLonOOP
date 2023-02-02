package utility;
//tim kiem khong phan biet chu hoa chu thuong va boi mau vang
//cai tien tu LowerCaseReplace.replace
public class Search {
	public static String search(String source, String target, String color)
    {
        StringBuilder sbSource = new StringBuilder(source);
        StringBuilder sbSourceLower = new StringBuilder(source.toLowerCase());
        String searchString = target.toLowerCase();

        int idx = 0;
        String replacement = null;
        while((idx = sbSourceLower.indexOf(searchString, idx)) != -1) {
        	replacement = "<span style=\"background-color:" + color + ";\">" + sbSource.substring(idx, idx + searchString.length()) +"</span>";
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

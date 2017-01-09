public class String {
	public static String reverseLiteral(String s1) {
		String s2 = "";
		for (int i = s1.length() -1; i >=0; i--) {
			s2 += s1.charAt(i);
		}
		return s2;
	}
	public static String reverseBuffer(String s1) {
		StringBuffer s2 = new StringBuffer();
		for (int i = s1.length(); i >= 0; i--) {
			s2.append(s1.charAt(i));
		}
		return s2.toString();
	}
}

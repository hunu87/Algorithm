public class LongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		
		int result = 0;
		int sLength = s.length();	
		
		if(s == null || s.length() == 0)
			return 0;
		
		if(sLength == 1)
			return 1;
		
		StringBuilder sumStr = new StringBuilder();
		char[] ch = new char[sLength];

		ch = s.toCharArray();		
		for(int i=0; i<ch.length; i++) {
			String str = String.valueOf(ch[i]);
			
			if(i == 0) {
				sumStr.append(str);
				continue;
			}
			
			if(sumStr.indexOf(str) < 0) {
				sumStr.append(str);
			}else {
				if(sumStr.indexOf(str) == sumStr.length()-1) {
					sumStr.delete(0, sumStr.length());	// 저장 문자열 초기화
				}else {
					sumStr.delete(0, sumStr.indexOf(str)+1);	// 저장 문자열 초기화
				}
				sumStr.append(str);		
			}
			
			if(sumStr.length() > result) {	// 저장 문자열이 최종 결과 result 값보다 길이가 큰 경우에만
				result = sumStr.length();
			}
		}
		
		if(result == 0 && sumStr != null) {
			return sumStr.length();
		}

		return result;
	}
	
	public static void main(String[] args) {
		
		LongestSubstring longestSubstring = new LongestSubstring();
		
		String s = "ohvhjdml";		
		System.out.println(longestSubstring.lengthOfLongestSubstring(s));
		
	}

}

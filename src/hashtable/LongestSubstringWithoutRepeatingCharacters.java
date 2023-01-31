package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		int rslt = lengthOfLongestSubstring("abba");
		System.out.println(rslt);
	}
    public static int lengthOfLongestSubstring(String s) {
        int rslt = 0;
        
        Map<Character, Integer> map = new HashMap<>();

        int strtIdx = 0;
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	
        	// substring의 시작 인덱스 이후에 해당 문자가 이미 존재한다면
        	if(map.containsKey(c) && map.get(c) >= strtIdx ) {
        		// 결과값 = 이전 결과값과 substring 길이 중 최대값
        		rslt = Math.max(rslt, i - strtIdx);
        		
        		// 시작인덱스 = 겹치는 이전 문자의 인덱스 다음부터 시작
        		strtIdx = map.get(c) + 1;
        	}
        	
        	map.put(c, i);
        }
        
        rslt = Math.max(rslt, s.length() - strtIdx);

        return rslt;
    }
}

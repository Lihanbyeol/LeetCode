import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int rslt = 0;
        
        Map<Character, Integer> map = new HashMap<>();

        int strtIdx = 0;
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	
        	// substring의 시작 인덱스 이후에 해당 문자가 이미 존재한다면
        	if(map.containsKey(c) && map.get(c) >= strtIdx ) {
        		rslt = Math.max(rslt, i - strtIdx);
        		
        		strtIdx = map.get(c) + 1;
        	}
        	
        	map.put(c, i);
        }
        
        rslt = Math.max(rslt, s.length() - strtIdx);

        return rslt;
    }
}
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
       int rslt = 0;
        
        Map<Character, Integer> map = new HashMap<>();

        int len = 0;
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	
        	// 이미 존재한다면
        	if(map.containsKey(c)) {
        		// 이전 결과값과 이번 substirng의 길이 비교하여 더 큰 값을 결과값으로 
        		rslt = Math.max(rslt, len);
        		
        		// 이전 인덱스 다음부터 다시 진행
        		i = map.get(c);
        		map.clear();
        		len = 0;
        		continue;
        	} else {
        		len++;
        	}
        	map.put(c, i);
        }
        
        rslt = Math.max(rslt, len);

        return rslt;
    }
}
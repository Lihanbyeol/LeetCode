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
        	
        	// substring�� ���� �ε��� ���Ŀ� �ش� ���ڰ� �̹� �����Ѵٸ�
        	if(map.containsKey(c) && map.get(c) >= strtIdx ) {
        		// ����� = ���� ������� substring ���� �� �ִ밪
        		rslt = Math.max(rslt, i - strtIdx);
        		
        		// �����ε��� = ��ġ�� ���� ������ �ε��� �������� ����
        		strtIdx = map.get(c) + 1;
        	}
        	
        	map.put(c, i);
        }
        
        rslt = Math.max(rslt, s.length() - strtIdx);

        return rslt;
    }
}

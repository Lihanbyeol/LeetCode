package string;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String rslt = longestPalindrome("aaa");
		System.out.println(rslt);
	}
    public static String longestPalindrome(String s) {
        String rslt = Character.toString(s.charAt(0));
        
        if(s.length() == 1) {
        	return s;
        }
        
        for(int i = 0; i < s.length() - 1; i++) {
        	// 현재까지 얻은 정답의 길이가 남은 문자열의 길이보다 길거나 같으면 STOP
        	if(rslt.length() >= s.length() - i) {
        		break;
        	}
        	
        	// 이번 반복문에서의 palindromic
        	String tmpRslt = "";
        	// 현재 문자
        	String current = Character.toString(s.charAt(i)); 
        	// 현재 문자과 동일한 문자의 인덱스
        	int nextIdx = s.indexOf(current, i + 1);
        	// 동일한 문자가 있다면 계속 반복
        	while(nextIdx > -1) {
        		
        		if(checkPalindromic(i, nextIdx, s)) {
        			String palindromic = s.substring(i, nextIdx + 1);
        			
        			if(palindromic.length() > tmpRslt.length()) {
        				tmpRslt = palindromic;
        			}
        		}
        	
        		// 다음 동일 문자로 이동
        		nextIdx = s.indexOf(current, nextIdx + 1);
        	}
        	
        	// 이번 palindromic의 길이가 기존 palindromic 길이보다 길다면
        	if(tmpRslt.length() > rslt.length()) {
        		rslt = tmpRslt;
        	}
        	
        }
        
        return rslt;
    }
    
    public static boolean checkPalindromic(int leftIdx, int rightIdx, String s) {
    	boolean bCheck = true;
    	while(leftIdx < rightIdx) {
    		char leftStr = s.charAt(leftIdx);
    		char rightStr = s.charAt(rightIdx);
    		
    		if(leftStr == rightStr) {
    			leftIdx++;
    			rightIdx--;
    		}
    		else {
    			bCheck = false;
    			break;
    		}
    	}
    	
    	return bCheck;
    }
}

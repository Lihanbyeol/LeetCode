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
        	// ������� ���� ������ ���̰� ���� ���ڿ��� ���̺��� ��ų� ������ STOP
        	if(rslt.length() >= s.length() - i) {
        		break;
        	}
        	
        	// �̹� �ݺ��������� palindromic
        	String tmpRslt = "";
        	// ���� ����
        	String current = Character.toString(s.charAt(i)); 
        	// ���� ���ڰ� ������ ������ �ε���
        	int nextIdx = s.indexOf(current, i + 1);
        	// ������ ���ڰ� �ִٸ� ��� �ݺ�
        	while(nextIdx > -1) {
        		
        		if(checkPalindromic(i, nextIdx, s)) {
        			String palindromic = s.substring(i, nextIdx + 1);
        			
        			if(palindromic.length() > tmpRslt.length()) {
        				tmpRslt = palindromic;
        			}
        		}
        	
        		// ���� ���� ���ڷ� �̵�
        		nextIdx = s.indexOf(current, nextIdx + 1);
        	}
        	
        	// �̹� palindromic�� ���̰� ���� palindromic ���̺��� ��ٸ�
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

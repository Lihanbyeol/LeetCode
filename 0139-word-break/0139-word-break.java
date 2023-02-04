import java.util.*;
class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean rslt = false;
        
        Set<String> set = new HashSet<>();
        for(String word : wordDict) {
        	set.add(word);
        }
        
        int[] visited = new int[s.length()];
        Arrays.fill(visited, -1);
        rslt = wordBreak(0, s, set, visited);

        return rslt;
    }
    
    public static boolean wordBreak(int start, String s, Set<String> set, int[] visited) {
    	boolean rslt = false;
    	
    	if(start >= s.length()) {
    		return true;
    	}
    	
    	if(visited[start] != -1) {
    		return visited[start] == 1 ? true : false;
    	}
    	
    	for(int i = start; i < s.length(); i++) {
    		String substr = s.substring(start,i+1);
    		if(set.contains(substr)) {
    			rslt = wordBreak(i+1, s, set, visited);
    			
    			if(rslt) {
    				break;
    			}
    		}
    	}
    	
    	visited[start] = rslt ? 1 : 0;
    	return rslt;
    }
}
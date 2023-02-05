import java.util.TreeSet;
class Solution {
    public int longestConsecutive(int[] nums) {
        int rslt = 0;
       
        if(nums.length == 0) {
        	return rslt;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        for(int num : nums) {
        	set.add(num);
        }
        
        int current = set.first();
        int length = 1;
        for(Integer next : set) {
        	if(next - 1 == current) {
        		length++;
        	}
        	else {
        		rslt = Math.max(rslt, length);
        		length = 1;
        	}
        	current = next;
        }
        
        rslt = Math.max(rslt, length);
        return rslt;
    }
}
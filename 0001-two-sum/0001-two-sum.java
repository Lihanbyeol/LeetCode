import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] rslt = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
        	map.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++) {
        	
        	if(map.containsKey(target - nums[i])
        			&& i != map.get(target - nums[i])) {
        		int aIdx = i;
        		int bIdx = map.get(target - nums[i]);
        		rslt[0] = aIdx;
        		rslt[1] = bIdx;
        		Arrays.sort(rslt);
        		return rslt;
        	}
        }
        return rslt;
    }
}
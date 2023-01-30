import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] rslt = new int[2];

        label : for(int i = 0; i < nums.length; i++) {
        	int first = nums[i];
        	for(int j = i+1; j < nums.length; j++) {
        		int second = nums[j];
        		if(first + second == target) {
        			rslt[0] = i;
        			rslt[1] = j;
        			break label;
        		}
        	}
        }
        
        return rslt;
    }
}
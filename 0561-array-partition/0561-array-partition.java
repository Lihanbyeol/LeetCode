import java.util.*;
class Solution {
    public int arrayPairSum(int[] nums) {
        int rslt = 0;

        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i += 2) {
        	rslt += nums[i];
        }
        return rslt;        
    }
}
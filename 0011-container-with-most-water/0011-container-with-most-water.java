class Solution {
    public int maxArea(int[] height) {
		int rslt = 0;

		if (height.length <= 1) {
			return rslt;
		}

		int left = 0;
		int right = height.length - 1;
		
		while(left < right) {
			int x = right - left;
			int y = Math.min(height[left], height[right]);
			rslt = Math.max(rslt, x*y);
			
			if(height[left] > height[right]) {
				right--;
			}
			else {
				left++;
			}
		}
		
		return rslt;
    }
}
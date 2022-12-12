class MaxConsecutiveOnes {
   public int longestOnes(int[] nums, int k) {
        int windowStart = 0; 
        int maxLen = 0; 
        int counterOnes = 0;
        
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if(nums[windowEnd] == 1) {
               counterOnes++;
            }
            if(windowEnd - windowStart + 1 - counterOnes > k) {
               if( nums[windowStart] == 1 ) {
                   counterOnes--;
               }
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart +1);
        }
        return maxLen;
    }
}
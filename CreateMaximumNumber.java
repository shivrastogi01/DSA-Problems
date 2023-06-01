class CreateMaximumNumber{
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[k];
        int[] tempRes = null;
        
        // enumerate all the possible ways to construct an array with len k from two arrays
        // the length of the res is k 
        // we assume that we pick k1 numbers from nums1, therefore we pick (k - k1) numbers
        // from nums2. The possible range of k1 is from Math.max(0, k-len2)
        // to Math.min(len1, k);
        for(int k1 = Math.max(0, k-len2); k1 <= Math.min(len1, k); k1++){
            int[] num1Max = findMaxSubsequence(nums1, k1);
            int[] num2Max = findMaxSubsequence(nums2, k - k1);
            tempRes = merge(num1Max, num2Max);
            if(isGreater(tempRes, 0, res, 0)){
                res = tempRes;
            }
        }
        return res;
    }
    
    // find the largest number that can be constructed from two arrays
    private int[] merge(int[] nums1, int[] nums2){
        int[] res = new int[nums1.length + nums2.length];
        int p1 = 0, p2 = 0, p3 = 0;
        
        while(p3 < res.length){
            res[p3++] = isGreater(nums1, p1, nums2, p2) ? nums1[p1++] : nums2[p2++];     
        }
        return res;
    }
    
    private boolean isGreater(int[] nums1, int p1, int[] nums2, int p2){
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] > nums2[p2]){
                return true;
            }else if(nums1[p1] < nums2[p2]){
                return false;
            }
            p1++;
            p2++;
        }
        return p1 != nums1.length;
    }
    
    // this subroutine is similar to leetcode 1673
    private int[] findMaxSubsequence(int[] num, int len){
        if(num.length == len){return num;}
        
        int[] stack = new int[len];
        int top = -1;
        int canRemoveCnt = num.length - len;
        
        for(int i = 0; i < num.length; i++){
            int curNum = num[i];
            
            while(top >= 0 && canRemoveCnt > 0 && curNum > stack[top]){
                top--;
                canRemoveCnt--;
            }
            
            if(top + 1 < stack.length){
                stack[++top] = curNum;     
            }else{
                canRemoveCnt--;
            }
        }
        
        return stack;
    }
}
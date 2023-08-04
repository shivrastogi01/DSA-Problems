class SumOfSubArrayRanges{
    // subArrayRanges = sumSubarrayMaxs - sumSubarrayMins
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;

        Deque<Integer> s = new LinkedList<>();
        // 1. subArrayRanges -= sumSubarrayMins (907. Sum of Subarray Minimums)
        for (int i = -1; i <= n; i++) {
            while (!s.isEmpty() && getElement1(nums, s.peek()) > getElement1(nums, i)) {
                int currIdx = s.pop();
                int left = s.peek(), right = i;
                res -= (long) nums[currIdx] * (currIdx - left) * (right - currIdx);
            }
            s.push(i);
        }

        // 2. subArrayRanges += sumSubarrayMaxs
        for (int i = -1; i <= n; i++) {
            while (!s.isEmpty() && getElement2(nums, s.peek()) < getElement2(nums, i)) {
                int currIdx = s.pop();
                int left = s.peek(), right = i;
                res += (long) nums[currIdx] * (currIdx - left) * (right - currIdx);
            }
            s.push(i);
        }

        return res;
    }

    private int getElement1(int[] arr, int i) {
        return (i == -1 || i == arr.length) ? Integer.MIN_VALUE : arr[i];
    }

    private int getElement2(int[] arr, int i) {
        return (i == -1 || i == arr.length) ? Integer.MAX_VALUE : arr[i];
    }
}
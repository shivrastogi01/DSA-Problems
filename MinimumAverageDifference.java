class MinimumAverageDifference {
    public int minimumAverageDifference(int[] sums) {
        long[] arr = new long[sums.length];
        long sum = 0;
        for(int i = 0; i < sums.length; i++){
            sum += sums[i];
            arr[i] = sum;
        }
        
        long min = Integer.MAX_VALUE;
        long max = arr[arr.length - 1];
        int index = 0;
        
        for(int i = 0; i < arr.length; i++){
            long current = arr[i] / (i + 1);
            int temp = arr.length - i - 1;
            long remain = (max - arr[i]) / (temp == 0 ? 1 : temp);
            long result = Math.abs(current - remain);
            
            if(result < min){
                min = result;
                index = i;
            }
        }
        
        return index;
        
    }
}
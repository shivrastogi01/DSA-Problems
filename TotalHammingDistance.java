class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        long mask = 1L<<31;
        int totalans =0;
        while(mask!=0){
            int count =0;
            for(int i = 0;i<nums.length;i++){
               if((mask&nums[i])>=1){
                   count++;
               }
            }
            mask=mask>>1;
            totalans = totalans+((nums.length-count)*(count));
        }
        return totalans;
    }
}
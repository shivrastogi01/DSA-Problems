class ValidTriangleNumber{
public int triangleNumber(int[] nums) {

    int ans=0,n=nums.length;
    Arrays.sort(nums);
    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            int sum=nums[i]+nums[j];
            int low=j+1,high=n-1,ind=-1;
            while(low<=high)
            {
                int mid=(high+low)/2;
                if(sum>nums[mid])
                {
                  ind=mid;
                  low=mid+1;  
                }
                else
                {
                   high=mid-1; 
                }
            }
           //System.out.print(ind+" ");
            if(ind!=-1)
            {
                ans+=(ind-j);
            }
        }
    }
    return ans;
}
}
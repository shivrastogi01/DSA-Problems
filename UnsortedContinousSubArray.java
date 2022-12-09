class UnsortedContinousSubArray {
public int findUnsortedSubarray(int[] arr) {
    
    int n = arr.length;
    int mini = Integer.MAX_VALUE;
    int left = 0;
    
    for(int i=n-1; i>=0; i--){
        mini = Math.min(mini, arr[i]);
        if(mini!=arr[i]){
            left = i;
        }
    }
    
    int maxi = Integer.MIN_VALUE;
    int right = 0;
    
    for(int i=0; i<n; i++){
        maxi = Math.max(maxi, arr[i]);
        if(maxi!=arr[i]){
            right = i;
        }
    }
    
    if(left==0 && right==0){
        return 0;
    }
    
    return (right-left+1);
}
}
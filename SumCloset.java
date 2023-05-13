class SumCloset {
public int threeSumClosest(int[] nums, int target) {
int result =nums[0] + nums[1] + nums[2];
int output =nums[0] + nums[1] + nums[2];
for(int i=0; i<nums.length-2;i++){
for(int j=1;j<nums.length-1;j++){
for(int k=2;k<nums.length; k++){
if((i==j)||(i==k)||(j==k)){
}
else{
output = nums[i] + nums[j] + nums[k];
}
if(Math.abs(output-target)<Math.abs(result-target)){
result = output;
}
}
}
}
return result;
}
}
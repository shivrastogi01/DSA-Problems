class SumWithMultiplicity {
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Long> map = new HashMap<>();
        for(int e : arr){
             long freq = map.getOrDefault(e,0l);
             map.put(e,freq+1l);
     }
        long ans=0l;
        for(int e1: map.keySet()){
            for(int e2: map.keySet()){
                int e3 = target-e1-e2;
                if(map.containsKey(e3)){
                    long freq1 = map.get(e1);
                    long freq2 = map.get(e2);
                    long freq3 = map.get(e3);
                    if(e1==e2 && e2==e3)
                    ans+=((freq1)*(freq2-1)*(freq3-2))/6;
                else if(e1==e2 && e1!=e3)
                    ans+=((freq1)*(freq2-1))/2*freq3;
                else if(e1<e2 && e2<e3)
                    ans+=freq1*freq2*freq3;
               
                }
               ans = ans%1000000007; 
                
            }
             
        }
           return (int)ans;
        
    }
}
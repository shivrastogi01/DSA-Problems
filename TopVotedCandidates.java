class TopVotedCandidates{

TreeMap<Integer,Integer> map;
HashMap<Integer,Integer> Pmap;
int y=0;
public TopVotedCandidate(int[] persons, int[] times) {
    map=new TreeMap<>();
    Pmap=new HashMap<>();
    
    int l=persons.length;
    y=l;
    
    int max=0;
    int maxP=-1;
    
    for(int i=0;i<l;i++){
        int p=persons[i];
        int t=times[i];
        
        Pmap.putIfAbsent(p,0);
        Pmap.put(p,Pmap.get(p)+1);
        
        int y=Pmap.get(p);
        
        if(max<=y){
            max=y;
            maxP=p;
        }
        
        
        map.put(t,maxP);
    }
    
    
}

public int q(int t) {
    
    Integer ti=map.floorKey(t);
    
    if(ti==null)
        return -1;
    
    return map.get(ti);
}
}
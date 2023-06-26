class SuperWashingMachine {
    public int findMinMoves(int[] machines) {
        int total=0;
        for(int machine:machines) total+= machine;
        if(total%machines.length!=0) return -1;
        int goal = total/machines.length;
                
        int maxChanges=0, totalSoFar=0;
        for(int i=0; i<machines.length; i++){
            totalSoFar+=machines[i];            //Sum of dresses in machines so far [0...i]
            
            //So far have too many dresses or need more dresses
            maxChanges = Math.max(maxChanges, Math.abs((i+1)*goal-totalSoFar));
            
            //Current machine has too many dresses
            maxChanges = Math.max(maxChanges, machines[i]-goal);
        }
        
        return maxChanges;
    }
}
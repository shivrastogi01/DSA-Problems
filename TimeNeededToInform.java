class TimeNeededToInform {
    public int numOfMinutes(int n, int headID, int[] m, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m.length; ++i){
            if(m[i] == -1){
                
                continue;
            }
            adj.get(m[i]).add(i);
        }
        int max = dfs(adj, time, headID);
        return max;
    }
    
    private int dfs(List<List<Integer>> adj,  int time[], int node){
        int max = 0;
        
        for(int i : adj.get(node)){
            max = Math.max(max, dfs(adj, time, i));
        }
        return max + time[node];
    }
}
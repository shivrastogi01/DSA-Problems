class SwimInWater{
    public int swimInWater(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)-> a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        
        int totalTime = 0;
        int currentTime = 0;
        while(!pq.isEmpty())
        {
            int[] temp = pq.poll();
            int row = temp[0];
            int col = temp[1];
            int height = temp[2];
            
            grid[row][col] = -1;
            if(height > currentTime)
            {
                totalTime += height - currentTime;
                currentTime = height;   
            }

            if(row == m-1 && col == n-1) return totalTime;
            
            if(row+1 < m && grid[row+1][col] != -1) pq.add(new int[]{row+1,col,grid[row+1][col]});
            if(row-1 >= 0 && grid[row-1][col] != -1) pq.add(new int[]{row-1,col,grid[row-1][col]});
            
            if(col+1 < n && grid[row][col+1] != -1) pq.add(new int[]{row,col+1,grid[row][col+1]});
            if(col-1 >= 0 && grid[row][col-1] != -1) pq.add(new int[]{row,col-1,grid[row][col-1]});
            
        }
        return -1;
    
    }
}
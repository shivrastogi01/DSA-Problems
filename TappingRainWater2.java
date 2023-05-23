class TappingRainWater2{
    public static class Pair implements Comparable<Pair>{
		int x;
		int y;
		int height;
		
		Pair(int x, int y, int height){
			this.x = x;
			this.y = y;
			this.height = height;
		}
		
		public int compareTo(Pair o) {
			return this.height - o.height;
		}
	}
    
    public int trapRainWater(int[][] hgts) {
          int n = hgts.length;
          int m = hgts[0].length;
          boolean[][] vis = new boolean[n][m];
          PriorityQueue<Pair> pq = new PriorityQueue<>();

          for(int i = 0; i < n; i++) {
              for(int j = 0; j < m; j++) {
                  if(i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                      pq.add(new Pair(i, j, hgts[i][j]));
                      vis[i][j] = true;
                  }
              }
          }
          int[][] calls = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
          int ans = 0;

          while(pq.size() > 0) {
              Pair rem = pq.remove();
              for(int i = 0; i < calls.length; i++) {
                  int newi = rem.x + calls[i][0];
                  int newj = rem.y + calls[i][1];

                  if(newi >= 0 && newj >= 0 && newi < n && newj < m && vis[newi][newj] == false) {
                      if(hgts[newi][newj] < rem.height)
                          ans += rem.height - hgts[newi][newj];
                      vis[newi][newj] = true;
                      pq.add(new Pair(newi, newj, Math.max(hgts[newi][newj], rem.height)));
                  }
              }
          }

          return ans;
    }
}
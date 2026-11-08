class Solution {
    class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x; 
            this.y = y;
        }
    }
    private boolean isValid(int n, int m, int x, int y){
        return(x >= 0 && y >= 0 && x < n && y < m);
    }
    public int findMaxFish(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int n = grid.length; 
        int m = grid[0].length;
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        int ans = Integer.MIN_VALUE; 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int area = 0; 
                if(grid[i][j] != 0 && !vis[i][j]){
                    vis[i][j] = true;
                    q.offer(new Pair(i, j));
                    area += grid[i][j];
                }
                
                while(!q.isEmpty()){
                    Pair p = q.poll();
                    int x = p.x;
                    int y = p.y;
                    for(int k = 0; k < 4; k++){
                        int adjX = x + dr[k];
                        int adjY = y + dc[k];
                        if(isValid(n, m, adjX, adjY) && grid[adjX][adjY] != 0 && !vis[adjX][adjY]){
                            area+= grid[adjX][adjY];
                            vis[adjX][adjY] = true;
                            q.offer(new Pair(adjX,adjY));
                        }
                        

                    }

                }
                ans = Math.max(area, ans);
            }
        }
        if(ans == Integer.MIN_VALUE) return 0;
        else return ans;
              
    }
}
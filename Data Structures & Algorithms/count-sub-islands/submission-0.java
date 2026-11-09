class Solution {
    class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x; 
            this.y = y; 
        }
    }
    private boolean isValid(int n, int m, int x, int y){
        return(x>=0 && y >= 0 && x < n && y < m);
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length; 
        int m = grid1[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int ans = 0; 
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
               
                if(grid2[row][col] == 1 && !vis[row][col]){
                    q.offer(new Pair(row, col));
                    vis[row][col] = true;
                    boolean isSubIslands = true; 
                
                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        int x = p.x;
                        int y = p.y;


                        if(grid1[x][y] == 0) isSubIslands = false;

                        for(int i = 0; i < 4; i++){
                            int adjX = dr[i] + x;
                            int adjY = dc[i] + y;

                            if(isValid(n, m, adjX, adjY) && !vis[adjX][adjY] && grid2[adjX][adjY] == 1){
                                q.offer(new Pair(adjX, adjY));
                                vis[adjX][adjY] = true;
                            }
                        }
                    }
                    if(isSubIslands){
                        ans++;
                    }
                }
                
            }
        }
        return ans;
    }
}
class Solution {
    class Pair{
        int row; 
        int col; 
        public Pair(int n, int m){
            this.row = n;
            this.col = m;
        }
    }
    public int numIslands(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    q.offer(new Pair(i,j));
                    visited[i][j] = true;
                    ans++;
                    while(!q.isEmpty()){
                        Pair node = q.poll();
                        int n = node.row;
                        int m = node.col;
                        if(n+1 < grid.length && grid[n+1][m] == '1' && !visited[n+1][m]){
                            q.offer(new Pair(n+1, m));
                            visited[n+1][m] = true;
                        }
                        if(n-1 >= 0 && grid[n-1][m] == '1' && !visited[n-1][m]){
                            q.offer(new Pair(n-1, m));
                            visited[n-1][m] = true;
                        }
                        if(m+1 < grid[0].length && grid[n][m+1] == '1' && !visited[n][m+1]){
                            q.offer(new Pair(n, m+1));
                            visited[n][m+1] = true;
                        }
                        if(m-1 >= 0  && grid[n][m-1] == '1' && !visited[n][m-1]){
                            q.offer(new Pair(n, m-1));
                            visited[n][m-1] = true;
                        }

                    }
                }
            }
        }
        return ans;
    }
}
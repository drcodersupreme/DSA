class Solution {
    class Pair{
        int row;
        int col; 
        public Pair(int n , int m){
            this.row = n;
            this.col = m;
        }
    }
    private int bfs(int grid[][]){
        int ans[][] = grid;
        int min = 0;
        Queue<Pair> q = new LinkedList<>();
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        
       for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) q.offer(new Pair(i, j));
            }
       }
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int j = 0; j < size; j++){  
                int nrow = q.peek().row;
                int ncol = q.peek().col;
                q.poll();  
                for(int i = 0; i < 4; i++){
                    int newrow =  nrow + delRow[i];
                    int newcol = ncol + delCol[i];
                    if(newrow >= 0 && newrow < grid.length && newcol >= 0 && newcol < grid[0].length && ans[newrow][newcol] == 1){
                        q.offer(new Pair(newrow, newcol));
                        ans[newrow][newcol] = 2;
                    }
                }
            }
            if(!q.isEmpty()) min++;
        } 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(ans[i][j] == 1) {
                    return -1;
                }
            }
        }

        return min;
    }

    public int orangesRotting(int[][] grid) {
        return bfs(grid);
    }
}
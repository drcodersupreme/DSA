class Solution {
    class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private boolean isValid(int n, int m, int x, int y){
        return (x >= 0 && y >= 0 && x < n && y < m);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        // Pacific 
        boolean pac[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            q.offer(new Pair(0, i));
            pac[0][i] = true;
        }
        for(int i = 0; i < n; i++){
            q.offer(new Pair(i, 0));
            pac[i][0] = true;
        }
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int val = heights[x][y];
            for(int i = 0; i < 4; i++){
                int adjX = x + dr[i];
                int adjY = y + dc[i];

                if(isValid(n, m, adjX, adjY) && heights[adjX][adjY] >=  val && !pac[adjX][adjY]){
                    q.offer(new Pair(adjX, adjY));
                    pac[adjX][adjY] = true;
                }
            }
        }

        //  Atlantic 
        boolean atl[][] = new boolean[n][m];
        Queue<Pair> qu = new LinkedList<>();
        for(int i = 0; i < m; i++){
            qu.offer(new Pair(n-1, i));
            atl[n-1][i] = true;
        }
        for(int i = 0; i < n-1; i++){
            qu.offer(new Pair(i, m-1));
            atl[i][m-1] = true;
        }
        while(!qu.isEmpty()){
            Pair p = qu.poll();
            int x = p.x;
            int y = p.y;
            int val = heights[x][y];
            for(int i = 0; i < 4; i++){
                int adjX = x + dr[i];
                int adjY = y + dc[i];

                if(isValid(n, m, adjX, adjY) && heights[adjX][adjY] >=  val && !atl[adjX][adjY]){
                    qu.offer(new Pair(adjX, adjY));
                    atl[adjX][adjY] = true;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        // Checking common 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(atl[i][j] && pac[i][j]){
                    ans.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return ans;


    }
}
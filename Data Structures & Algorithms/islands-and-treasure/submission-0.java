
class Solution {
    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean isValid(int n, int m, int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < m);
    }

    public void islandsAndTreasure(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};

        // Step 1: Insert all treasure cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        // Step 2: Multi-source BFS
        while (!q.isEmpty()) {

            Pair p = q.poll();

            int x = p.x;
            int y = p.y;

            for (int k = 0; k < 4; k++) {

                int adjX = x + dr[k];
                int adjY = y + dc[k];

                if (isValid(n, m, adjX, adjY) && grid[adjX][adjY] == Integer.MAX_VALUE) {

                    grid[adjX][adjY] = grid[x][y] + 1;

                    q.offer(new Pair(adjX, adjY));
                }
            }
        }
    }
}

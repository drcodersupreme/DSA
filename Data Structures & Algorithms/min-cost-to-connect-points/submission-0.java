
class Solution {
    class Pair {
        int node, wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.wt, b.wt)
        );

        boolean vis[] = new boolean[n];

        pq.offer(new Pair(0, 0));

        int sum = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {

            Pair p = pq.poll();

            int node = p.node;
            int wt = p.wt;

            if (vis[node]) continue;

            vis[node] = true;
            sum += wt;
            count++;

            int x = points[node][0];
            int y = points[node][1];

            for (int i = 0; i < n; i++) {

                if (!vis[i]) {

                    int adjX = points[i][0];
                    int adjY = points[i][1];

                    int dist = Math.abs(adjX - x) + Math.abs(adjY - y);

                    pq.offer(new Pair(i, dist));
                }
            }
        }

        return sum;
    }
}

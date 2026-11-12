class Solution {
    class Pair{
        int val, wt; 
        public Pair(int val, int wt){
            this.val = val; 
            this.wt = wt; 
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.wt, b.wt);
        });
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0; i <= n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[] : times){
            graph.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        pq.offer(new Pair(k, 0));
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; 
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.val; 
            for(Pair temp : graph.get(u)){
                int v = temp.val; 
                int adjWt = temp.wt; 
                if(dist[v] > adjWt + dist[u]){
                    pq.offer(new Pair(v, adjWt + dist[u]));
                    dist[v] = adjWt + dist[u];
                }
            }
        }
        int ans = -1; 
        for(int i = 1; i < dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1; 
            ans = Math.max(ans, dist[i]);
        }
        return ans;

    }
}
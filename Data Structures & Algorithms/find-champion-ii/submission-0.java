class Solution {
    public int findChampion(int n, int[][] edges) {
        int indegree[] = new int[n];
        for(int i = 0; i < edges.length; i++){
            indegree[edges[i][1]]++;
        }
        int champions = 0;
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) champions++;
        }
        if(champions > 1) return -1;
        else{
            for(int i = 0; i < n; i++){
                if(indegree[i] == 0) return i;
            }
        }
        return -1;
    }
}
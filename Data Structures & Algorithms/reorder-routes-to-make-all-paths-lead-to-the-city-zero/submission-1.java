class Solution {
    public int minReorder(int n, int[][] connections) {
List<int[]>[] graph=new ArrayList[n];for(int i=0;i<n;i++)graph[i]=new ArrayList<>();for(int[] edge:connections){graph[edge[0]].add(new int[]{edge[1],1});graph[edge[1]].add(new int[]{edge[0],0});}Deque<int[]> stack=new ArrayDeque<>();stack.push(new int[]{0,-1});int answer=0;while(!stack.isEmpty()){int[] item=stack.pop();for(int[] edge:graph[item[0]])if(edge[0]!=item[1]){answer+=edge[1];stack.push(new int[]{edge[0],item[0]});}}return answer;
}
}

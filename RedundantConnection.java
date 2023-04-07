class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < edges.length + 1; i++)graph.add(new ArrayList<>());
        for(int[] edge :edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            if(isCyclic(graph, v))return edge;
        }
        return new int[]{};
    }
    public boolean isCyclic(List<List<Integer>> graph, int src){
        boolean[] vis = new boolean[graph.size()];
        return isCyclePresentUntill(graph, vis, src);
    }
    public boolean isCyclePresentUntill(List<List<Integer>> graph, boolean[] vis, int src){
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        while(que.size() > 0){
            int front = que.remove();
            if(vis[front])return true;
            vis[front] = true;
            for(int nbr : graph.get(front)){
                if(!vis[nbr])que.add(nbr);
            }
        }
        return false;
    }
}
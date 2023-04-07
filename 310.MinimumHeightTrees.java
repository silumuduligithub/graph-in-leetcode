class Solution {
    public List<List<Integer>> makeGraph(int[][] edges, int V, int[] indegree){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++)graph.add(new ArrayList<>());
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            indegree[v]++;
            indegree[u]++;
        }
        return graph;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // if(edges.length == 0)return 0;
        List<Integer> res = new ArrayList<>();
        if(edges.length == 0){
            res.add(0);
            return res;
        }
        int[] ind = new int[n];
        List<List<Integer>> graph = makeGraph(edges, n, ind);
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(ind[i] == 1){
                que.add(i);
                ind[i]--;
            }
        }
        while(que.size() > 0){
            int size = que.size();
            res.clear();
            while(size-- > 0){
                int front = que.remove();
                res.add(front);
                for(int nbr : graph.get(front)){
                    ind[nbr]--;
                    if(ind[nbr] == 1)que.add(nbr);
                }
            }
        }
        return res;
    }
}
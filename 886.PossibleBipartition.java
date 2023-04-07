class Solution {
    class Pair{
        int node;
        int color;
        Pair(int node, int color){
            this.node = node;
            this.color = color;
        }
    }
    public List<List<Integer>> createGraph(int n, int Edges[][]){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : Edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
    public boolean possibleBipartition(int n, int[][] Edges) {
        // lets create the graph
        // as the edges are given one index based so we have to add n + 1 arrayList
        List<List<Integer>> graph = createGraph(n,Edges);
        // check bipartition or not normal bfs
        int vis[] = new int[n + 1];
        for(int i = 0; i <= n; i++){
            if(vis[i] != 0)continue;
            Queue<Pair> que = new LinkedList<>();
            // lets 1 for blue and -1 for red
            que.add(new Pair(i, -1));
            while(que.size() > 0){
                Pair cur = que.remove();
                if(vis[cur.node] != 0)continue;
                vis[cur.node] = cur.color;
                int oppscolor = vis[cur.node] == 1 ? -1 : 1;
                for(int nbr : graph.get(cur.node)){
                    // adject nbr is colorness
                    if(vis[nbr] == 0){
                        que.add(new Pair(nbr, oppscolor));
                    }
                    // adject nbr is colored and and the opposite color and the cur color is same so we can't bipartate
                    else if(vis[nbr] == cur.color){
                        return false;
                    }
                    // if it is already colored lets continue;
                    else continue;
                }
            }
        }
        return true;
    }
}

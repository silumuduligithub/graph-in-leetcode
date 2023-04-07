class Solution {
    class Edge{
        int nbr;
        int wt;
        Edge(int nbr, int wt){
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)graph.add(new ArrayList<>());
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                //calculating the mangattan distance
                int x1 = points[i][0];
                int x2 = points[j][0];
                int y1 = points[i][1];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                graph.get(i).add(new Edge(j, dist));
                graph.get(j).add(new Edge(i, dist));
            }
        }
        int wtOfMst = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b)->{
            return a.wt - b.wt;
        });
        boolean vis[] = new boolean[n];
        pq.add(new Edge(0, 0));
        while(pq.size() > 0){
            Edge cur = pq.remove();
            int node = cur.nbr;
            if(vis[node]) continue;
            vis[node] = true;
            wtOfMst += cur.wt;
            for(Edge e : graph.get(node)){
                if(!vis[e.nbr])pq.add(e);
            }
        }
        return wtOfMst;
    }
}
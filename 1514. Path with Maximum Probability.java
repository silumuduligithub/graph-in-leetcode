class Solution {
    class Pair{
        int node;
        double wt;
        Pair(int node, double wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair>[] g = new List[n];
        // Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            double s = succProb[i];
            g[a].add(new Pair(b, s));
            g[b].add(new Pair(a, s));
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)->{
            double ans = a.wt - b.wt;
            return (int)ans;
        });
        double[] d = new double[n];
        d[start] = 1.0;
        q.add(new Pair(start, -1.0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            double w = p.wt;
            w *= -1;
            int u = p.node;
            for (Pair ne : g[u]) {
                int v = ne.node;
                double t = ne.wt;
                if (d[v] < d[u] * t) {
                    d[v] = d[u] * t;
                    q.add(new Pair(v, -d[v]));
                }
            }
        }
        return d[end];
    }
}
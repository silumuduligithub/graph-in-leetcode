class Solution {
    public List<List<Integer>> makeGraph(int n, int[][] connections, Set<String>set){
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)graph.add(new ArrayList<>());
        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            StringBuilder sb = new StringBuilder();
            sb.append(u);
            sb.append(" ");
            sb.append(v);
            set.add(sb.toString());
        }
        return graph;
    }
    public int minReorder(int n, int[][] connections) {
        Set<String> set = new HashSet<>();
        List<List<Integer>> graph = makeGraph(n, connections, set);
        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        int total = 0;
        while(que.size() > 0){
            int cur = que.remove();
            if(vis[cur])continue;
            vis[cur] = true;
            for(int nbr : graph.get(cur)){
                String str = "";
                str += nbr+"";
                str += " ";
                str += cur+"";
                if(!vis[nbr]){
                    if(!set.contains(str))total++;
                    que.add(nbr);
                }
            }
        }
        return total;
    }
}
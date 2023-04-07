class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        dfs(0, graph.length - 1, graph, cur, paths);
        return paths;
    }
    public void dfs(int src, int dest, int[][] graph, List<Integer> cur, List<List<Integer>> paths){
        if(src == dest){
            paths.add(new ArrayList<>(cur));
            return;
        }
        for(int nbr : graph[src]){
            cur.add(nbr);
            dfs(nbr, dest, graph, cur, paths);
            cur.remove(cur.size() - 1);
        }
    }
}
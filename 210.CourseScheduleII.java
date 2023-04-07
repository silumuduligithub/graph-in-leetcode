class Solution {
    public List<List<Integer>> makeGraph(int V, int [][] Edges, int[] indg){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++)graph.add(new ArrayList<>());
        for(int[] edge : Edges){
            int ai = edge[0];
            int bi = edge[1];
            graph.get(bi).add(ai);
            indg[ai]++;
        }
        return graph;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = makeGraph(numCourses, prerequisites, indegree);
        Queue<Integer> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)que.add(i);
        }
        while(que.size() > 0){
            int cur = que.remove();
            ans.add(cur);
            for(int nbr : graph.get(cur)){
                indegree[nbr]--;
                if(indegree[nbr] == 0)que.add(nbr);
            }
        }
        if(ans.size() != numCourses)return new int[0];
        int arr[] = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)arr[i] = ans.get(i);
        return arr;
    }
}
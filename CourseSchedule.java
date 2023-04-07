// this algorithem is called topological sort 
// time complexity is o(n) and the space complexity is o(n)
class Solution {
    public List<List<Integer>> graphInorder(int V, int[][] Edges, int[] inorder){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++)graph.add(new ArrayList<>());
        for(int[] E : Edges){
            int ai = E[0];
            int bi = E[1];
            graph.get(bi).add(ai);
            inorder[ai]++;
        }
        return graph;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inorder = new int[numCourses];
        List<List<Integer>> graph = graphInorder(numCourses, prerequisites, inorder);
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == 0)que.add(i);
        }
        List<Integer> al = new ArrayList<>();
        while(que.size() > 0){
            int front = que.remove();
            al.add(front);
            for(int nbr : graph.get(front)){
                inorder[nbr]--;
                if(inorder[nbr] == 0)que.add(nbr);
            }
        }
        if(al.size() == inorder.length)
            return true;
       else  return false;
    }
}
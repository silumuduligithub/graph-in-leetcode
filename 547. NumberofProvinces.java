class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean []visited = new boolean[isConnected.length];
        int numProvinces = 0;
        for (int city = 0; city < isConnected.length; city++) {
            if (visited[city]) continue;
            numProvinces++;
            Queue<Integer> que = new LinkedList<>();
            que.add(city);
            while (que.size() > 0) {
                int visitedCity = que.remove();
                if(visited[visitedCity])continue;
                visited[visitedCity] = true;
                for(int neb = 0; neb < isConnected.length; neb++) {
                    if (isConnected[visitedCity][neb] == 1 && !visited[neb]) {
                        que.add(neb);
                    }
                }
            }
        }
        return numProvinces;
    }
}
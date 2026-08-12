class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : invocations) {
            graph[edge[0]].add(edge[1]);
        }

        boolean[] suspicious = new boolean[n];

        dfs(k, graph, suspicious);

        // If an outside method invokes a suspicious method,
        // we cannot remove anything.
        for(int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if(!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for(int i=0; i<n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(!suspicious[i]) ans.add(i);
        }

        return ans;
    }

    private void dfs(int curr, List<Integer>[] graph, boolean[] vis) {
        vis[curr] = true;

        for(int neigh : graph[curr]) {
            if(!vis[neigh]) {
                dfs(neigh, graph, vis);
            }
        }
    }
}
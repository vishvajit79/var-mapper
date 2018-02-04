package io.qhacks.var_mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Emilio K on 2018-02-03.
 */

public class PathFinder {
    public class BreadthFirstPathFinder {
        // http://www.oxfordmathcenter.com/drupal7/node/672

        private final int s; // Source node
        private int[] edgeTo;
        private boolean[] marked;

        public BreadthFirstPathFinder(List<Cluster> g, int s) {

            marked = new boolean[g.size()];  // build marked array
            edgeTo = new int[g.size()];      // build edgeTo array

            this.s = s;
            bfs(g, s);
        }

        private void bfs(List<Cluster> g, int s) {
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            marked[s] = true;
            while (!q.isEmpty()) {
                int v = q.remove();
                for (int w : g.get(v).getClusterJoints().keySet()) {
                    if (!marked[w]) {
                        q.add(w);
                        marked[w] = true;
                        edgeTo[w] = v;
                    }
                }
            }
        }

        public boolean hasPathTo(int v) {
            return marked[v];
        }

        public List<Integer> shortestPathTo(int v) {
            if (!hasPathTo(v))
                return null;

            Stack<Integer> path = new Stack<Integer>();
            for (int w = v; w != s; w = edgeTo[w]) {
                path.push(w);
            }
            return path;
        }
    }

    private BreadthFirstPathFinder bfsEngine;
    private List<Cluster> clusters;
    private String storeDestination;

    public PathFinder(List<Cluster> clusters, String storeDestination){
        this.clusters = clusters;
        setStoreDestination(storeDestination);
    }

    public void setStoreDestination(String newStoreDestination){
        this.storeDestination = newStoreDestination;

        int clusterDest = getAssociatedCluster(storeDestination);
        this.bfsEngine = new BreadthFirstPathFinder(clusters, clusterDest);
    }

    public String getStoreDestination(){
        return this.storeDestination;
    }

    private int getAssociatedCluster(String name){
        for (int i = 0; i < clusters.size(); i++){
            if (clusters.get(i).getStores().contains(name)){
                return i;
            }
        }
        return -1;
    }

    private int getClusterID(List<String> companyNames) {
        for (Cluster cluster : clusters) {
            boolean[] isCompanyInCluster = new boolean[companyNames.size()];
            for (int i = 0; i < companyNames.size(); i++) {
                if (cluster.getStores().contains(companyNames.get(i))) {
                    isCompanyInCluster[i] = true;
                }
            }

            double avg = 0.0;
            for (boolean isInCluster : isCompanyInCluster) {
                if (isInCluster)
                    avg += 1;
            }
            avg /= isCompanyInCluster.length;

            if (avg > 0.5)
                return cluster.getClusterID();
        }
        return -1;
    }

    public String getNextPosition(List<String> companiesInImage){
        int curCluster = getClusterID(companiesInImage);

        List<Integer> pathIterator = bfsEngine.shortestPathTo(curCluster);
        for (int i = pathIterator.size() - 1; i >= 0; i--){
            for (String companyName : companiesInImage){
                if (clusters.get(pathIterator.get(i)).getStores().contains(companyName))
                    return companyName;
            }
        }
        return null;
    }
}

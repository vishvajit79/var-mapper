package io.qhacks.var_mapper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Emilio K on 2018-02-03.
 */

public class Cluster {
    private int clusterID;
    private ArrayList<Integer> storesInCluster = new ArrayList<>();
    private HashMap<Integer, ArrayList<Integer>> clusterJoints = new HashMap<>();

    private Cluster(int clusterID, HashMap<Integer, ArrayList<Integer>> clusterJoints) {
        this.clusterID = clusterID;
        this.clusterJoints = clusterJoints;
    }

    public int getClusterID() {
        return clusterID;
    }

    public void setClusterID(int clusterID) {
        this.clusterID = clusterID;
    }

    public HashMap<Integer, ArrayList<Integer>> getClusterJoints() {
        return clusterJoints;
    }

    public void setClusterJoints(HashMap<Integer, ArrayList<Integer>> clusterJoints) {
        this.clusterJoints = clusterJoints;
    }

    public ArrayList<Integer> getStoresInCluster() {
        return storesInCluster;
    }

    public void setStoresInCluster(ArrayList<Integer> storesInCluster) {
        this.storesInCluster = storesInCluster;
    }
}

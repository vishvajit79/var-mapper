package io.qhacks.var_mapper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Emilio K on 2018-02-03.
 */

public class Cluster {
    private int clusterID;
    private ArrayList<String> stores = new ArrayList<>();
    private HashMap<Integer, ArrayList<String>> clusterJoints = new HashMap<>();

    public Cluster(int clusterID, ArrayList<String> stores, HashMap<Integer, ArrayList<String>> clusterJoints) {
        this.clusterID = clusterID;
        this.stores = stores;
        this.clusterJoints = clusterJoints;
    }

    public int getClusterID() {
        return clusterID;
    }

    public void setClusterID(int clusterID) {
        this.clusterID = clusterID;
    }

    public HashMap<Integer, ArrayList<String>> getClusterJoints() {
        return clusterJoints;
    }

    public void setClusterJoints(HashMap<Integer, ArrayList<String>> clusterJoints) {
        this.clusterJoints = clusterJoints;
    }

    public ArrayList<String> getStores() {
        return stores;
    }

    public void setStores(ArrayList<String> storesInCluster) {
        this.stores = storesInCluster;
    }
}

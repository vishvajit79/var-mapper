package io.qhacks.var_mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 2/3/2018.
 */

public class PathFinder2 {


    List<Cluster> map;
    String destination;
    int destinationCluster;
    int currLocation;
    PathFinder2(List<Cluster> _map, String _destination){
        map = _map;
        destination = _destination;
        destinationCluster = findCluster(destination);
    }

    public String findCurrLocation(String location){
        int currCluster = getClusterID(location);
        if (currCluster >= 0){
            if (location.equals("Microsoft")){
                return "You have arrived at Microsoft. Proceed to TD";
            } else if (currCluster == 0){
                return "Proceed to Microsoft";
            } else if (location.equals(destination)){
                return "You have arrived at your destination";
            } else if (currCluster == 1){
                return "Destination within vicinity";
            }

        }
        else{
            return "Unrecongized, please try again";
        }
        return "why is it here even";
    }

    private int findCluster (String location){
        for (int i = 0; i<map.size();i++){
            if (map.get(i).getStores().indexOf(location)>=0) {
                return i;
            }
        }
        return -1;
    }

    private int getClusterID(String companyName) {
        for (int j = 0; j < map.size(); j++) {
            Cluster cluster = map.get(j);
            boolean isFound = false;
            List<String> stores = cluster.getStores();
            for (int i = 0; i < stores.size(); i++) {
                if (stores.get(i).contains(companyName)) {
                    isFound = true;
                }
            }

            if (isFound)
                return j;
        }
        return -1;
    }
}

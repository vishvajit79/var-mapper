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
        int currCluster;
        if (( currCluster = findCluster(location)) >= 0){
            if (location.equals("Microsoft")){
                return "You have arrived at Microsoft. Proceed to TD";
            } else if (currCluster == 1){
                return "Proceed to Microsoft";
            } else if (location.equals(destination)){
                return "You have arrived at your destination";
            } else if (currCluster == 2){
                return "Destination within vicinity";
            }

        } else{
            return "Unrecongized, please try again";
        }
        return "";
    }

    private int findCluster (String location){
        for (int i = 0; i<map.size();i++){
            if (map.get(i).getStores().indexOf(location)>=0) {
                return i;
            }
        }
        return -1;
    }
}

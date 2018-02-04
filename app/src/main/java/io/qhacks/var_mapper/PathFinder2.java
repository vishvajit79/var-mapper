package io.qhacks.var_mapper;

import java.util.ArrayList;

/**
 * Created by james on 2/3/2018.
 */

public class PathFinder2 {


    ArrayList<Cluster> map;
    String destination;
    int destinationCluster;
    int currLocation;
    PathFinder2(ArrayList<Cluster> _map, String _destination){
        map = _map;
        destination = _destination;
        destinationCluster = findCluster(destination);
    }

    public String findCurrLocation(String location){
        if (int currCluster = findCluster(location)>=0){
            if (location.equals("Microsoft")){
                //state2 find TD
            } else if (currCluster == 1){
                //state1 find Microsoft
            } else if (location.equals(destination)){
                //state3 youre here
            } else if (currCluster == 2){
                //state 2 youre close, look fro destination
            }

        }
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

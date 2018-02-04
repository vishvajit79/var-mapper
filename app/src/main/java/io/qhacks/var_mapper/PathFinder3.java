package io.qhacks.var_mapper;

import java.util.List;

/**
 * Created by james on 2/3/2018.
 */

public class PathFinder3 {


    List<Cluster> map;
    String destination;
    int destinationCluster;
    int currLocation;
    String text1,text2,text3,text4,search;
    int c1,c2;
    PathFinder3(List<Cluster> _map, String _destination){
        map = _map;
        destination = _destination;
        destinationCluster = getClusterID(destination);

        if (destinationCluster == 1){
            search = "Microsoft";
            text1 = "You have arrived at Microsoft. Proceed to TD";
            text2 =  "Proceed to Microsoft";
            text3 = "You have arrived at your destination";
            text4 = "Destination within vicinity";
            c1 = 0;
            c2 = 1;
        } else if (destinationCluster == 0){
            search = "TD";
            text1 = "You have arrived at TD. Proceed to Microsoft";
            text2 = "Proceed to TD";
            text3 = "You have arrived at your destination";
            text4 = "Destination within vicinity";
            c2 = 0;
            c1 = 1;

        }
    }

    public String findCurrLocation(String location){
        int currCluster = getClusterID(location);
        if (currCluster >= 0){
            if (location.equals(search)){
                return text1;
            } else if (currCluster == c1){
                return text2;
            } else if (location.equals(destination)){
                return "You have arrived at your destination";
            } else if (currCluster == c2){
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

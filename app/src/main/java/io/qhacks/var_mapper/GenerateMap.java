package io.qhacks.var_mapper;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.parseInt;


/**
 * Created by james on 2/3/2018.
 */

public class GenerateMap {


    public ArrayList<Cluster> new_Map (String fileName) throws IOException {
        // FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader("/../../../../res/sponsor_bay.csv");

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Cluster> map_ref = new ArrayList<Cluster>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {



            }

            String[] clusterStats = new String[2];
            String[] storeStats = new String[2];
            clusterStats = line.split(",");
            ArrayList<String> stores = new ArrayList<String>();
            HashMap<Integer, ArrayList<String>> jointStores =
                    new HashMap<Integer, ArrayList<String>>();
            for (int i = 0;i<parseInt(clusterStats[1]);i++){
                line = bufferedReader.readLine();
                storeStats = line.split(",");

                if (!storeStats[1].equals("0")){
                    if(jointStores.containsKey(parseInt(storeStats[1]))){
                        jointStores.get(parseInt(storeStats[1])).add(storeStats[0]);
                    } else{
                        ArrayList<String> temp = new ArrayList<String>();
                        temp.add(storeStats[0]);
                        jointStores.put(parseInt(storeStats[1]),temp);
                    }
                }
                stores.add(storeStats[0]);
            }

            Cluster temp_cluster = new Cluster(parseInt(clusterStats[0]),stores, jointStores);
            map_ref.add(temp_cluster);


        // Always close files.
        bufferedReader.close();

        return map_ref;
    }

}

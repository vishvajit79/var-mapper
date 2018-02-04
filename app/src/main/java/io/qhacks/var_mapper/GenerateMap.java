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
        /*
        FileReader fileReader = new FileReader(fileName);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Cluster> map_ref = new ArrayList<Cluster>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {


            String[] clusterStats = new String[2];
            String[] storeStats = new String[2];
            clusterStats = line.split(",");
            ArrayList<String> stores = new ArrayList<String>();
            HashMap<Integer, ArrayList<String>> jointStores =
                    new HashMap<Integer, ArrayList<String>>();
            for (int i = 0; i < parseInt(clusterStats[1]); i++) {
                line = bufferedReader.readLine();
                storeStats = line.split(",");

                if (!storeStats[1].equals("0")) {
                    if (jointStores.containsKey(parseInt(storeStats[1]))) {
                        jointStores.get(parseInt(storeStats[1])).add(storeStats[0]);
                    } else {
                        ArrayList<String> temp = new ArrayList<String>();
                        temp.add(storeStats[0]);
                        jointStores.put(parseInt(storeStats[1]), temp);
                    }
                }
                stores.add(storeStats[0]);
            }

            Cluster temp_cluster = new Cluster(parseInt(clusterStats[0]), stores, jointStores);
            map_ref.add(temp_cluster);
*/
        ArrayList<String> store1 = new ArrayList<String>();
        ArrayList<String> store2 = new ArrayList<String>();

        store1.add("Deloitte");
        store1.add("IBM");
        store1.add("MLH");
        store1.add("xesto");
        store1.add("iGAN");
        store1.add("eSight");
        store1.add("Microsoft");
        store1.add("stdlib");

        store2.add("TD");
        store2.add("Telus");
        store2.add("RL");
        store2.add("Avanade");
        store2.add("you.i");

        HashMap<Integer, ArrayList<String>> map1 = new HashMap<>();
        HashMap<Integer, ArrayList<String>> map2 = new HashMap<>();
        ArrayList<String> temparray = new ArrayList<>();
        temparray.add("Microsoft");
        map1.put(2, temparray);
        ArrayList<String> temp2 = new ArrayList<>();
        temp2.add("TD");
        map2.put(1, temp2);
        Cluster temp_cluster = new Cluster(1, store1, map1);
        Cluster temp_cluster2 = new Cluster(2, store2, map2);
        ArrayList<Cluster> c = new ArrayList<>();
        c.add(temp_cluster);
        c.add(temp_cluster2);
        return c;
       /*
        }
        // Always close files.
        bufferedReader.close();

        return map_ref;

    */
    }

}

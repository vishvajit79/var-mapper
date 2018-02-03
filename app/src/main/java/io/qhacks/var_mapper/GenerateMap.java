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
import java.util.List;



/**
 * Created by james on 2/3/2018.
 */

public class GenerateMap {


    public ArrayList<String[]> new_Map (String fileName) throws IOException {
        // FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader("/../../../../res/sponsor_bay.csv");

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String[]> map_ref = new ArrayList<String[]>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            map_ref.add(line.split(","));
        }

        // Always close files.
        bufferedReader.close();

        return map_ref;
    }

}

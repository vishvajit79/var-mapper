package io.qhacks.var_mapper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Emilio K on 2018-02-03.
 */

public class PathFinder {
    private ArrayList<String[]> map;
    private String destination;

    public PathFinder(ArrayList<String[]> map, String destination){
        this.map = map;
        this.destination = destination;
    }

    public Tuple<Integer, Integer> getStartingPoint(ArrayList<String> visualInput){
        return null;
    }

    public Tuple<Integer, Integer> getPOICoordinate(String name){
        return null;
    }

    public String getStoreName(Tuple<Integer, Integer> coordinates){
        return "";
    }

    public void generateRoute(Tuple<Integer, Integer> startPt, Tuple<Integer, Integer> endPt){
        Queue<Tuple<Integer, Integer>> queue = new LinkedList<Tuple<Integer, Integer>>();
        queue.add(startPt);

        while (queue.isEmpty()){
            Tuple<Integer, Integer> curCord = queue.remove();

            if (curCord.equals(endPt))
                return;

            if (curCord.getX() - 1 >= 0) {
                Tuple<Integer, Integer> newPt = new Tuple<Integer, Integer>(curCord.getX() - 1, curCord.getY());
                if (!isAtPath(newPt))
                    queue.add(new Tuple<Integer, Integer>(curCord.getX() - 1, curCord.getY()));
            }

            if (curCord.getX() + 1 < map.get(curCord.getY()).length) {
                Tuple<Integer, Integer> newPt = new Tuple<Integer, Integer>(curCord.getX() + 1, curCord.getY());
                if (isAtPath(newPt))
                    queue.add(newPt);
            }

            if (curCord.getY() - 1 >= 0) {
                Tuple<Integer, Integer> newPt = new Tuple<Integer, Integer>(curCord.getX(), curCord.getY() - 1);
                if (!isAtPath(newPt))
                    queue.add(newPt);
            }

            if (curCord.getY() + 1 < map.size()) {
                Tuple<Integer, Integer> newPt = new Tuple<Integer, Integer>(curCord.getX(), curCord.getY() + 1);
                if (isAtPath(newPt))
                    queue.add(newPt);
            }
        }
    }

    private boolean isAtPath(Tuple<Integer, Integer> point){
        return !map.get(point.getY())[point.getX()].equals("");
    }

    public List<Tuple<Integer, Integer>> getTurningPoints(){
        return null;
    }

    public List<String> getPassingPOIs(){
        return null;
    }

    public boolean checkAtDestination(String foundlogo){
        if (foundlogo.equals(destination)){
            return true;
        }
        return false;
    }

}

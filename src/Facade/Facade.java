package Facade;

import World.Map;

import java.util.ArrayList;

public interface Facade {

    void readMap(Map map, String mapName);

    void writeMap(Map map, String mapName);

    void updateMap(Map map, String mapName);

    void deleteMap(String mapName);

    ArrayList<String> getMapNames();
}

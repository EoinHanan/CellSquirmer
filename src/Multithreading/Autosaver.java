package Multithreading;

import Facade.MapMapper;
import World.Map;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by EoinH on 08/11/2017.
 */
public class Autosaver extends Thread{
    private MapMapper mapper;
    private Map map;
    private String mapName;
    boolean isStarted;

    public Autosaver(String mapName){
        mapper = new MapMapper();
        this.mapName = mapName;
    }

    public void startThread(){
        this.isStarted = true;
    }

    public void updateMap(Map map){
        this.map = map;
    }

    public void updateMapName(String mapName){
        this.mapName = mapName;
    }

    public void run() {
        while (isStarted)
        {
            try {
                TimeUnit.SECONDS.sleep(60);
                mapper.updateMySqlMap(map,mapName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread(){
        this.isStarted = false;

    }

}

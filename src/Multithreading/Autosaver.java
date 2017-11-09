package Autosaver;

import Facade.FacadeUtility;
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
    private FacadeUtility facade;
    private boolean isStarted;

    public Autosaver(String mapName){
        facade = new FacadeUtility();
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
                facade.updateMap(map,mapName);
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

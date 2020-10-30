package main.java.graphics;


import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TmxMapLoader {
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    
    
    public void show(){
        map = new TmxMapLoader().load();

        renderer = new OrthogonalTiledMapRenderer(map);
    }


}

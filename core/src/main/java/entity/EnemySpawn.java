package main.java.entity;

import java.util.ArrayList;

public class EnemySpawn extends Entity {
    private int enemySpawnTimer = -1;
    private int spawnEnemies = 0;

    public void newWave()
    {
        for (int i=0; i<10; i++) {
            Enemy(new Enemy(), position.x, position.y);
        }
    }

    public void act(){
        if (++enemySpawnTimer == 10*2){
            enemySpawnTimer = 0;
            spawnEnemies -= 2;
            for (int i=0; i<2; i++) Enemy(new Enemy(), position.x, position.y);
        }
        else {
            if (Enemy = null)  //hvis der ikke er enemies skal den spawne (getObject(Enemy).isEmpty())
            {spawnEnemies = 2*25}
        }
    }



    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void collision(ArrayList<Entity> others) {

    }
}

package Factories;

import Control.Constants;
import GameObjects.Obstacle;
import Interfaces.Factory;

import java.util.ArrayList;
import java.util.Random;


public class ObstacleFactory implements Factory
{
    private Random rand = new Random();
    @Override
    public Obstacle createObstacle() {
        ArrayList<String> Images = new ArrayList<>();
        int num = 1+ rand.nextInt(2);
        int key = num;
        for(int i = 0; i < 2;i++)
        {
            key+=10;
            String temp = Constants.ObstacleTypes.get(key);
            Images.add(temp);
        }
        int height = Obstacle.min_height + rand.nextInt(Obstacle.max_height);
        return(new Obstacle(Images.get(0) , Images.get(1),height , Constants.WIDTH));
    }
}

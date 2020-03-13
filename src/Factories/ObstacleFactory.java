package Factories;

import Control.Constants;
import GameObjects.Obstacle;
import Interfaces.Factory;

import java.util.ArrayList;


public class ObstacleFactory implements Factory
{
    @Override
    public Obstacle createObstacle() {
        ArrayList<String> Images = new ArrayList<>();
        int num = 1+(int)Math.random()*1;
        int prekey = num%10;
        int key = prekey;
        for(int i = 0; i < 1;i++)
        {
            key+=10;
            Images.add(Constants.ObstacleTypes.get(key));
        }
        return(new Obstacle(Images));
    }
}

package Factories;

import Control.Constants;
import GameObjects.Bird;

import java.util.ArrayList;
import java.util.Random;

public class BirdFactory {
    private Random rand = new Random();
    // реализация аналогична фабрике труб
    public Bird createBird(int key) {

        int temp_key = 0;
        ArrayList<String> Images = new ArrayList<>();
        if(key == 0) {
            int num = 1 + rand.nextInt(2);
            key = num;
            temp_key = num;
        }
        for(int i = 0; i < 3;i++)
            {
            key+=10;
            String temp = Constants.BirdTypes.get(key);
            Images.add(temp);
        }
        return( new Bird(Constants.WIDTH/2 - 10 , Constants.HEIGHT/2 - 10 , Images ,temp_key) );
    }
}

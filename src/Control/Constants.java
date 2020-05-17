package Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final Map<Integer, String> ObstacleTypes = new HashMap<Integer, String>();
    public static final Map<Integer, String> BirdTypes = new HashMap<Integer, String>();
    public static final Map<Integer, String> Numbers = new HashMap<Integer, String>();
    public static final int WIDTH = 500, HEIGHT = 600;
    public   int groundx ;
    public  final int groundy = HEIGHT - 100;
    public  final int gap = 75;
    public   int Gravity = 1;
    public   int vyn = -20;
    public   int vyp = 9;
    public Constants()
    {
        super();
    }
    public static void Init()
    {
        BirdTypes.put(11, ".\\sprites\\blue_1.png");
        BirdTypes.put(21 , ".\\sprites\\blue_2.png");
        BirdTypes.put(31, ".\\sprites\\blue_3.png");
        BirdTypes.put(12 , ".\\sprites\\red_1.png");
        BirdTypes.put(22, ".\\sprites\\red_2.png");
        BirdTypes.put(32 , ".\\sprites\\red_3.png");
        BirdTypes.put(12 , ".\\sprites\\yellow_1.png");
        BirdTypes.put(22, ".\\sprites\\yellow_2.png");
        BirdTypes.put(32 , ".\\sprites\\yellow_3.png");

        ObstacleTypes.put(11, ".\\sprites\\pipe-blue.png");
        ObstacleTypes.put(21 , ".\\sprites\\pipe-blue_north.png");
        ObstacleTypes.put(12, ".\\sprites\\pipe-red.png");
        ObstacleTypes.put(22 , ".\\sprites\\pipe-red_north.png");

        Numbers.put(0 , ".\\sprites\\0.png");
        Numbers.put(1 , ".\\sprites\\1.png");
        Numbers.put(2 , ".\\sprites\\2.png");
        Numbers.put(3 , ".\\sprites\\3.png");
        Numbers.put(4 , ".\\sprites\\4.png");
        Numbers.put(5 , ".\\sprites\\5.png");
        Numbers.put(6 , ".\\sprites\\6.png");
        Numbers.put(7 , ".\\sprites\\7.png");
        Numbers.put(8 , ".\\sprites\\8.png");
        Numbers.put(9 , ".\\sprites\\9.png");


    }


}

package Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final Map<Integer, String> ObstacleTypes = new HashMap<Integer, String>();
    public static final Map<Integer, String> BirdTypes = new HashMap<Integer, String>();
    public static final int WIDTH = 500, HEIGHT = 600;
    public static int groundx ;
    public static final int groundy = HEIGHT - 100;
    public static final int gap = 75;
    public static final int quant_of_obstacles = 4;

    public Constants()
    {
        super();
    }
    public static void Init()
    {
        BirdTypes.put(11, "\\КПП\\sprites\\blue_1.png");
        BirdTypes.put(21 , ".\\sprites\\lue_2.png");
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
    }


}

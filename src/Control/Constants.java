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
        BirdTypes.put(11, "D:\\КПП\\sprites\\blue_1.png");
        BirdTypes.put(21 , "D:\\КПП\\sprites\\lue_2.png");
        BirdTypes.put(31, "D:\\КПП\\sprites\\blue_3.png");
        BirdTypes.put(12 , "D:\\КПП\\sprites\\red_1.png");
        BirdTypes.put(22, "D:\\КПП\\sprites\\red_2.png");
        BirdTypes.put(32 , "D:\\КПП\\sprites\\red_3.png");
        BirdTypes.put(12 , "D:\\КПП\\sprites\\yellow_1.png");
        BirdTypes.put(22, "D:\\КПП\\sprites\\yellow_2.png");
        BirdTypes.put(32 , "D:\\КПП\\sprites\\yellow_3.png");

        ObstacleTypes.put(11, "D:\\КПП\\sprites\\pipe-blue.png");
        ObstacleTypes.put(21 , "D:\\КПП\\sprites\\pipe-blue_north.png");
        ObstacleTypes.put(12, "D:\\КПП\\sprites\\pipe-red.png");
        ObstacleTypes.put(22 , "D:\\КПП\\sprites\\pipe-red_north.png");

    }


}

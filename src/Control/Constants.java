package Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final Map<Integer, String> ObstacleTypes = new HashMap<Integer, String>();
    public static final Map<Integer, String> BirdTypes = new HashMap<Integer, String>();

    public Constants()
    {
        super();
    }
    public void init()
    {
        BirdTypes.put(11, "D:\\4sem\\КПП\\sprites\\blue_1.png");
        BirdTypes.put(21 , "D:\\4sem\\КПП\\sprites\\lue_2.png");
        BirdTypes.put(31, "D:\\4sem\\КПП\\sprites\\blue_3.png");
        BirdTypes.put(12 , "D:\\4sem\\КПП\\sprites\\red_1.png");
        BirdTypes.put(22, "D:\\4sem\\КПП\\sprites\\red_2.png");
        BirdTypes.put(32 , "D:\\4sem\\КПП\\sprites\\red_3.png");
        BirdTypes.put(12 , "D:\\4sem\\КПП\\sprites\\yellow_1.png");
        BirdTypes.put(22, "D:\\4sem\\КПП\\sprites\\yellow_2.png");
        BirdTypes.put(32 , "D:\\4sem\\КПП\\sprites\\yellow_3.png");

        ObstacleTypes.put(11, "D:\\4sem\\КПП\\sprites\\pipe-blue.png");
        ObstacleTypes.put(21 , "D:\\4sem\\КПП\\sprites\\pipe-blue_north.png");
        ObstacleTypes.put(12, "D:\\4sem\\КПП\\sprites\\pipe-red.png");
        ObstacleTypes.put(22 , "D:\\4sem\\КПП\\sprites\\pipe-red_north.png");

    }


}

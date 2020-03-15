package Data;

import java.util.HashMap;

public class Records
{
    private static HashMap<String, Integer> allRecords = new HashMap<>();

    public static void addRecord(String username, Integer record)
    {
        allRecords.put(username, record);
        WorkWithData.addRecordsToDataBase(allRecords);
    }

    public static void getRecords()
    {
        allRecords = WorkWithData.readRecordsFromDataBase();
    }
}

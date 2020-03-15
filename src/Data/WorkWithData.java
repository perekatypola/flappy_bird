package Data;

import java.util.HashMap;

public class WorkWithData
{

    private static HashMap<String, String> users = new HashMap<>();

    public static boolean checkUser(String username, String password)
    {
        //добавление инфы о юзерах(логин + пароль) из базы данных в hash map users

        if(users.containsKey(username) && users.containsValue(password)) return true; //проверка, существует ли такой пользователь в базе данных

        return false;
    }

    public static void addUser(String username, String password)
    {
        users.put(username, password);

        //занести это в базу данных
    }

    public static void addRecordsToDataBase(HashMap<String, Integer> allRecords)
    {
        //добавление нового рекорда в базу данных
    }

    public static HashMap<String, Integer> readRecordsFromDataBase()
    {
        HashMap<String, Integer> records = new HashMap<>();

        //чтение из базы данных в созданный выше hash map

        return records;
    }
}

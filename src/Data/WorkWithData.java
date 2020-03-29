package Data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class WorkWithData
{

    private static HashMap<String, String> users = new HashMap<>();

    public static void getData()
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D://КПП//database.txt"));
            FileInputStream fis = new FileInputStream("D://КПП//database.txt");
            )
        {
            if(fis.available() != 0)
            {
                while(true)
                {
                    if(fis.read() == -1) break;
                    users.put((String)ois.readObject(), (String)ois.readObject());
                }
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public static boolean checkUserLog(String username, String password)
    {

        if(users.containsKey(username) && users.containsValue(password)) return true; //проверка, существует ли такой пользователь в базе данных

        return false;
    }

    public static boolean checkUserSign(String username)
    {

        if(users.containsKey(username)) return true; //проверка, существует ли такой пользователь в базе данных

        return false;
    }

    public static void addUser(String username, String password)
    {
        users.put(username, password);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D://КПП//database.txt", false))
        )
        {
            for(HashMap.Entry<String, String > item: users.entrySet())
            {
                oos.writeObject(item.getKey());
                oos.writeObject(item.getValue());
            }

        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
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

package Data;

import Control.GameData;
import Logic.Game;

import java.io.*;
import java.util.HashMap;

public class WorkWithData
{

    private static HashMap<String, String> users = new HashMap<>();
    private static HashMap<String, String> allRecords = new HashMap<>();


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

    public static void saveGame(String user , GameData game)
    {
        String path = "D://КПП//" + user + "_saved.txt";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path, false))
        )
        {
            oos.writeObject(game);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public GameData resumeGame(String user)
    {
        GameData game = null;
        String path = "D://КПП//" + user + "_saved.txt";
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            game = (GameData)ois.readObject();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return game;
    }


    public static void getAllRecords()
    {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D://КПП//recordtable.txt"));
            FileInputStream fis = new FileInputStream("D://КПП//recordtable.txt");
        )
        {
            if(fis.available() != 0)
            {
                while(true)
                {
                    if(fis.read() == -1) break;
                    allRecords.put((String)ois.readObject(), (String)ois.readObject());
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

    public static void addRecords(String username, Integer newRecord)
    {
        allRecords.put(username, newRecord.toString());

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D://КПП//recordtable.txt", false))
        )
        {
            for(HashMap.Entry<String, String> item: allRecords.entrySet())
            {
                oos.writeObject(item.getKey());
                oos.writeObject(item.getValue());
            }

        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public static int getRecord(String username)
    {
        int res;

        if(allRecords.get(username) == null)
        {
            res = 0;
        } else
        {
            res = Integer.parseInt(allRecords.get(username));
        }

        return res;
    }

}

package Exeptions;

public class WrongUser extends Exception {

    private String message;

    public WrongUser(String eror)
    {
        super(eror);
        message = eror;
    }

    public String getMesage()
    {
        return message;
    }
}

package Exeptions;

public class TooLong extends Exception {
    private String message;

    public TooLong(String eror)
    {
        super(eror);
        message = eror;
    }

    public String getMesage()
    {
        return message;
    }
}

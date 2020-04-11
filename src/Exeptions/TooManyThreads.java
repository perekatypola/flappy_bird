package Exeptions;

public class TooManyThreads extends Exception {

    private String message;

    public TooManyThreads(String eror)
    {
        super(eror);
        message = eror;
    }

    public String getMesage()
    {
        return message;
    }
}

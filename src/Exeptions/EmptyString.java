package Exeptions;

public class EmptyString extends Exception {

    private String message;

    public EmptyString(String eror)
    {
        super(eror);
        message = eror;
    }

    public String getMesage()
    {
        return message;
    }

}

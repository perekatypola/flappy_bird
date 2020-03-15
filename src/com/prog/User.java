package com.prog;

public class User
{
    private String name;
    private String password;
    private Integer record;

    public User(String newName, String newPassw)
    {
        name = newName;
        password = newPassw;
    }

    public void addRecord(Integer newRecord)
    {
        record = newRecord;
    }

    public String getName()
    {
        return this.name;
    }

    public String getPassword()
    {
        return this.password;
    }

    public Integer getRecord()
    {
        return this.record;
    }
}

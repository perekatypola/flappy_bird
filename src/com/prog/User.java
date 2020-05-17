package com.prog;

import Data.WorkWithData;

import java.io.Serializable;

public class User implements Serializable
{
    private String name;
    private String password;
    private Integer record;

    public User(String newName, String newPassw)
    {
        name = newName;
        password = newPassw;
    }

    public void addRecord(int newRecord)
    {
        WorkWithData.getAllRecords();

        if(WorkWithData.getRecord(this.name) == 0 || WorkWithData.getRecord(this.name) < newRecord)
        {
            record = newRecord;
            WorkWithData.addRecords(this.name, record);
        }

    }

    public String getName()
    {
        return this.name;
    }

    public String getPassword()
    {
        return this.password;
    }

    public int getRecord()
    {
        WorkWithData.getAllRecords();
        this.record = WorkWithData.getRecord(this.name);

        return this.record;
    }
}

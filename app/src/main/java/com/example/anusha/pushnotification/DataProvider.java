package com.example.anusha.pushnotification;

/**
 * Created by Anusha on 7/29/2016.
 */
public class DataProvider {

    private String message_view;
    private String author_view;




    public String getAuth()
    {

        return author_view;
    }

    public void setAuth(String author_view)
    {

        this.author_view = author_view;
    }

    public String getMsg()
    {
        return message_view;
    }

    public void setMsg(String message_view)

    {
        this.message_view = message_view;
    }



    public DataProvider(String message_view,String author_view)
    {
        this.message_view = message_view;
        this.author_view = author_view;

    }
}

package com.example.anusha.pushnotification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anusha on 7/29/2016.
 */
public class ListDataAdapter extends ArrayAdapter{

    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource)
    {

        super(context, resource);
    }


    static class LayoutHandler
    {
        static TextView MESSAGE_VIEW;
        static TextView AUTHOR_VIEW;

    }

    @Override
    public void add(Object object)
    {
        super.add(object);
        list.add(object);
    }


   @Override
    public int getCount()
    {
        return 5;
    }

   /* @Override
    public int getCount()
    {
        return list.size();
    }*/



   /* @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }*/


    @Override
    public Object getItem(int position)
    {
        return super.getItem(getCount() - position - 1);
    }





    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            layoutHandler = new LayoutHandler();
            LayoutHandler.MESSAGE_VIEW = (TextView)row.findViewById(R.id.text_message);
            LayoutHandler.AUTHOR_VIEW = (TextView)row.findViewById(R.id.text_author);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }

        DataProvider dataProvider = (DataProvider)this.getItem(position);
        layoutHandler.MESSAGE_VIEW.setText(dataProvider.getMsg());
        layoutHandler.AUTHOR_VIEW.setText(dataProvider.getAuth());

        return row;




    }

}

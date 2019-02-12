package com.admin.hymnalhymn;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<Item> {

    private Activity activity;
    int id;
    ArrayList<Item> items;

    public Adapter( Activity context, int resource, ArrayList<Item> objects) {

        super(context, resource, objects);
        this.activity=context;
        this.id=resource;
        this.items=objects;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if (convertView==null){
            LayoutInflater inflater=activity.getLayoutInflater();
            convertView=inflater.inflate(id,null);
        }

        Item item = items.get(position);
        TextView tvId = (TextView) convertView.findViewById(R.id.tvId);
        TextView tvHymn = (TextView) convertView.findViewById(R.id.tvHymn);
        TextView tvStanza = (TextView) convertView.findViewById(R.id.tvStanza);


        tvId.setText(item.getId());
        tvHymn.setText(item.getHymn());
        tvStanza.setText(item.getContent());
        return convertView;

    }
}

































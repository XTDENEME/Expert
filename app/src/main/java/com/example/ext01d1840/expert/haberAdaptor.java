package com.example.ext01d1840.expert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by EXT01D1840 on 6/16/2016.
 * Anasayfada kullanılacak Listview için adaptor olarak kullanılacaktır.
 */
public class haberAdaptor extends ArrayAdapter<String> {

    int[] hImage = {};
    String[] hText = {};
    Context c;
    LayoutInflater inflater;

    public haberAdaptor(Context context, String haberText[],int[] haberImage) {
        super(context, R.layout.xt_haber,haberText);

        this.c = context;
        this.hImage = haberImage;
        this.hText = haberText;
    }

    public class ViewHolder{

        TextView haberT;
        ImageView haberI;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        if (convertView == null){
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =  inflater.inflate(R.layout.xt_haber,null);
        }

        final ViewHolder holder =  new ViewHolder();

        holder.haberT = (TextView) convertView.findViewById(R.id.haberText);
        holder.haberI = (ImageView) convertView.findViewById(R.id.haberImage);

        holder.haberI.setImageResource(hImage[position]);
        holder.haberT.setText(hText[position]);

        return convertView;
    }
}

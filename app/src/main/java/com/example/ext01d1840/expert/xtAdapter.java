package com.example.ext01d1840.expert;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by EXT0132016 on 6/21/2016.
 */
public class xtAdapter extends BaseExpandableListAdapter {

    private List<String> header_titles;
    private HashMap<String,List<String>> child_titles;
    private Context ctx;
    xtAdapter(Context ctx,List<String> header_titles,HashMap<String,List<String>> child_titles)
    {
        this.ctx = ctx;
        this.child_titles = child_titles;
        this.header_titles=header_titles;

    }


    @Override
    public int getGroupCount() {
        return header_titles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child_titles.get(header_titles.get(groupPosition)).size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return header_titles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child_titles.get(header_titles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String)this.getGroup(groupPosition);
        if (convertView == null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.xt_parent_layout,null);

        }

        TextView textView = (TextView) convertView.findViewById(R.id.heading_item);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String title  = (String) this.getChild(groupPosition,childPosition);

        if (convertView == null)
        {
            LayoutInflater layoutInflater =(LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.xt_child_layout,null);
        }

        TextView textView = (TextView)convertView.findViewById(R.id.child_item);
        textView.setText(title);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

package com.diligroup.Home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.diligroup.R;

import java.util.List;
import java.util.Map;

/**
 * Created by hjf on 2016/7/14.
 * x
 */
public class LeftAdapter extends BaseExpandableListAdapter {
    Context mContext;
    List<Map<String, String>> childs;
    public LeftAdapter(Context mContext, List<Map<String, String>> childs){
        this.mContext=mContext;
        this.childs=childs;
    }
    public LeftAdapter(Context mContext){
        this.mContext=mContext;
        this.childs=childs;
    }
    @Override
    public int getGroupCount() {
        return childs.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childs.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return childs.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childs.get(groupPosition).get(childPosition);
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
        if(convertView==null){
            convertView=View.inflate(mContext, R.layout.addlunch_parent,null);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(mContext, R.layout.addlunch_child,null);
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}

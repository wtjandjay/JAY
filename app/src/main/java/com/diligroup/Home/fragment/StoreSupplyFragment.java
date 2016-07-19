package com.diligroup.Home.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.diligroup.Home.adapter.LeftAdapter;
import com.diligroup.Home.adapter.RighAdapter;
import com.diligroup.R;
import com.diligroup.base.BaseFragment;
import com.diligroup.utils.CommonUtils;
import com.diligroup.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjf on 2016/7/13.
 */
public class StoreSupplyFragment extends BaseFragment implements ExpandableListView.OnChildClickListener, View.OnClickListener {
    @Bind(R.id.left_listView)
    ExpandableListView leftListView;
    @Bind(R.id.right_recyclerView)
    RecyclerView rightRecyclerView;
    @Bind(R.id.input_search_dishes)
    EditText input_search_dishes;//
    @Bind(R.id.complete_add)
    LinearLayout complete_add;

    @Override
    public int getLayoutXml() {
        return R.layout.fragment_storesupply;
    }

    @Override
    public void setViews() {
        //创建二个一级条目标题
        Map<String, String> title_1 = new HashMap<String, String>();
        Map<String, String> title_2 = new HashMap<String, String>();

        title_1.put("group", "移动开发");
        title_2.put("group", "菜品种类");

        //创建一级条目容器
        List<Map<String, String>> gruops = new ArrayList<Map<String, String>>();

        gruops.add(title_1);
        gruops.add(title_2);

        //创建二级条目内容

        //内容一
        Map<String, String> content_1 = new HashMap<String, String>();
        Map<String, String> content_2 = new HashMap<String, String>();

        content_1.put("child", "ANDROID");
        content_2.put("child", "IOS");

        List<Map<String, String>> childs_1 = new ArrayList<Map<String, String>>();
        childs_1.add(content_1);
        childs_1.add(content_2);

        //内容二
        Map<String, String> content_3 = new HashMap<String, String>();
        Map<String, String> content_4 = new HashMap<String, String>();
        Map<String, String> content_5 = new HashMap<String, String>();

        content_3.put("child", "扁豆");
        content_4.put("child", "黄瓜");
        content_5.put("child", "青椒");
        List<Map<String, String>> childs_2 = new ArrayList<Map<String, String>>();
        childs_2.add(content_3);
        childs_2.add(content_4);
        childs_2.add(content_5);

        //存放两个内容, 以便显示在列表中
        List<List<Map<String, String>>> childs = new ArrayList<List<Map<String, String>>>();
        childs.add(childs_1);
        childs.add(childs_2);

//        gruops.addAll(childs);
//        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
//                this, gruops, R.drawable.expandablelistview_groups, new String[]{"group"}, new int[]{R.id.textGroup},
//                childs, R.drawable.expandablelistview_child, new String[]{"child"}, new int[]{R.id.textChild}
//        );
        LeftAdapter adapter = new LeftAdapter(getActivity(), gruops);
        leftListView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                getActivity(), DividerItemDecoration.VERTICAL_LIST);
        rightRecyclerView.addItemDecoration(dividerItemDecoration);//垂直列表的分割线
        dividerItemDecoration.setWidth(CommonUtils.px2dip(getActivity(), 1));
        rightRecyclerView.setHasFixedSize(true);//保持固定大小，提高性能
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rightRecyclerView.setLayoutManager(layoutManager);

        List<String> mList = new ArrayList<>();
        mList.add("0000000000");
        mList.add("0000000000");
        mList.add("0000000000");
        mList.add("0000000000");
        mList.add("0000000000");
        mList.add("0000000000");
        mList.add("0000000000");
        mList.add("0000000000");
        mList.add("0000000000");
        RighAdapter righAdapter = new RighAdapter(getActivity(), mList);
        rightRecyclerView.setAdapter(righAdapter);
    }

    @Override
    public void setListeners() {
        input_search_dishes.setOnClickListener(this);
        leftListView.setOnChildClickListener(this);//子item点击事件
        complete_add.setOnClickListener(this);
    }

    public Fragment newInstance() {
        StoreSupplyFragment fragment = new StoreSupplyFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.input_search_dishes:
                input_search_dishes.setFocusable(true);
                break;
            case R.id.complete_add:
                break;
        }
    }
}

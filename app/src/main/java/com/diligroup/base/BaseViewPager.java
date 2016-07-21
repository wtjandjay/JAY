package com.diligroup.base;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.diligroup.Home.adapter.HomeRighAdapter;
import com.diligroup.Home.adapter.LeftAdapter;
import com.diligroup.R;
import com.diligroup.utils.CommonUtils;
import com.diligroup.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseViewPager {
    protected View rootView;
    public Context mContext;
    public RecyclerView home_recycleView;//其子类共享这一个listView
    public ListView  furniture_item_parent;
    public List<BaseViewPager> mList;

    protected RelativeLayout emptyView;
    protected TextView no_content;
    protected boolean isPull = true;
    protected LinearLayout ll_rootView;
    private ExpandableListView home_left_listView;

    //    protected HintDialog hintDialog;
//    protected CusProgress dialog;
    public BaseViewPager(Context mContext) {
        this.mContext = mContext;
        rootView = initView();
//        hintDialog=new HintDialog(mContext);
//        dialog=new CusProgress(mContext);
    }

    protected View initView() {
        rootView = View.inflate(mContext, R.layout.fragment_baseview, null);
        home_recycleView= (RecyclerView) rootView.findViewById(R.id.home_recycleView);
        home_left_listView = (ExpandableListView) rootView.findViewById(R.id.home_left_listView);

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


        LeftAdapter adapter = new LeftAdapter(mContext, gruops);
        home_left_listView .setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                mContext, DividerItemDecoration.VERTICAL_LIST);
        home_recycleView.addItemDecoration(dividerItemDecoration);//垂直列表的分割线
        dividerItemDecoration.setWidth(CommonUtils.px2dip(mContext, 1));
        home_recycleView.setHasFixedSize(true);//保持固定大小，提高性能
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        home_recycleView.setLayoutManager(layoutManager);

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
        HomeRighAdapter righAdapter = new HomeRighAdapter(mContext, mList);
        home_recycleView.setAdapter(righAdapter);
        return rootView;


    }

    /**
     * 获得当前页面的布局对象
     *
     * @return
     */
    public View getRootView() {
        return rootView;
    }

    /**
     * 子类需要覆盖此方法, 实现自己的初始化数据逻辑
     */
    public void initDate() {

//        dialog.show();
    }
}

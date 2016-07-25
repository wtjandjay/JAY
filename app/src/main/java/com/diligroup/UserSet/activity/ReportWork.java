package com.diligroup.UserSet.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.bean.UserInfoBean;
import com.diligroup.bean.WorkDataFromService;
import com.diligroup.net.Action;
import com.diligroup.net.Api;
import com.diligroup.other.ReportUserInfos;
import com.diligroup.utils.NetUtils;
import com.diligroup.utils.ToastUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Request;

/**
 * 上报  职业
 * Created by Kevin on 2016/6/16.
 */
public class ReportWork extends BaseAcitvity {

    private String[] lightWork;
    private String[] middleWork;
    private String[] heavyWork;
    private String userSelect;
    @Bind(R.id.gv_light)
    GridView gv_light;
    @Bind(R.id.gv_middle)
    GridView gv_middle;
    @Bind(R.id.gv_heavy)
    GridView gv_heavy;
    List<WorkDataFromService.ListBean>  joblist;
    @Bind(R.id.tv_light)
    TextView tv_light;
    @Bind(R.id.tv_middle)
    TextView tv_middle;
    @Bind(R.id.tv_heavy)
    TextView tv_heavy;
    @Bind(R.id.rl_light)
    RelativeLayout  rl_light;
    @Bind(R.id.rl_middle)
    RelativeLayout  rl_middle;
    @Bind(R.id.rl_heavy)
    RelativeLayout  rl_heavy;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_select_work;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected void initViewAndData() {
        isShowBack(true);
        Api.getWorkType();
        initData();
        gv_light.setAdapter(new WorkAdapter(lightWork));
        gv_middle.setAdapter(new WorkAdapter(middleWork));
        gv_heavy.setAdapter(new WorkAdapter(heavyWork));
        gv_light.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                userSelect=lightWork[position];
            }
        });
        gv_middle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                userSelect=middleWork[position];

            }
        });
        gv_heavy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                userSelect=heavyWork[position];

            }
        });
    }

    private void initData() {
        heavyWork = getResources().getStringArray(R.array.heavy);
        middleWork =getResources().getStringArray(R.array.middle);
        lightWork = getResources().getStringArray(R.array.light);
    }

    @Override
    public void setTitle() {
        super.setTitle();
        tv_title.setText("选择职业");
        title_infos.setText("您的职业?");
    }

    @OnClick(R.id.bt_commit_work)
    public void reportWorkData() {

        ToastUtil.showLong(this, "You  work ====" + userSelect);
        UserInfoBean.getInstance().setJob(userSelect);
        readyGo(ReportHeight.class);
    }

    @Override
    public void onError(Request request, Action action, Exception e) {

    }

    @Override
    public void onResponse(Request request, Action action, Object object) {
                if (object!=null){
                    if (action==Action.GET_WORK_TYPE){
                        WorkDataFromService  jobdata= (WorkDataFromService) object;
                        if (jobdata.getCode().equals("000000")){
                            joblist= jobdata.getList();
                          switch (joblist.size()){
                              case 0:
                                  rl_light.setVisibility(View.VISIBLE);
//                                  rl_middle.setVisibility(View.INVISIBLE);
//                                  rl_heavy.setVisibility(View.INVISIBLE);
                                  gv_light.setVisibility(View.VISIBLE);
                                  tv_light.setText(joblist.get(0).getDictName());
                                  break;
                              case 1:
                                  rl_light.setVisibility(View.VISIBLE);
                                  rl_middle.setVisibility(View.VISIBLE);
//                                  rl_heavy.setVisibility(View.INVISIBLE);
                                  gv_light.setVisibility(View.VISIBLE);
                                  gv_middle.setVisibility(View.VISIBLE);

                                  tv_light.setText(joblist.get(0).getDictName());
                                  tv_middle.setText(joblist.get(1).getDictName());
                                  break;
                              case 2:
                                  rl_light.setVisibility(View.VISIBLE);
                                  rl_middle.setVisibility(View.VISIBLE);
                                  rl_heavy.setVisibility(View.VISIBLE);
                                  gv_light.setVisibility(View.VISIBLE);
                                  gv_middle.setVisibility(View.VISIBLE);
                                  gv_heavy.setVisibility(View.VISIBLE);
                                  tv_light.setText(joblist.get(0).getDictName());
                                  tv_middle.setText(joblist.get(1).getDictName());
                                  tv_heavy.setText(joblist.get(2).getDictName());
                                  break;
                          }

                        }
                    }

                }
    }


    private class WorkAdapter extends BaseAdapter {
        LayoutInflater mInflater;
        String[] work_array;

        @Override
        public int getCount() {
            return work_array.length;
        }

        WorkAdapter(String[] array) {
            this.work_array = array;
            mInflater = LayoutInflater.from(ReportWork.this);

        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.grid_item, null);
                holder.tv_work = (TextView) convertView.findViewById(R.id.tv_work_name);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_work.setText(work_array[position]);
            return convertView;
        }
    }

    class ViewHolder {
        TextView tv_work;
    }
}

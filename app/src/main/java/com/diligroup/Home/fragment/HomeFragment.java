package com.diligroup.Home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.diligroup.R;
import com.diligroup.base.BaseFragment;
import com.diligroup.view.MyViewFilpper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjf on 2016/7/18.
 * 首页
 */
public class HomeFragment extends BaseFragment {

    @Bind(R.id.home_flipper)
    MyViewFilpper homeFlipper;
    @Bind(R.id.banner_dot_ll)
    LinearLayout banner_dot_ll;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public int getLayoutXml() {
        return R.layout.fragment_home;
    }

    @Override
    public void setViews() {
      initDate();
    }

    @Override
    public void setListeners() {
     homeFlipper.setOnDisplayChagnedListener(new MyViewFilpper.OnDisplayChagnedListener() {
         @Override
         public void OnDisplayChildChanging(ViewFlipper view, int index) {
//             LogUtils.i("viewFliper当前index=="+index);
             switchDottor(index);
         }
     });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    private void initDate(){
        int image[] = new int[]
                {
                        R.mipmap.star_normal, R.mipmap.star_selected, R.mipmap.banne_icon
                };
        for (int i = 0; i < image.length; i++) {
            ImageView iv = new ImageView(getActivity());
            iv.setBackgroundResource(image[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setLayoutParams(new FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
            homeFlipper.addView(iv);

            ImageView dotter=new ImageView(getActivity());
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(15,15);
            dotter.setBackgroundResource(R.drawable.banner_dot_selector);
            if(i!=0){
                layoutParams.leftMargin=5;
                dotter.setSelected(false);
            }else{
                dotter.setSelected(true);
            }
            dotter.setLayoutParams(layoutParams);
            banner_dot_ll.addView(dotter);
        }

    }
    private void switchDottor(int index){
        for(int i=0;i<banner_dot_ll.getChildCount();i++){
            if(i==index){
                banner_dot_ll.getChildAt(i).setSelected(true);
            }else{
                banner_dot_ll.getChildAt(i).setSelected(false);
            }
        }
    }
}

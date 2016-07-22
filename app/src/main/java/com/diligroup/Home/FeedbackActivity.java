package com.diligroup.Home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.diligroup.R;
import com.diligroup.base.BaseAcitvity;
import com.diligroup.utils.NetUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.techery.properratingbar.ProperRatingBar;

/**
 * 菜品和性价比评价页面
 */
public class FeedbackActivity extends BaseAcitvity implements View.OnClickListener {


    @Bind(R.id.dishes_name)
    TextView dishesName;//菜品名称
    @Bind(R.id.taste_evaluation)
    ProperRatingBar tasteEvaluation;//口味评价
    @Bind(R.id.cost_performance_evaluation)
    ProperRatingBar costPerformanceEvaluation;//性价比评价
    @Bind(R.id.input_dishes_evaluation)
    EditText inputDishesEvaluation;//输入你的产品印象
    @Bind(R.id.feedback_commit)
    Button feedbackCommit;//提交评价

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }
    public void setTitle() {
        super.setTitle();
        tv_title.setText("菜品评价");
        isShowBack(true);
    }
    @Override
    protected void initViewAndData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        feedbackCommit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.feedback_commit:
                break;
            default:
                break;
        }
    }
}

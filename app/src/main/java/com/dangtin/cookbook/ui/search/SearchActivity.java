/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.search;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.SearchHistoryAdapter;
import com.dangtin.cookbook.constant.GlobalFuntion;
import com.dangtin.cookbook.data.models.KeywordHot;
import com.dangtin.cookbook.data.models.SearchHistory;
import com.dangtin.cookbook.ui.base.BaseMVPDialogActivity;
import com.dangtin.cookbook.ui.widget.textview.RobotoRegularTextView;
import com.wefika.flowlayout.FlowLayout;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseMVPDialogActivity implements SearchMVPView,
        View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.layout_keyword_hot)
    FlowLayout flowLayoutKeyword;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.rcvHistory)
    RecyclerView rcvHistory;

    @BindView(R.id.edtKeyword)
    EditText edtKeyword;

    @BindView(R.id.image_delete)
    ImageView image_delete;

    @Inject
    SearchHistoryAdapter searchHistoryAdapter;

    @Inject
    SearchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        getSupportActionBar().hide();

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeRefreshLayout.setOnRefreshListener(this);

        initControl();

        searchHistoryAdapter.injectInto(rcvHistory);
        presenter.loadData();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_search;
    }

    @Override
    protected void onDestroy() {
        presenter.destroyView();

        if (searchHistoryAdapter != null) {
            searchHistoryAdapter.release();
        }
        super.onDestroy();
    }

    @Override
    public void showNoNetworkAlert() {
        showAlert(getString(R.string.error_not_connect_to_internet));
    }

    @Override
    public void onErrorCallApi(int code) {
        GlobalFuntion.showMessageError(this, code);
    }

    @Override
    public void updateListKeywordHot(ArrayList<KeywordHot> listKeywordHot) {
        setLayoutKeywordHot(listKeywordHot);
    }

    @Override
    public void updateListSearchHistory(ArrayList<SearchHistory> listSearchHistory) {
        searchHistoryAdapter.setListData(listSearchHistory);
    }

    private void setLayoutKeywordHot(ArrayList<KeywordHot> listKeyword) {
        flowLayoutKeyword.removeAllViews();
        if (listKeyword != null && listKeyword.size() > 0) {
            for (int i = 0; i < listKeyword.size(); i++) {
                FlowLayout.LayoutParams params =
                        new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT,
                                FlowLayout.LayoutParams.WRAP_CONTENT);
                RobotoRegularTextView textView = new RobotoRegularTextView(this);
                params.setMargins(0,10,20,10);
                textView.setLayoutParams(params);
                textView.setPadding(30, 10, 30, 10);
                textView.setId(listKeyword.get(i).getId());
                textView.setText(listKeyword.get(i).getKeyword());
                textView.setBackgroundResource(R.drawable.bg_white_shape_round_corner_border_grey);
                textView.setTextColor(getResources().getColor(R.color.purple));
                textView.setTextSize(((int) getResources().getDimension(R.dimen.text_size_small) /
                        getResources().getDisplayMetrics().density));
                textView.setOnClickListener(this);
                flowLayoutKeyword.addView(textView);
            }
        }
    }

    @Override
    public void onClick(View view) {
        // Todo
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    private void initControl() {
        edtKeyword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // Todo
                    return true;
                }
                return false;
            }
        });
        edtKeyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edtKeyword.getText().toString().trim().length() > 0) {
                    image_delete.setVisibility(View.VISIBLE);
                } else {
                    image_delete.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @OnClick(R.id.image_delete)
    public void onClickImageDelete() {
        edtKeyword.setText("");
    }

    @OnClick(R.id.image_back)
    public void onClickImageBack() {
        GlobalFuntion.hideSoftKeyboard(this);
        onBackPressed();
    }
}

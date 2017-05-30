package com.example.thear.myownexample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.thear.myownexample.R;
import com.example.thear.myownexample.mvp.presenter.MyExamplePresenter;
import com.example.thear.myownexample.mvp.view.MyExample;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFragment extends MvpAppCompatFragment implements MyExample {
    @InjectPresenter
    MyExamplePresenter mPresenter;

    @ProvidePresenter
    public MyExamplePresenter mPresenter() {
        return new MyExamplePresenter("Hello");}

    @BindView(R.id.text_view)
    TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.button)
    public void onButtonClick() {
        mPresenter.onButtonClick();
    }

    @OnClick(R.id.button_swap)
    public void onSwapButtonClick() {
        mPresenter.swapFragment();
    }

    @OnClick(R.id.recycler_view_fragment_button)
    public void onRecyclerViewCLick() {
        mPresenter.onRecyclerViewClicked();
    }

    @Override
    public void showText(String text) {
        if (mTextView != null)
            mTextView.setText(text);
    }
}

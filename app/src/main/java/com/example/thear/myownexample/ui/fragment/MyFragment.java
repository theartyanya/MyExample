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

public class MyFragment extends MvpAppCompatFragment implements MyExample {
    private String s = "Hello";
    @InjectPresenter
    MyExamplePresenter mPresenter;

    @ProvidePresenter
    public MyExamplePresenter mPresenter() {return new MyExamplePresenter(s);}

    @BindView(R.id.button)
    Button mButton;

    @BindView(R.id.button_swap)
    Button mButtonSwap;

    @BindView(R.id.text_view)
    TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onButtonClick();
            }
        });
        mButtonSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.swapFragment();
            }
        });
    }

    @Override
    public void showText(String text) {
        if (mTextView != null)
            mTextView.setText(text);
    }
}

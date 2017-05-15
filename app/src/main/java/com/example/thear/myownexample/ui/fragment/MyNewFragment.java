package com.example.thear.myownexample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.thear.myownexample.R;
import com.example.thear.myownexample.mvp.presenter.NewFragmentPresenter;
import com.example.thear.myownexample.mvp.view.NewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyNewFragment extends MvpAppCompatFragment implements NewFragment {
    @InjectPresenter
    NewFragmentPresenter mPresenter;

    @BindView(R.id.new_fragment)
    TextView mTextView;

    @BindView(R.id.new_button)
    Button mButton;

    @BindView(R.id.list_button)
    Button listButton;

    @BindView(R.id.my_list)
    ListView list;

    @ProvidePresenter
    NewFragmentPresenter getPresenter() {
        return new NewFragmentPresenter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.toMain();
            }
        });
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.createList();
            }
        });
    }

    @Override
    public void showText() {
        if (mTextView != null)
            mTextView.setText("Hey There");
    }

    @Override
    public void setAdapter(ArrayAdapter adapter) {
        list.setAdapter(adapter);
    }
}

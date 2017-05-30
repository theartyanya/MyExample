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
import com.example.thear.myownexample.mvp.model.ItemsArray;
import com.example.thear.myownexample.mvp.presenter.NewFragmentPresenter;
import com.example.thear.myownexample.mvp.view.NewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyNewFragment extends MvpAppCompatFragment implements NewFragment {
    @InjectPresenter
    NewFragmentPresenter mPresenter;

    @BindView(R.id.new_fragment)
    TextView mTextView;

    @BindView(R.id.my_list)
    ListView list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

    }

    @Override
    public void showText() {
        if (mTextView != null)
            mTextView.setText("Hey There");
    }

    @OnClick(R.id.list_button)
    public void showList() {
        mPresenter.onListButtonClick();
    }

    @Override
    public void setAdapter() {
        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(getActivity(), R.layout.list_item, ItemsArray.getItems());
        list.setAdapter(arrayAdapter);
    }
}

package com.example.thear.myownexample.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.thear.myownexample.MyExample;
import com.example.thear.myownexample.R;
import com.example.thear.myownexample.Screens;
import com.example.thear.myownexample.mvp.presenter.MyActivityPresenter;
import com.example.thear.myownexample.mvp.view.MyActivityView;
import com.example.thear.myownexample.ui.fragment.MyFragment;
import com.example.thear.myownexample.ui.fragment.MyNewFragment;
import com.example.thear.myownexample.ui.fragment.RecyclerViewFragment;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MyActivity extends MvpAppCompatActivity implements MyActivityView {
    @InjectPresenter
    MyActivityPresenter myActivityPresenter;

    @Inject
    NavigatorHolder mNavigatorHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        MyExample.getComponent().inject(this);
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.container) {

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Screens.FIRST_SCREEN:
                    return new MyFragment();
                case Screens.SECOND_SCREEN:
                    return new MyNewFragment();
                case Screens.THIRD_SCREEN:
                    return new RecyclerViewFragment();
                default:
                    return null;
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(MyActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mNavigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mNavigatorHolder.removeNavigator();
    }
}

package com.thedeveloperworldisyours.dagger2espresso.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.thedeveloperworldisyours.dagger2espresso.R;
import com.thedeveloperworldisyours.dagger2espresso.di.MainModule;
import com.thedeveloperworldisyours.dagger2espresso.di.component.AppComponent;
import com.thedeveloperworldisyours.dagger2espresso.di.component.DaggerMainComponent;
import com.thedeveloperworldisyours.dagger2espresso.presenter.MainPresenter;
import com.thedeveloperworldisyours.dagger2espresso.ui.common.BaseActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView, View.OnClickListener {

    @Inject
    MainPresenter mMainPresenter;

    @Bind(R.id.activity_main_button)
    Button mButton;

    @Bind(R.id.activity_main_progress)
    ProgressBar mProgressBar;

    @Bind(R.id.activity_main_image_view)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mButton.setOnClickListener(this);
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showImage(String image) {
        Picasso.with(this).load(image).into(mImageView);
    }

    @Override
    public void setErrorServer() {
        Toast.makeText(this, R.string.server_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        mMainPresenter.getLogo();
    }
}

package com.thedeveloperworldisyours.dagger2espresso.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.thedeveloperworldisyours.dagger2espresso.R;
import com.thedeveloperworldisyours.dagger2espresso.di.component.AppComponent;
import com.thedeveloperworldisyours.dagger2espresso.di.LoginModule;
import com.thedeveloperworldisyours.dagger2espresso.di.component.DaggerLoginComponent;
import com.thedeveloperworldisyours.dagger2espresso.presenter.LoginPresenter;
import com.thedeveloperworldisyours.dagger2espresso.ui.common.BaseActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    @Bind(R.id.activity_login_button)
    Button mButton;

    @Bind(R.id.activity_login_progress)
    ProgressBar mProgressBar;

    @Bind(R.id.activity_login_username)
    EditText mUserName;

    @Bind(R.id.activity_login_password)
    EditText mPassword;

    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);



        ButterKnife.bind(this);

        mButton.setOnClickListener(this);

    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
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
    public void setUsernameError() {
        mUserName.setError(getString(R.string.activity_login_username_error));
    }

    @Override
    public void setPasswordError() {
        mPassword.setError(getString(R.string.activity_login_password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void setErrorServer() {
        Toast.makeText(this, getString(R.string.server_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        mPresenter.validateCredentials(mUserName.getText().toString(), mPassword.getText().toString());
    }

}

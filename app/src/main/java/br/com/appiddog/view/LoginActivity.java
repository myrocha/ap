package br.com.appiddog.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import br.com.appiddog.R;
import br.com.appiddog.databinding.ActivityMainBinding;
import br.com.appiddog.viewmodel.LoginViewModel;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * login screen activity.
 */
public class LoginActivity extends DaggerAppCompatActivity implements HasActivityInjector {

    @Inject
    public LoginViewModel loginViewModel;
    ActivityMainBinding binding;


    @Inject
    public DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
       // setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(loginViewModel);

    }

    public void onLogin(final View view) {
        loginViewModel.onLogin().observe(this, response -> {


        });


        }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}




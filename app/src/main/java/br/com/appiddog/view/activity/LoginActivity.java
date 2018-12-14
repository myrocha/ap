package br.com.appiddog.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import br.com.appiddog.R;
import br.com.appiddog.databinding.LoginActivityBinding;
import br.com.appiddog.util.IntentActions;
import br.com.appiddog.util.OpenScreenUtility;
import br.com.appiddog.viewmodel.LoginViewModel;

/**
 * login screen activity.
 */
public class LoginActivity extends BaseActivity /*DaggerAppCompatActivity implements HasActivityInjector*/ {

    @Inject
    public LoginViewModel loginViewModel;
    LoginActivityBinding binding;
   // ActivitMain

  //  ActivityMainBinding binding;

/*
    @Inject
    public DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;*/




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // AndroidInjection.inject(this);
        //setContentView(R.layout.main_activity);

       binding =  DataBindingUtil.setContentView(this, R.layout.login_activity);
        binding.setViewModel(loginViewModel);

    }

    public void onLogin(final View view) {
        loginViewModel.showLoading();
        loginViewModel.onLogin().observe(this, response -> {
           // loginViewModel.hideLoading();
            loginViewModel.hideLoading();
            OpenScreenUtility.openScreen(this, IntentActions.MAIN_ACTIVITY.getAction(), null, false);

        });


        }

/*    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }*/
}




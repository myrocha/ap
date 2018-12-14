package br.com.appiddog.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import br.com.appiddog.R;
import br.com.appiddog.databinding.LoginActivityBinding;
import br.com.appiddog.util.IntentActions;
import br.com.appiddog.util.OpenScreenUtil;
import br.com.appiddog.viewmodel.LoginViewModel;

/**
 * login screen activity.
 */
public class LoginActivity extends BaseActivity {

    @Inject
    public LoginViewModel loginViewModel;
    LoginActivityBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.login_activity);
        binding.setViewModel(loginViewModel);




    }

    public void onLogin(final View view) {
        loginViewModel.showLoading();

        if (loginViewModel.getToken().isEmpty()) {
            final boolean checkFields = loginViewModel.checkLoginFields(binding, this);
            if (checkFields) {
                loginViewModel.onLogin().observe(this, response -> {
                    OpenScreenUtil.openScreen(this, IntentActions.MAIN_ACTIVITY.getAction(),
                            null, true);
                });
            }

        }
        loginViewModel.hideLoading();

    }

    @Override
    protected void onResume() {
        super.onResume();
        String token = loginViewModel.getToken();
        if (token != null && !token.isEmpty()) {
            OpenScreenUtil.openScreen(this, IntentActions.MAIN_ACTIVITY.getAction(),
                    null, true);
        }
    }
}




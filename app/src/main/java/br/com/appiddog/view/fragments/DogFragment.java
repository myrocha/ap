package br.com.appiddog.view.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import br.com.appiddog.R;
import br.com.appiddog.databinding.FragmentDogBinding;
import br.com.appiddog.eventbus.MessageEvent;
import br.com.appiddog.view.adapter.ListDogAdapter;
import br.com.appiddog.viewmodel.DogViewModel;
import dagger.android.support.AndroidSupportInjection;

public class DogFragment extends Fragment {
    private String mCategory;


    /*    public static DogFragment newInstance(final String category) {
            mCategory = category;
            return new DogFragment();

        }*/
    FragmentDogBinding binding;
    @Inject
    public DogViewModel dogViewModel;

   /* @Inject
    public DogFragment() {

    }*/

    public static DogFragment newInstance(final String category) {
        DogFragment fragmentFirst = new DogFragment();
       Bundle args = new Bundle();
        args.putString("category", category);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // page = getArguments().getInt("someInt", 0);
        mCategory = getArguments().getString("category");
    }
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dog, container, false);
        binding.setViewModel(dogViewModel);
        getListDog();

        return binding.getRoot();

    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            mCategory = bundle.getString("category");
        }
    }

    public void getListDog() {
       // dogViewModel.showLoading();
      //  binding.progressbarLogin.setVisibility(View.VISIBLE);
        dogViewModel.getListDog(mCategory).observe(this, response -> {
            // loginViewModel.hideLoading();
            if (response != null) {
                final RecyclerView recyclerView = binding.recyclerResource;
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
                ListDogAdapter adapter = new ListDogAdapter(getContext());
                recyclerView.setAdapter(adapter);
                adapter.setList(response.getList()) ;
            } else {
                binding.progressbarLogin.setVisibility(View.GONE);
            }

           // dogViewModel.hideLoading();
         //   OpenScreenUtil.openScreen(this, IntentActions.MAIN_ACTIVITY.getAction(), null, false);

        });


    }

    @Subscribe
    public void onEvent(final MessageEvent event) {
        //getIntent().removeExtra("register");
        //SnackbarUtility.showMessage(binding.lnlMenu, getString(R.string.edited_data));
      //  mRegisterResponse = event.responseRegister;
    }
}

package br.com.appiddog.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.appiddog.R;
import br.com.appiddog.view.adapter.holder.ListDogHolder;

public class ListDogAdapter extends RecyclerView.Adapter<ListDogHolder> {

    private Context mContext;
    private List<String> mListDog = new ArrayList<>();

    public ListDogAdapter(@NonNull Context context) {
        this.mContext = context;

    }

    @Override
    public ListDogHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_list, viewGroup, false);
        return new ListDogHolder(view);
    }

    @Override
    public void onBindViewHolder(ListDogHolder viewHolder, int position) {


        Picasso.get()
                .load(mListDog.get(position))
           /*     .fit()
                .centerCrop()*/
                .into(viewHolder.imageView);
                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
    }

    public void setList(final List<String> list) {
        this.mListDog.clear();
        this.mListDog.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mListDog == null) {
            return 0;
        }
        return mListDog.size();
    }
}

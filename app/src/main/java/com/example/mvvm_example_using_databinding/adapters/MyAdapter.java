package com.example.mvvm_example_using_databinding.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvm_example_using_databinding.R;
import com.example.mvvm_example_using_databinding.databinding.ModellayoutsBinding;
import com.example.mvvm_example_using_databinding.models.Geoname;
//import com.example.mvvm_example_using_databinding.models.Geonames;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {


    private static Context context;
    List<Geoname> geonames;




    public MyAdapter(Context context, List<Geoname> geonames) {
        this.context = context;
        this.geonames = geonames;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ll=LayoutInflater.from(parent.getContext());

        ModellayoutsBinding binding= DataBindingUtil.inflate(ll,R.layout.modellayouts,parent,false);

     //   ModellayoutsBinding binding=ModellayoutsBinding.inflate(ll,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Geoname geoname=geonames.get(position);
        holder.mbinding.setGeoname(geoname);

 /*   holder.mbinding.tv1.setText(geonames.get(position).getTitle());
        holder.mbinding.tv2.setText(geonames.get(position).getLang());
        holder.mbinding.tv3.setText(geonames.get(position).getSummary());
        Glide.with(context).load(geonames.get(position).getThumbnailImg()).into(holder.mbinding.iv);

  */

    }


    @Override
    public int getItemCount() {
        return geonames.size();
    }

   public class MyViewHolder extends RecyclerView.ViewHolder{

       ModellayoutsBinding mbinding;


        public MyViewHolder(@NonNull ModellayoutsBinding itemView) {
            super(itemView.getRoot());


            this.mbinding=itemView;
          //  modellayoutsBinding.prograss.setVisibility(View.VISIBLE);

        }
    }

    @BindingAdapter("android:loading")
    public static  void loadiv(ImageView iv, String st){

        Glide.with(context).load(st).into(iv);

    }




/*
    private void custome_webView(String url){
        Uri uri = Uri.parse(url);
        CustomTabsIntent.Builder intent_bulder = new CustomTabsIntent.Builder();
        intent_bulder.setShowTitle(true);
        intent_bulder.setToolbarColor(ContextCompat.getColor(context, R.color.colorAccent));
        intent_bulder.setSecondaryToolbarColor(ContextCompat.getColor(context, R.color.design_default_color_primary_dark));
        intent_bulder.setExitAnimations(context, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        CustomTabsIntent customTabsIntent = intent_bulder.build();
        customTabsIntent.intent.setPackage("com.android.chrome");
        customTabsIntent.launchUrl(context, uri);

    }

 */

}

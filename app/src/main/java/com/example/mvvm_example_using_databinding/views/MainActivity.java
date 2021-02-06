package com.example.mvvm_example_using_databinding.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.mvvm_example_using_databinding.adapters.MyAdapter;
import com.example.mvvm_example_using_databinding.databinding.ActivityMainBinding;
import com.example.mvvm_example_using_databinding.models.Geoname;
import com.example.mvvm_example_using_databinding.viewmodel.GopiViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    GopiViewModel viewModel;
    MyAdapter myAdapter;
    List<Geoname>  gold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        LinearLayoutManager ll=new
                LinearLayoutManager(this);
               // GridLayoutManager(this,2);
        mainBinding.rview.setLayoutManager(ll);
        gold=new ArrayList<>();

        setSupportActionBar(mainBinding.toolbar);
        mainBinding.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        viewModel= ViewModelProviders.of(this).get(GopiViewModel.class);

        mainBinding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             @Nullable String raju=mainBinding.et1.getText().toString();
                if (raju.isEmpty()){
                    Toast.makeText(MainActivity.this, "enter text", Toast.LENGTH_SHORT).show();
                }else
                {
                    gopiraju(raju);

                }
            }
        });


        gopiraju("india");

    }

    private void gopiraju(String gopi) {
        viewModel.getgeonames(true,gopi,10,"srik784","full").observe(this, geonames ->  {
                if (geonames!=null){
                    gold=geonames.getGeonames();

                    myAdapter=new MyAdapter(MainActivity.this,gold);
                    mainBinding.rview.setHasFixedSize(true);
                    mainBinding.rview.setAdapter(myAdapter);
                }

                if ( geonames.getGeonames().isEmpty()){
                    Toast.makeText(MainActivity.this, "sorry not available", Toast.LENGTH_SHORT).show();
                }
            });
    }

}
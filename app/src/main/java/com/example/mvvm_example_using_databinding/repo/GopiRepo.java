package com.example.mvvm_example_using_databinding.repo;

import android.icu.text.UFormat;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_example_using_databinding.models.Geonames;
import com.example.mvvm_example_using_databinding.networking.ApiEndPoint;
import com.example.mvvm_example_using_databinding.networking.ApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GopiRepo {
    ApiEndPoint apiEndPoint;
    public GopiRepo(){
        apiEndPoint= ApiResponse.retrofit().create(ApiEndPoint.class);
    }
    public LiveData<Geonames>  getnames(boolean g,String o,int p,String i,String r){
        MutableLiveData<Geonames> data=new MutableLiveData<>();
        apiEndPoint.getgeonames(g,o,p,i,r).enqueue(new Callback<Geonames>() {
            @Override
            public void onResponse(@Nullable  Call<Geonames> call,@Nullable Response<Geonames> response) {
                if (response!=null){
                    data.setValue(response.body());
                    Log.d("#########","data seted");

                }


            }

            @Override
            public void onFailure(@Nullable Call<Geonames> call,@Nullable Throwable t) {
                data.setValue(null);
                Log.d("############","data is not seted");

            }
        });


        return data;
    }


}

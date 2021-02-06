package com.example.mvvm_example_using_databinding.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_example_using_databinding.models.Geonames;
import com.example.mvvm_example_using_databinding.repo.GopiRepo;

public class GopiViewModel extends ViewModel {
    public GopiRepo gopiRepo;

    public GopiViewModel() {
        gopiRepo=new GopiRepo();
    }


    public LiveData<Geonames>  getgeonames(boolean g,String o,int p,String i,String r){
        return gopiRepo.getnames(g,o,p,i,r);
    }
}

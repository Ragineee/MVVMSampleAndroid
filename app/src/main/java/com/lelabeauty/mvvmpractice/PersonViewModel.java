package com.lelabeauty.mvvmpractice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lelabeauty.mvvmpractice.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonViewModel extends ViewModel {
    MutableLiveData<List<Person>> personlist;

    public LiveData<List<Person>> getPersons(){
        if(personlist==null){
            personlist=new MutableLiveData<>();
            loadPersonList();
        }
        return personlist;
    }

    private void loadPersonList() {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(Service.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service=retrofit.create(Service.class);
        Call<List<Person>> call=service.getPersonList();
        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                personlist.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {

            }
        });
    }

}

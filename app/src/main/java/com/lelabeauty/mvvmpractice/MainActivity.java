package com.lelabeauty.mvvmpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.lelabeauty.mvvmpractice.adapter.RecyclerAdapter;
import com.lelabeauty.mvvmpractice.model.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView list;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));

        PersonViewModel viewModel= ViewModelProviders.of(this).get(PersonViewModel.class);
        viewModel.getPersons().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
                adapter=new RecyclerAdapter(people,MainActivity.this);
                list.setAdapter(adapter);

            }
        });
    }
}

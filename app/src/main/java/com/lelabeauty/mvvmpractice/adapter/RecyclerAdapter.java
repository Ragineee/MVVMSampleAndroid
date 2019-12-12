package com.lelabeauty.mvvmpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lelabeauty.mvvmpractice.R;
import com.lelabeauty.mvvmpractice.model.Person;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    List<Person> PersonList;
    Context context;

    public RecyclerAdapter(List<Person> personList, Context context) {
        PersonList = personList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.child,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person= PersonList.get(position);
        holder.bindData(person);

    }

    @Override
    public int getItemCount() {
        return PersonList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.text);
            image=itemView.findViewById(R.id.imageView);
        }

        public void bindData(Person person) {
            name.setText(person.getName());
            Glide.with(context)
                    .load(person.getPicUrl())
                    .into(image);
        }
    }
/*
    List<Person> PersonList;
    Context context;

    public RecyclerAdapter(List<Person> personList, Context context) {
      this.PersonList = personList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.child,parent,false);
        MyviewHolder myviewHolder=new MyviewHolder(view);
        return myviewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

      Person person=PersonList.get(position);
      holder.bindData(person);

    }


    @Override
    public int getItemCount() {
        return PersonList.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder {
       private TextView name;
       private ImageView image;

        public MyviewHolder( View itemView) {

            super(itemView);
            name=itemView.findViewById(R.id.text);
            image=itemView.findViewById(R.id.imageView);

        }

        public void bindData(Person person){
            name.setText(person.getName());
            Glide.with(context)
                    .load(person.getPicUrl())
                    .into(image);


        }
    }
*/

}

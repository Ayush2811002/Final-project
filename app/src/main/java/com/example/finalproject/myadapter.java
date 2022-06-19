package com.example.finalproject;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class myadapter extends FirebaseRecyclerAdapter<mode,myadapter.myviewholder> {
    public myadapter(@NonNull FirebaseRecyclerOptions<mode> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull mode mode) {
        holder.title.setText(mode.getTitle());
        holder.info.setText(mode.getInfo());
        Glide.with(holder.img.getContext()).load(mode.getPurul()).into(holder.img);


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single,parent,false);
        return new myviewholder(view);

    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        TextView info,title;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img=(CircleImageView) itemView.findViewById(R.id.img1);
            title=(TextView)itemView.findViewById(R.id.nametext);
            info=(TextView)itemView.findViewById(R.id.emailtext);
        }
    }

}

package com.example.newyork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Booksadapter extends RecyclerView.Adapter<Booksadapter.BooksViewholder> {
  private String[] data;
    public Booksadapter(String[] data)
    {this.data=data;}

    @Override
    public BooksViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_layout,parent,false);
        return new BooksViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewholder holder, int position) {
    String title=data[position];
    holder.txt.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class BooksViewholder extends RecyclerView.ViewHolder{
        ImageView imgicon;
        TextView txt;
        public BooksViewholder(@NonNull View itemView) {
            super(itemView);
            imgicon=itemView.findViewById(R.id.imgicon);
            txt=itemView.findViewById(R.id.txt);
        }
    }
}

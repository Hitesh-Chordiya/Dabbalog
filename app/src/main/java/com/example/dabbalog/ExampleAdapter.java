package com.example.dabbalog;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    //6.2
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);

    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }
    //1
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        //2
        public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            //4

            textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            Helper.pos=position-1;
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    //6.1
    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        mExampleList = exampleList;
    }


    //3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //5
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view,mListener);
        return exampleViewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        //7
        ExampleItem currentItem = mExampleList.get(i);
        exampleViewHolder.textView.setText(currentItem.getmText());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }




}


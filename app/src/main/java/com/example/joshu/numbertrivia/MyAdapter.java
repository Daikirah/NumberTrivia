package com.example.joshu.numbertrivia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<TriviaItem> mTriviaItems;

    public MyAdapter(ArrayList<TriviaItem> triviaItems) {
        mTriviaItems = triviaItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_left, parent, false);
            return new MyViewHolder0(view);
        }
        else if (viewType == 2)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_right, parent, false);
            return new MyViewHolder2(view);
        }   else {
            throw new RuntimeException("Wrong Type!");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()){
            case 0:
                MyViewHolder0 viewHolder0 = (MyViewHolder0)viewHolder;
                viewHolder0.mNumber.setText(mTriviaItems.get(position).getNumber().toString());
                viewHolder0.mQuote.setText(mTriviaItems.get(position).getText());
                break;

            case 2:
                MyViewHolder2 viewHolder2 = (MyViewHolder2)viewHolder;
                viewHolder2.mNumber.setText(mTriviaItems.get(position).getNumber().toString());
                viewHolder2.mQuote.setText(mTriviaItems.get(position).getText());
                break;
        }

    }


    @Override
    public int getItemViewType(int position) {
        return position % 2 * 2;
    }

    @Override
    public int getItemCount() {
        return mTriviaItems.size();
    }


    public class MyViewHolder0 extends RecyclerView.ViewHolder{
        public TextView mNumber;
        public TextView mQuote;

        public MyViewHolder0(View itemView) {
            super(itemView);
            mNumber = itemView.findViewById(R.id.number_left);
            mQuote = itemView.findViewById(R.id.quote_left);
        }

    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder{
        public TextView mNumber;
        public TextView mQuote;

        public MyViewHolder2(View itemView) {
            super(itemView);
            mNumber = itemView.findViewById(R.id.number_right);
            mQuote = itemView.findViewById(R.id.quote_right);
        }

    }
}

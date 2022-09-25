package com.example.scrollapp;


import android.content.Intent;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    private Object[][] dataSet;// = {{R.drawable.sh, "SHSH"}};

    public adapter(Object[][] dataSet) {
        this.dataSet = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txt;

        public ViewHolder(View view) {
            super(view);

            img = view.findViewById(R.id.img1);
            txt = view.findViewById(R.id.text2);
        }

        public ImageView getImg() {
            return img;
        }

        public TextView getTxt() {return txt;}
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("HELP", "ONCREATEVIEWHOLDER");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getImg().setImageResource((Integer)dataSet[position][0]);
        Log.d("HELP", (String)dataSet[position][1]);
        holder.getTxt().setText((String)dataSet[position][1]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }
}


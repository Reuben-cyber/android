package com.example.scrollapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BlankFragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank1, container, false);
    }

    RecyclerView rvMain;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvMain = getActivity().findViewById(R.id.recycle);
        rvMain.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rvMain.setAdapter(new RvAdapter());
    }

    class RowHolder extends RecyclerView.ViewHolder {

        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class AdHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView txt;

        public AdHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            txt = itemView.findViewById(R.id.text2);
        }
        public ImageView getImg() {
            return img;
        }

        public TextView getTxt() {return txt;}

    }

    class RvAdapter extends RecyclerView.Adapter<AdHolder> {
        private Object[][] data = {{R.drawable.sh, "AMC Hall"},
                {R.drawable.b1, "ABC Hall"},
                {R.drawable.b2, "XYZ Hall"},
                {R.drawable.b3, "GFG Hall"}};


        public RvAdapter() {
            this.data = data;
        }
        //

        @NonNull
        @Override
        public AdHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
            return new AdHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull AdHolder holder, int position) {
                        holder.getImg().setImageResource((Integer) data[position][0]);
            Log.d("HELP", (String) data[position][1]);
            holder.getTxt().setText((String) data[position][1]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity().getApplicationContext(), "hey", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return 4;
        }

    }
}
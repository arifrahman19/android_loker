package com.example.welcomebos.loker2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welcomebos.loker2.Model.Result;
import com.example.welcomebos.loker2.R;
import com.example.welcomebos.loker2.TampilActivity;
import com.example.welcomebos.loker2.UpdateActivity;
import com.squareup.picasso.Picasso;
//import com.example.welcomebos.loker2.UpdateActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.id;

/**
 * Created by Welcome Bos on 7/8/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private Context context;
    private List<Result> results;

    public RecyclerViewAdapter(Context context, List<Result> results) {
        this.context = context;
        this.results = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = results.get(position);
        holder.textViewID.setText(result.getId());
        holder.textViewNama.setText(result.getNama());
        holder.textViewDeskripsi.setText(result.getDeskripsi());
        holder.textViewJeniskelamin.setText(result.getSesi());
        Picasso.with(context).load(result.getImage()).into(holder.imageView);
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, UpdateActivity.class);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.textID) TextView textViewID;
        @BindView(R.id.textNama) TextView textViewNama;
        @BindView(R.id.textDeskripsi) TextView textViewDeskripsi;
        @BindView(R.id.textJeniskelamin) TextView textViewJeniskelamin;
        @BindView(R.id.image_view)  ImageView imageView;
        //@BindView(R.id.cardView) CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String npm = textViewID.getText().toString();
            String nama = textViewNama.getText().toString();
            String deskripsi = textViewDeskripsi.getText().toString();
            String jeniskelamin = textViewJeniskelamin.getText().toString();

            Intent i = new Intent(context, TampilActivity.class);
            i.putExtra("nama", nama);
            i.putExtra("deskripsi", deskripsi);
            i.putExtra("jeniskelamin", jeniskelamin);
            context.startActivity(i);
        }
    }
}

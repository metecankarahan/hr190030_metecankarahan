package com.hr190030.metecan_karahan_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190030.metecan_karahan_final.R;
import com.hr190030.metecan_karahan_final.model.TakimModel;
import com.hr190030.metecan_karahan_final.util.GlideUtil;

import java.util.List;

public class TakimAdaptor extends RecyclerView.Adapter<TakimViewHolder> {


    List<TakimModel> takimlar;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener{
        void onClik(int position);
    }


    public TakimAdaptor(List<TakimModel> takimlar, Context context, OnItemClickListener listener) {
        this.context = context;
        this.takimlar = takimlar;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TakimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_takim,parent,false);
        return new TakimViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TakimViewHolder viewHolder, int position) {

        viewHolder.txtTakimAdi.setText(takimlar.get(position).getTakimAdi());
        viewHolder.txtTarih.setText(takimlar.get(position).getTakimKurulusTarihi());
        GlideUtil.resmiIndiripGoster(context,takimlar.get(position).getLogoUrl(),viewHolder.imgTakimLogo);

    }

    @Override
    public int getItemCount() {
        return takimlar.size();
    }
}
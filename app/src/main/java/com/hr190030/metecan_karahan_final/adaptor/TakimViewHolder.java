package com.hr190030.metecan_karahan_final.adaptor;

import com.hr190030.metecan_karahan_final.R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class TakimViewHolder extends RecyclerView.ViewHolder {

    ImageView imgTakimLogo;
    TextView txtTakimAdi;
    TextView txtTarih;

    public TakimViewHolder(@NonNull View cardView,TakimAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgTakimLogo =cardView.findViewById(R.id.imgTakimLogo);
        txtTakimAdi =cardView.findViewById(R.id.txtTakimAdi);
        txtTarih =cardView.findViewById(R.id.txtTarih);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                listener.onClik(getAdapterPosition());
            }

        });
    }
}
package com.hr190030.metecan_karahan_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hr190030.metecan_karahan_final.R;
import com.hr190030.metecan_karahan_final.adaptor.TakimAdaptor;
import com.hr190030.metecan_karahan_final.model.TakimModel;
import com.hr190030.metecan_karahan_final.network.Service;
import com.hr190030.metecan_karahan_final.util.Constants;
import com.hr190030.metecan_karahan_final.util.ObjectUtil;
import com.hr190030.metecan_karahan_final.util.ProgressDialogListe;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        ProgressDialogListe.Kontrol(ListeActivity.this);
        init();

    }

    private void init() {
        takimlariGetir();
    }

    void takimlariGetir() {

        new Service().getServiceApi().takimlariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<TakimModel>>() {

                    List<TakimModel> takimlar = new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT", "onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<TakimModel> takimList) {
                        Log.e("RETROFIT", "onNext : ");
                        takimlar = takimList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT", "onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("RETROFIT", "onComplete : ");

                        if (takimlar.size() > 0) {
                            initRecycleView(takimlar);
                        }
                    }
                });
    }


    private void initRecycleView(List<TakimModel> takimList) {
        recyclerView = findViewById(R.id.rcvTakimlar);
        TakimAdaptor takimAdaptor = new TakimAdaptor(takimList, getApplicationContext(), new TakimAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {
                TakimModel tiklananTakim = takimList.get(position);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.tiklanan_adi) + tiklananTakim.getTakimAdi(), Toast.LENGTH_SHORT).show();

                opennextActivity(tiklananTakim);

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(takimAdaptor);
    }

    private void opennextActivity(TakimModel tiklananTakim) {

        Intent secondActivityIntent = new Intent(getApplicationContext(), TakimDetayActivity.class);
        String tiklananTakimString = ObjectUtil.takimToJsonString(tiklananTakim);

        secondActivityIntent.putExtra(Constants.TIKLANAN_TAKIM_TASINANIN_BASLIGI, tiklananTakimString);
        startActivity(secondActivityIntent);
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(ListeActivity.this);
        builder.setMessage(getResources().getString(R.string.liste_cıkıs_mesaj));
        builder.setCancelable(true);
        builder.setNegativeButton(getResources().getString(R.string.liste_pozitif), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.liste_negatif), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
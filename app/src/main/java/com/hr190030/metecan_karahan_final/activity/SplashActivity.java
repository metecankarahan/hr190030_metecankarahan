package com.hr190030.metecan_karahan_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;


import com.hr190030.metecan_karahan_final.R;
import com.hr190030.metecan_karahan_final.util.NetworkCheck;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init(getBaseContext());
    }
        private void init(Context context){
            CountDownTimer countDownTimer =new CountDownTimer(3000,1000) {
                @Override
                public void onTick(long l) {

                    Log.e("COUNTER","TİCK");
                }
                @Override
                public void onFinish() {
                    if (!NetworkCheck.checkOnline(context)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                        builder.setMessage(context.getResources().getString(R.string.network_cikis_mesaj));
                        builder.setCancelable(true);
                        builder.setNegativeButton(context.getResources().getString(R.string.network_negatif_buton), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                System.exit(0);
                            }

                        });
                        builder.setPositiveButton(context.getResources().getString(R.string.network_pozitif_buton), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }else {
                        opennextActivity();
                    }
                }
            };
            countDownTimer.start();
        }
        private void opennextActivity(){
        Log.e("COUNTER", "FİNİSH");
            Intent secondActivityIntent = new Intent(getApplicationContext(), ListeActivity.class);
            startActivity(secondActivityIntent);
            finish();


        }
    }
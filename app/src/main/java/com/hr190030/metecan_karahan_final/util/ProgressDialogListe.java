package com.hr190030.metecan_karahan_final.util;

import android.app.ProgressDialog;
import android.content.Context;

import com.hr190030.metecan_karahan_final.R;

public class ProgressDialogListe {
    public static void Kontrol(Context context){
     ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage(context.getResources().getString(R.string.lutfen_bekleyin));
        progressDialog.show();
        final int totalTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while(jumpTime < totalTime) {
                    try {
                        sleep(20);
                        jumpTime += 1;
                        progressDialog.setProgress(jumpTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (jumpTime==100){
                    progressDialog.dismiss();
                }
            }
        };
        t.start();
    }
}

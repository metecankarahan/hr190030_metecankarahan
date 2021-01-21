package com.hr190030.metecan_karahan_final.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hr190030.metecan_karahan_final.R;
import com.hr190030.metecan_karahan_final.model.TakimModel;
import com.hr190030.metecan_karahan_final.util.Constants;
import com.hr190030.metecan_karahan_final.util.GlideUtil;
import com.hr190030.metecan_karahan_final.util.ObjectUtil;

import org.w3c.dom.Text;

public class TakimDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtDetay;
    

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takim_detay);

        init();

    }

        @RequiresApi(api = Build.VERSION_CODES.N)
        private void init(){

            String tasinanTakimString =getIntent().getStringExtra(Constants.TIKLANAN_TAKIM_TASINANIN_BASLIGI);

            TakimModel takimModel = ObjectUtil.jsonStringToTakim(tasinanTakimString);

            imgKapak = findViewById(R.id.imgKapak);
            txtBaslik = findViewById(R.id.txtBaslik);
            txtDetay = findViewById(R.id.txtDetay);



            txtBaslik.setText(takimModel.getTakimAdi());
            txtDetay.setText(Html.fromHtml(takimModel.getTakimTarihcesi(),Html.FROM_HTML_MODE_COMPACT));


            GlideUtil.resmiIndiripGoster(getApplicationContext(),takimModel.getKapakFotoUrl(),imgKapak);



        }

}
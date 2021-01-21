package com.hr190030.metecan_karahan_final.util;

import android.content.Context;
import android.net.ConnectivityManager;

public class NetworkCheck {
    public static boolean checkOnline(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}

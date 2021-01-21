package com.hr190030.metecan_karahan_final.network;


import com.hr190030.metecan_karahan_final.model.TakimModel;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("FutbolTakimlariApi.json")
    Observable<List<TakimModel>> takimlariGetir();
}

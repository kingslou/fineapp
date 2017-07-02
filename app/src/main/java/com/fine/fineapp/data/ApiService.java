package com.fine.fineapp.data;

import android.content.Context;

import com.fine.fineapp.App;
import com.fine.fineapp.BuildConfig;
import com.fine.fineapp.data.model.VersionInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * 所有的api接口
 * Created by YiMuTian on 2017/7/2.
 */

public interface ApiService {

    String ENDPOINT = "www.baidu.com";

    @GET("test.json")
    Observable<VersionInfo> getVersionInfo();

    /******** Factory class that sets up a new ribot services *******/
    class Factory {

        public static ApiService makeApiService(Context context) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                    : HttpLoggingInterceptor.Level.NONE);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiService.ENDPOINT)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(ApiService.class);
        }

    }

}

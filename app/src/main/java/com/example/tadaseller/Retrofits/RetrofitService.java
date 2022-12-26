package com.example.tadaseller.Retrofits;

import java.lang.reflect.GenericSignatureFormatError;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static final String BASEURL = "https://tada.progressiveaidata.in/api/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder ()
                    .baseUrl (BASEURL)
                    .addConverterFactory (GsonConverterFactory.create ())
                    .build ();
        }

        return retrofit;
    }
}

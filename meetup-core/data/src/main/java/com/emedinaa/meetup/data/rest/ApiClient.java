package com.emedinaa.meetup.data.rest;


import com.emedinaa.meetup.data.rest.entity.EventList;
import com.emedinaa.meetup.data.rest.entity.MemberResponse;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by eduardomedina on 7/12/16.
 */
public class ApiClient {

    private static final String TAG = "ApiClient";
    private static final String API_BASE_URL="https://api.meetup.com/";

    private static ServicesApiInterface servicesApiInterface;
    private static OkHttpClient.Builder httpClient;



    public static ServicesApiInterface getMyApiClient() {

        if (servicesApiInterface == null) {

            Retrofit.Builder builder =new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
            httpClient =new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor());

            Retrofit retrofit = builder.client(httpClient.build()).build();
            servicesApiInterface = retrofit.create(ServicesApiInterface.class);
        }
        return servicesApiInterface;
    }

    public interface ServicesApiInterface {

        //https://api.meetup.com/self/groups?&sign=true&photo-host=public
        @GET("/self/groups")
        Call<Object> groups();

        @GET("/{group_urlname}/events/")
        Call<Object> events(@Path("group_urlname") String group_urlname);

        @GET("/{group_urlname}/events/past")
        Call<Object> pastEvents(@Path("group_urlname") String group_urlname);

        @GET("/2/members")
        Call<MemberResponse> membersByGroup(@QueryMap Map<String, String> options);

        @GET("/2/events")
        Call<EventList> eventsByGroup(@QueryMap Map<String, String> options);
        //page

        @GET("/{group_urlname}/events")
        Call<Object> groupEvents(@Path("group_urlname") String group_urlname, @QueryMap Map<String, String> options);
        //page
    }

    private  static HttpLoggingInterceptor interceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}

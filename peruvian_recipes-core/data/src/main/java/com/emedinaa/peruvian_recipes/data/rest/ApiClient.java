package com.emedinaa.peruvian_recipes.data.rest;


import com.emedinaa.peruvian_recipes.data.rest.entity.EventList;
import com.emedinaa.peruvian_recipes.data.rest.entity.LogInRaw;
import com.emedinaa.peruvian_recipes.data.rest.entity.LogInResponse;
import com.emedinaa.peruvian_recipes.data.rest.entity.MemberResponse;
import com.emedinaa.peruvian_recipes.data.rest.entity.RecipesResponse;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by eduardomedina on 7/12/16.
 */
public class ApiClient {

    private static final String TAG = "ApiClient";
    //private static final String API_BASE_URL="https://api.meetup.com/";

    private static final String API_BASE_URL="http://api.backendless.com";

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

        @Headers({
                "Content-Type: application/json",
                "application-id: E7E2C1DE-C32D-81BF-FF94-48702F281100",
                "secret-key: B39B4E0A-495B-364A-FF1F-26E1B0C87C00",
                "application-type: REST"
        })
        //v1/users/login
        @POST("/v1/users/login")
        Call<LogInResponse> login(@Body LogInRaw raw);

        @Headers({
                "Content-Type: application/json",
                "application-id: E7E2C1DE-C32D-81BF-FF94-48702F281100",
                "secret-key: B39B4E0A-495B-364A-FF1F-26E1B0C87C00",
                "application-type: REST"
        })
        //v1/data/Notes
        @GET("/v1/data/Recipe")
        Call<RecipesResponse> recipes();

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

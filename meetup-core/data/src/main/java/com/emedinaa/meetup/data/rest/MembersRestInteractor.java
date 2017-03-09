package com.emedinaa.meetup.data.rest;

import android.util.Log;

import com.emedinaa.meetup.data.mapper.MemberMapper;
import com.emedinaa.meetup.data.rest.entity.MemberResponse;
import com.emedinaa.meetup.domain.callback.StorageCallback;
import com.emedinaa.meetup.domain.interactors.MembersInteractor;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by eduardo on 11/12/16.
 */
public class MembersRestInteractor implements MembersInteractor {

    private static final String TAG = "MembersRestI";
    private final MemberMapper memberMapper;

    public MembersRestInteractor(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public void membersByGroup(String group_urlname, final StorageCallback storageCallback) {
        Map<String, String> options = new HashMap<>();
        options.put("key",Constants.MEETUPKEY);
        //options.put("key","");
        options.put("sign","true");
        options.put("photo-host","public");
        options.put("group_urlname", group_urlname);
        options.put("page", "100");

        Call<MemberResponse> call= ApiClient.getMyApiClient().membersByGroup(options);
        execute(call,storageCallback);
    }

    @Override
    public void membersByGroup(String group_urlname, int page, final StorageCallback storageCallback) {
        Map<String, String> options = new HashMap<>();
        options.put("key",Constants.MEETUPKEY);
        options.put("sign","true");
        options.put("photo-host","public");
        options.put("group_urlname", group_urlname);
        options.put("page",Integer.toString(page));

        Call<MemberResponse> call= ApiClient.getMyApiClient().membersByGroup(options);
        execute(call,storageCallback);

    }

    @Override
    public void membersByGroup(String group_urlname, int totalByPage, int offset,final StorageCallback storageCallback) {

        Map<String, String> options = new HashMap<>();
        options.put("key",Constants.MEETUPKEY);
        options.put("sign","true");
        options.put("photo-host","public");
        options.put("group_urlname", group_urlname);
        options.put("page",Integer.toString(totalByPage));
        options.put("offset",Integer.toString(offset));

        Call<MemberResponse> call= ApiClient.getMyApiClient().membersByGroup(options);
        execute(call,storageCallback);

    }

    private void execute(Call<MemberResponse> call,final StorageCallback storageCallback){
        call.enqueue(new Callback<MemberResponse>() {
            @Override
            public void onResponse(Call<MemberResponse> call, Response<MemberResponse> response) {
                if(response.isSuccessful()){
                    MemberResponse memberResponse= response.body();
                    if(memberResponse!=null){
                        Log.v(TAG, "response.body "+response.body());
                        storageCallback.onSuccess(memberMapper.transformList(memberResponse.getResults()));
                    }else {
                        Exception exception= new Exception("Error");
                        storageCallback.onFailure(exception);
                    }

                }else {

                    Exception exception=null;
                    try{
                        JSONObject jsonError = new JSONObject(response.errorBody().string());
                        String code= jsonError.getString("code")+ " "+jsonError.getString("problem");
                        exception= new Exception(code);
                    }catch (Exception e){
                        exception= new Exception(e);
                    }

                    Log.v(TAG, "response.errorBody "+exception.getMessage());
                    storageCallback.onFailure(exception);
                }
            }

            @Override
            public void onFailure(Call<MemberResponse> call, Throwable t) {
                String message="Error ";
                try {
                    message= new StringBuffer().append(t.getMessage()).toString();
                }catch (NullPointerException e) {}
                Log.v(TAG, "onFailure >>>> " + message);
                Exception exception= new Exception(message);
                storageCallback.onFailure(exception);
            }
        });
    }

}

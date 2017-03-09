package com.emedinaa.meetup.domain.interactors;


import com.emedinaa.meetup.domain.callback.StorageCallback;

/**
 * Created by eduardo on 11/12/16.
 */
public interface MembersInteractor {

    void membersByGroup(String group_urlname, StorageCallback callback);
    void membersByGroup(String group_urlname, int offset, StorageCallback callback);
    void membersByGroup(String group_urlname, int totalByPage, int offset, StorageCallback callback);
}

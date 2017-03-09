package com.emedinaa.meetup.data.entity;

import java.io.Serializable;

/**
 * Created by eduardo on 10/12/16.
 */
public class GroupEntity implements Serializable {

    private String created;
    private String name;
    private String id;
    private String join_mode;
    private String lat;
    private String lon;
    private String urlname;
    private String who;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoin_mode() {
        return join_mode;
    }

    public void setJoin_mode(String join_mode) {
        this.join_mode = join_mode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getUrlname() {
        return urlname;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}

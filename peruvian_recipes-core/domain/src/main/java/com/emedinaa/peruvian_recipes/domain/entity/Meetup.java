package com.emedinaa.peruvian_recipes.domain.entity;

import java.io.Serializable;

/**
 * Created by eduardo on 10/12/16.
 */
public class Meetup implements Serializable {

    private int id;
    private String name;
    private Venue venue;
    private String status;
    private String time;
    private  int waitlist_count;
    private int yes_rsvp_coun;
    private String link;
    private String description;
    private String visibility;
    private String url;
    private Group group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getWaitlist_count() {
        return waitlist_count;
    }

    public void setWaitlist_count(int waitlist_count) {
        this.waitlist_count = waitlist_count;
    }

    public int getYes_rsvp_coun() {
        return yes_rsvp_coun;
    }

    public void setYes_rsvp_coun(int yes_rsvp_coun) {
        this.yes_rsvp_coun = yes_rsvp_coun;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Meetup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", venue=" + venue +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", waitlist_count=" + waitlist_count +
                ", yes_rsvp_coun=" + yes_rsvp_coun +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", visibility='" + visibility + '\'' +
                ", url='" + url + '\'' +
                ", group=" + group +
                '}';
    }
}

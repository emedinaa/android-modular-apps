package com.emedinaa.meetup.data.entity;


/**
 * Created by eduardo on 10/12/16.
 */
public class MeetupEntity  {

    private int id;
    private String name;
    private VenueEntity venue;
    private String status;
    private String time;
    private  int waitlist_count;
    private int yes_rsvp_coun;
    private String link;
    private String description;
    private String visibility;
    private String event_url;
    private GroupEntity group;

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

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public VenueEntity getVenue() {
        return venue;
    }

    public void setVenue(VenueEntity venue) {
        this.venue = venue;
    }

    public String getEvent_url() {
        return event_url;
    }

    public void setEvent_url(String event_url) {
        this.event_url = event_url;
    }
}

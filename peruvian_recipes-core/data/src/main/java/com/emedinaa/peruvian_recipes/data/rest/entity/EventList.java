package com.emedinaa.peruvian_recipes.data.rest.entity;


import com.emedinaa.peruvian_recipes.data.entity.MeetupEntity;

import java.util.List;

public class EventList extends BaseResponse {
    public List<MeetupEntity> results;

    public List<MeetupEntity> getResults() {
        return results;
    }

    public void setResults(List<MeetupEntity> results) {
        this.results = results;
    }
}

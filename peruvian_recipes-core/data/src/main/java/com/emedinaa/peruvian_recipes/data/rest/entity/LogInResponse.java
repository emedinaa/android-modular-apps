package com.emedinaa.peruvian_recipes.data.rest.entity;

/**
 * Created by emedinaa on 13/03/17.
 */

public class LogInResponse extends BaseResponse {
    private String name;
    private String photo;
    private String objectId;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.emedinaa.peruvian_recipes.data.entity;

/**
 * Created by eduardo on 11/12/16.
 */
public class PhotoEntity {

    private String highres_link;
    private String photo_id;
    private String base_url;
    private String type;
    private String photo_link;
    private String thumb_link;

    public String getHighres_link() {
        return highres_link;
    }

    public void setHighres_link(String highres_link) {
        this.highres_link = highres_link;
    }

    public String getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto_link() {
        return photo_link;
    }

    public void setPhoto_link(String photo_link) {
        this.photo_link = photo_link;
    }

    public String getThumb_link() {
        return thumb_link;
    }

    public void setThumb_link(String thumb_link) {
        this.thumb_link = thumb_link;
    }
}

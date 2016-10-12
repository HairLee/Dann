package com.hailpt.com.youtubeeng.Object;

/**
 * Created by hailpt on 07/10/2016.
 */

public class Snippet {

    private String title;
    private String description;
    private Thumbnail thumbnails;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnail getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnail thumbnails) {
        this.thumbnails = thumbnails;
    }
}

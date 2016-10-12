package com.hailpt.com.youtubeeng.Object;

/**
 * Created by hailpt on 07/10/2016.
 */

public class Youtube {


    private Item items;
    private PageInfo pageInfo;
    private String nextPageToken;

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }
}

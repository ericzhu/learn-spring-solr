package com.booster.data.document;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

import com.booster.data.entity.Item;

public class ItemDocument {

    public ItemDocument() {}

    public ItemDocument(Long id, String title, String sellPoint, Long price, String image, Long cid, Boolean status, Date updated) {
        this.id = id;
        this.title = title;
        this.sellPoint = sellPoint;
        this.price = price;
        this.image = image;
        this.cid = cid;
        this.status = status;
        this.updated = updated;
    }

    public ItemDocument(Item item) {
        this(item.getId(), item.getTitle(), item.getSellPoint(), item.getPrice(), item.getImage(), item.getCid(), item.getStatus(), item.getUpdated());
    }

    @Field("id")
    private Long    id;

    @Field("title")
    private String  title;

    @Field("sellPoint")
    private String  sellPoint;

    @Field("price")
    private Long    price;

    @Field("image")
    private String  image;

    @Field("cid")
    private Long    cid;

    @Field("status")
    private Boolean status;

    @Field("updated")
    private Date    updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "ItemDocument [id="
            + id
            + ", title="
            + title
            + ", sellPoint="
            + sellPoint
            + ", price="
            + price
            + ", image="
            + image
            + ", cid="
            + cid
            + ", status="
            + status
            + ", updated="
            + updated
            + "]";
    }
}

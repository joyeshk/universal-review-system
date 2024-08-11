package com.jk.universalreview.users.DTO.external;

import java.sql.Timestamp;

public class Reviews {
    private String review_id;
    private String user_id;
    private String review;
    private Timestamp timestamp;
    private double rating;
    private String entity_id;

    public String getReview_id() {
        return review_id;
    }

    public void setReview_id(String review_id) {
        this.review_id = review_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }

    public Reviews(String review_id, String user_id, String review, Timestamp timestamp, double rating, String entity_id) {
        this.review_id = review_id;
        this.user_id = user_id;
        this.review = review;
        this.timestamp = timestamp;
        this.rating = rating;
        this.entity_id = entity_id;
    }

    public Reviews() {
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "review_id='" + review_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", review='" + review + '\'' +
                ", timestamp=" + timestamp +
                ", rating=" + rating +
                ", entity_id='" + entity_id + '\'' +
                '}';
    }
}

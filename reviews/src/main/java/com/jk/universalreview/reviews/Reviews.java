package com.jk.universalreview.reviews;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String review_id;
    private String user_id;
    private String review;
    @CreationTimestamp
    private Timestamp timestamp;
    private double rating;

    private String entity_id;

    //getter setter, noArg and all Args constructor, toString, hashcode

    public Reviews() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reviews reviews = (Reviews) o;

        if (Double.compare(reviews.rating, rating) != 0) return false;
        if (!review_id.equals(reviews.review_id)) return false;
        if (!user_id.equals(reviews.user_id)) return false;
        if (!Objects.equals(review, reviews.review)) return false;
        if (!Objects.equals(timestamp, reviews.timestamp)) return false;
        return entity_id.equals(reviews.entity_id);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = review_id.hashCode();
        result = 31 * result + user_id.hashCode();
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + entity_id.hashCode();
        return result;
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

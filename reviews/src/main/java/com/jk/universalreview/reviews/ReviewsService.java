package com.jk.universalreview.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {
    @Autowired
    ReviewsRepo reviewsRepo;

    public List<Reviews> getAllReviews(){
        return reviewsRepo.findAll();
    }

    public Reviews addReview(Reviews reviews){
        reviewsRepo.save(reviews);
        return reviews;
    }
}

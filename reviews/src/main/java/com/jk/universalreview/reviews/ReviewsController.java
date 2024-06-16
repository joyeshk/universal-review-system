package com.jk.universalreview.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;
    @GetMapping("/list")
    public List<Reviews> list(){
        return reviewsService.getAllReviews();
    }

    @PostMapping("/add")
    public void addReview(@RequestBody Reviews reviews){
        reviewsService.addReview(reviews);
    }

}

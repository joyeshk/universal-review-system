package com.jk.universalreview.users.service.external;

import com.jk.universalreview.users.DTO.external.Reviews;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEWS",url = "http://localhost:8083")
public interface ReviewsService {

    @RequestMapping("/reviews/getAllUserReviews/{user_id}")
    List<Reviews> getUserReviews(@PathVariable("user_id") String userId);
}

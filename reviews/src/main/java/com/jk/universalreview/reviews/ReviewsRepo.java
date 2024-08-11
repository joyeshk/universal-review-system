package com.jk.universalreview.reviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewsRepo extends JpaRepository<Reviews,String> {

@Query(value = "SELECT * FROM reviews WHERE user_id = :userid", nativeQuery = true)
    List<Reviews> findByUserId(@Param("userid") String userId);
}

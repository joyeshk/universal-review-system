package com.jk.universalreview.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String> {

    //custom query method
    @Modifying
    @Query(value = "update users set email=:email where user_id=:user_id", nativeQuery = true)
    void updateEmail(@Param("user_id") String user_id,@Param("email") String email);
}

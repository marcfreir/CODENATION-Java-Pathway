package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long>
{
    @Query("SELECT DISTINCT cha FROM Challenge cha "
    + "JOIN cha.accelerations AS accel "
    + "JOIN accel.candidates AS candi "
    + "JOIN candi.id.user user "
    + "WHERE user.id = :userId "
    + "AND accel.id = :accelerationId")
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);
}

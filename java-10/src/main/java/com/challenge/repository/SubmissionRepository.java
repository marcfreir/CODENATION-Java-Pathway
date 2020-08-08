package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId>
{
    @Query("SELECT max(submission.score) FROM Submission submission "
    + "JOIN submission.id.challenge cha "
    + "WHERE cha.id = :challengeId")
    Optional<BigDecimal> findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query("SELECT submission FROM Submission submission "
    + "JOIN submission.id.challenge cha "
    + "JOIN cha.accelerations acceleration "
    + "WHERE acceleration.id = :accelerationId "
    + "AND cha.id = :challengeId")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}

package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>
{
    Optional<Company> findById(Long id);
    List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);
    List<Company> findByCandidatesIdUserId(Long userId);
}

package com.example.JobService.Repository;

import com.example.JobService.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job,Long> {
    List<Job> findByTitleContainingIgnoreCase(
            String title);

    List<Job> findByLocationContainingIgnoreCase(
            String location);

    List<Job> findByCompanyNameContainingIgnoreCase(
            String companyName);

    List<Job> findByRecruiterId(Long recruiterId);
}

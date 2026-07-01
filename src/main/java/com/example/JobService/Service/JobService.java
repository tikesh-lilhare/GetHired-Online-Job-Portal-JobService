package com.example.JobService.Service;

import com.example.JobService.DTO.JobReq;
import com.example.JobService.DTO.JobRes;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobService {
    JobRes createJob(JobReq request);

    List<JobRes> getAllJobs();

    JobRes getJobById(Long id);

    JobRes updateJob(
            Long id,
            JobReq request);

    void deleteJob(Long id);

    List<JobRes> searchByTitle(
            String title);

    List<JobRes> searchByLocation(
            String location);

    List<JobRes> searchByCompany(
            String company);

    Page<JobRes> getAllJobs(
            int page,
            int size,
            String sortBy,
            String direction
    );

    List<JobRes> getAllJob();

    List<JobRes> getRecruiterJobs(Long recruiterId);
}

package com.example.JobService.Service;

import com.example.JobService.DTO.JobReq;
import com.example.JobService.DTO.JobRes;
import com.example.JobService.Entity.Job;
import com.example.JobService.Exception.CompanyNotFoundException;
import com.example.JobService.Exception.JobNotFoundException;
import com.example.JobService.Repository.JobRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements  JobService{
    private final JobRepo jobRepo;

    @Override
    public JobRes createJob(
            JobReq request) {

        Job job = Job.builder()
                .title(request.getTitle())
                .description(
                        request.getDescription())
                .location(
                        request.getLocation())
                .salary(
                        request.getSalary())
                .companyName(
                        request.getCompanyName())


                .skills(request.getSkills())
                .recruiterId(request.getRecruiterId())
                .build();


        Job savedJob =
                jobRepo.save(job);

        return mapToResponse(savedJob);
    }
    @Override
    public List<JobRes> getAllJobs() {

        return jobRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    @Override
    public JobRes getJobById(
            Long id) {

        Job job =
                jobRepo.findById(id)
                        .orElseThrow(
                                () ->
                                        new JobNotFoundException(
                                                "Job not found"));

        return mapToResponse(job);
    }
    @Override
    public JobRes updateJob(
            Long id,
            JobReq request) {

        Job job =
                jobRepo.findById(id)
                        .orElseThrow(
                                () ->
                                        new JobNotFoundException(
                                                "Job not found"));

        job.setTitle(
                request.getTitle());
        job.setDescription(
                request.getDescription());
        job.setLocation(
                request.getLocation());
        job.setSalary(
                request.getSalary());
        job.setCompanyName(
                request.getCompanyName());
        job.setRecruiterId(request.getRecruiterId());

        return mapToResponse(
                jobRepo.save(job));
    }
    @Override
    public void deleteJob(
            Long id) {

        Job job =
                jobRepo.findById(id)
                        .orElseThrow(
                                () ->
                                        new JobNotFoundException(
                                                "Job not found"));

        jobRepo.delete(job);
    }

    private JobRes mapToResponse(
            Job job) {

        return new JobRes(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getLocation(),
                job.getSalary(),
                job.getCompanyName(),
                job.getSkills(),
                job.getRecruiterId()
        );
    }
    @Override
    public List<JobRes> searchByTitle(
            String title) {

        return jobRepo
                .findByTitleContainingIgnoreCase(
                        title
                )
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    @Override
    public List<JobRes> searchByLocation(
            String location) {

        return jobRepo
                .findByLocationContainingIgnoreCase(
                        location
                )
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    @Override
    public List<JobRes> searchByCompany(
            String company) {

        List<Job> jobs =
                jobRepo.findByCompanyNameContainingIgnoreCase(
                        company
                );

        if(jobs.isEmpty()) {

            throw new CompanyNotFoundException(
                    "Company '" + company +
                            "' not available"
            );
        }

        return jobs.stream()
                .map(this::mapToResponse)
                .toList();
    }
    @Override
    public Page<JobRes> getAllJobs(
            int page,
            int size,
            String sortBy,
            String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        sort
                );

        Page<Job> jobs =
                jobRepo.findAll(pageable);

        return jobs.map(
                this::mapToResponse
        );
    }
    @Override
    public List<JobRes> getAllJob() {

        return jobRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    @Override
    public List<JobRes> getRecruiterJobs(Long recruiterId) {

        return jobRepo.findByRecruiterId(recruiterId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
}

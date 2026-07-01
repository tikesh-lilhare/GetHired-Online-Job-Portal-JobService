package com.example.JobService.Contoller;

import com.example.JobService.DTO.JobReq;
import com.example.JobService.DTO.JobRes;
import com.example.JobService.Service.JobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @PostMapping
    public JobRes createJob(
            @Valid
            @RequestBody
            JobReq request) {

        return jobService.createJob(
                request);
    }

    @GetMapping
    public Page<JobRes> getAllJobs(

            @RequestParam(
                    defaultValue = "0")
            int page,

            @RequestParam(
                    defaultValue = "8")
            int size,

            @RequestParam(
                    defaultValue = "id")
            String sortBy,

            @RequestParam(
                    defaultValue = "asc")
            String direction) {

        return jobService.getAllJobs(
                page,
                size,
                sortBy,
                direction
        );
    }

    @GetMapping("/{id}")
    public JobRes getJob(
            @PathVariable Long id) {

        return jobService.getJobById(id);
    }
    @PutMapping("/{id}")
    public JobRes updateJob(
            @PathVariable Long id,
            @Valid
            @RequestBody
            JobReq request) {

        return jobService.updateJob(
                id,
                request);
    }
    @DeleteMapping("/{id}")
    public String deleteJob(
            @PathVariable Long id) {

        jobService.deleteJob(id);

        return "Job Deleted Successfully";
    }
    @GetMapping("/search/title")
    public List<JobRes> searchByTitle(
            @RequestParam String title) {

        return jobService
                .searchByTitle(title);
    }
    @GetMapping("/search/location")
    public List<JobRes> searchByLocation(
            @RequestParam String location) {

        return jobService
                .searchByLocation(location);
    }
    @GetMapping("/search/company")
    public List<JobRes> searchByCompany(
            @RequestParam String company) {

        return jobService
                .searchByCompany(company);
    }
    @GetMapping("/all")
    public List<JobRes> getAllJob() {

        return jobService.getAllJob();
    }
    @GetMapping("/recruiter/{recruiterId}")
    public List<JobRes> getRecruiterJobs(
            @PathVariable Long recruiterId) {

        return jobService.getRecruiterJobs(recruiterId);

    }
}

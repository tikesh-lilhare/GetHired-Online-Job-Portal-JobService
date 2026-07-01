package com.example.JobService.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JobReq {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String location;

    @NotNull
    private Double salary;

    @NotBlank
    private String companyName;

    private String skills;

    private Long recruiterId;
}

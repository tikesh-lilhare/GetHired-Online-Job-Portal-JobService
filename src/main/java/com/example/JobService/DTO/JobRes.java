package com.example.JobService.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobRes {
    private Long id;

    private String title;

    private String description;

    private String location;

    private Double salary;

    private String companyName;
    private String skills;
    private Long recruiterId;
}

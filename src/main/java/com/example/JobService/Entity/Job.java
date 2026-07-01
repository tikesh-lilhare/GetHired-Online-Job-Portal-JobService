package com.example.JobService.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String location;

    private Double salary;

    private String companyName;

    private String skills;

    private Long recruiterId;
}

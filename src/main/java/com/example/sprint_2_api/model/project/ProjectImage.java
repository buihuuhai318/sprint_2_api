package com.example.sprint_2_api.model.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProjectImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "LONGTEXT")
    private String name;

    @ManyToOne
    @JoinColumn(name = "project_id",referencedColumnName = "id")
    private CharitableProject project;
}

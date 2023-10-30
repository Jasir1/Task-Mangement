package com.taita.webapp.taskmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.TO_DO;
    @Column(name = "due_at")
    private LocalDate dueAt;
    @Column(name = "created_by")
    private Long createdBy;
    @ManyToOne
    @JoinColumn(name = "created_by",referencedColumnName = "id",insertable = false,updatable = false)
    private User user;
    private boolean active = true;

}

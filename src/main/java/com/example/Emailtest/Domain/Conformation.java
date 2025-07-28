package com.example.Emailtest.Domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "Conformation")
public class Conformation {
    @Id
     @SequenceGenerator(
        name="studentSequence",
        sequenceName="studentSequence",
        allocationSize=1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="studentSequence")
    Long Id;
    public String token;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public LocalDateTime createDate;
    @OneToOne(targetEntity = Student.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name = "Student_Id")
    private Student student;

    public Conformation(Student student) {
        this.student = student;
        this.createDate=LocalDateTime.now();
        this.token= UUID.randomUUID().toString();
    }

    public Student getStudent() {
        return student;
    }
}

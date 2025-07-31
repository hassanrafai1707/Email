package com.example.Emailtest.Domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Performance")
public class Performance {
    @Id
    @SequenceGenerator(
            name = "performanceSequence",
            sequenceName = "performanceSequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="performanceSequence")

    private Long Id;

    private LocalDateTime LastUpdate=LocalDateTime.now();
    private Double feedBackScore=0.0;
    private Integer eventsHost=0;
    private Integer pointEarned=0;
    @OneToOne(targetEntity = Student.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name = "Student_Id")
    private Student student;
    public Integer getPointEarned() {
        return pointEarned;
    }

    public void setPointEarned(Integer pointEarned) {
        this.pointEarned = pointEarned;
    }

    public Integer getEventsHost() {
        return eventsHost;
    }

    public void setEventsHost(Integer eventsHost) {
        this.eventsHost = eventsHost;
    }

    public Double getFeedBackScore() {
        return feedBackScore;
    }

    public void setFeedBackScore(Double feedBackScore) {
        this.feedBackScore = feedBackScore;
    }

    public LocalDateTime getLastUpdate() {
        return LastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        LastUpdate = lastUpdate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}

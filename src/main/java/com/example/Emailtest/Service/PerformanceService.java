package com.example.Emailtest.Service;

import com.example.Emailtest.Domain.Performance;
import com.example.Emailtest.Domain.Student;
import com.example.Emailtest.Repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PerformanceService {

    private final PerformanceRepository performanceRepository;

    public Performance createDefault(Student student) {
        Performance performance = new Performance();
        performance.setStudent(student);
        performance.setEventsHost(0);
        performance.setFeedBackScore(0.0);
        performance.setPointEarned(0);
        performance.setLastUpdate(LocalDateTime.now());
        return performanceRepository.save(performance);
    }

    public Performance getByStudentId(Long studentId) {
        return performanceRepository.findByStudentId(studentId);
    }

    public Performance updatePerformance(Long studentId, int events, double score, int points) {
        Performance p = performanceRepository.findByStudentId(studentId);
        p.setEventsHost(events);
        p.setFeedBackScore(score);
        p.setPointEarned(points);
        p.setLastUpdate(LocalDateTime.now());
        return performanceRepository.save(p);
    }

    public Performance getPerformanceById(Long Id) {
        return performanceRepository.findByStudentId(Id);
    }
}

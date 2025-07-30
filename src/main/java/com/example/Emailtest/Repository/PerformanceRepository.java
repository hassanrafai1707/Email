package com.example.Emailtest.Repository;

import com.example.Emailtest.Domain.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance ,Long> {
    public Performance findByStudentId(Long Student_Id);;

}

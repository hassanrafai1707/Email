package com.example.Emailtest.Repository;

import com.example.Emailtest.Domain.Conformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConformationRepository extends JpaRepository<Conformation,Long> {
    public Conformation findByToken(String token);
}

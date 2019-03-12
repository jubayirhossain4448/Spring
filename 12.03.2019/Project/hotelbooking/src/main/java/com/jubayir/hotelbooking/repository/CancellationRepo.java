package com.jubayir.hotelbooking.repository;

import com.jubayir.hotelbooking.entity.Cancellation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationRepo extends JpaRepository<Cancellation, Long> {

}

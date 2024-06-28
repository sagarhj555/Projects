package com.example.WebApplication.Repository;

import com.example.WebApplication.Model.StudDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface crudRepo extends JpaRepository<StudDetails, Integer> {

//    @Query("select s from StudDetails s where s.name = ?1")
//    List<StudDetails> getByKey(String key);

    /**
     * Above and Below method does the same job
     */

    List<StudDetails> getByName(String name);
}

package com.example.WebApplication.Services;

import com.example.WebApplication.Model.StudDetails;
import com.example.WebApplication.Repository.crudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class crudJpaService {

    @Autowired
    crudRepo crudRepo;

    public List<StudDetails> studData() {
        return crudRepo.findAll();
    }

    public StudDetails getStudId(int id) {
        return crudRepo.findById(id).orElseThrow();
    }

    public String addStudents(StudDetails st) {
        crudRepo.save(st);
        return "added";
    }

    public String updStud(StudDetails st) {
        crudRepo.save(st);
        return "updated";
    }

    public String deleteStud(int id) {
        crudRepo.deleteById(id);
        return "deleted";
    }

    public List<StudDetails> getByKey(String key) {
//        return crudRepo.getByKey(key);
        return crudRepo.getByName(key);
    }
}

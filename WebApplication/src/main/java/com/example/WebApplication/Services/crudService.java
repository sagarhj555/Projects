package com.example.WebApplication.Services;

import com.example.WebApplication.Model.StudDetails;
import com.example.WebApplication.Repository.crudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class crudService {

    @Autowired
    crudRepo crudRepo;

    List<StudDetails> ls = new ArrayList(Arrays.asList(new StudDetails(1, "one", 12346789, "book1"),
            new StudDetails(2, "two", 7895465, "book2"),
            new StudDetails(3, "three", 4161651, "book3"),
            new StudDetails(4, "four", 4986131, "book4")));

    public List<StudDetails> studData() {
        return ls;
    }

    public StudDetails getStudId(int id) {

//        for(int i=0; i<ls.size(); i++){      // looping through for
//            if(ls.get(i).getId() == id){
//                return ls.get(i);
//            }
//        }

//            for (StudDetails s : ls) {           // looping through foreach
//                if (s.getId() == id) {
//                    return s;
//                }
//            }
        return ls.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .get();

    }

    public String addStudents(StudDetails st) {
        ls.add(st);
        return "added";
    }

    public String updStud(StudDetails st) {
        for (StudDetails s : ls) {
            if (s.getId() == st.getId()) {
//                s.setId(st.getId());
//                s.setName(st.getName());
//                s.setMobNo(st.getMobNo());
//                s.setBook(st.getBook());

                //  or below one
                ls.set(s.getId() - 1, st);
                return "updated";
            }
        }
        return null;
    }

    public String deleteStud(int id) {
        ls.remove(getStudId(id));
        return "deleted";
    }

    public String load() {
        crudRepo.saveAll(ls);
        return "loaded";
    }
}

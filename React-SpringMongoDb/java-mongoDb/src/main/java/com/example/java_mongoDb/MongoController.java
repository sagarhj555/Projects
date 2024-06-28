package com.example.java_mongoDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MongoController extends Object{

    @Autowired private MongoRepo repo;

    @GetMapping("/getall")
    public List<Post> getAll(){
        return repo.findAll();
    }

    @GetMapping("/search/{text}")
    public List<Post> search(@PathVariable String text){
        return repo.findByProfileLike(text);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Post> getById(@PathVariable int id){
        Optional<Post> personId = repo.findById(id);
        if (personId.isPresent()) {
            return ResponseEntity.ok(personId.get());
        }
        return ResponseEntity.notFound().build();
        //return personId.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Post savePerson(@RequestBody Post person){
        return repo.save(person);
    }

    @PostMapping("/saveall")
    public ResponseEntity<String> saveAll(@RequestBody List<Post> post){
        repo.saveAll(post);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/save/{id}")
    public ResponseEntity<Post> updatePersonById(@PathVariable int id, @RequestBody Post person){
        if(repo.findById(id).isPresent()) {
            return ResponseEntity.ok(repo.save(person));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

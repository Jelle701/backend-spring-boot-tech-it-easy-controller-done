package com.example_jelle.backendspringboottechiteasycontroller.controllers;

import com.example_jelle.backendspringboottechiteasycontroller.exceptions.RecordNotFoundException;
import com.example_jelle.backendspringboottechiteasycontroller.exceptions.TooLongNameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final List<String> televisionDatabase = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<String>> getAllTelevisions() {
        return ResponseEntity.ok(televisionDatabase);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevision(@PathVariable int id) {
        if (id < 0 || id >= televisionDatabase.size() || televisionDatabase.get(id) == null) {
            throw new RecordNotFoundException("Er bestaat geen televisie met id " + id);
        }
        return ResponseEntity.ok(televisionDatabase.get(id));
    }


    @PostMapping
    public ResponseEntity<String> addTelevision(@RequestBody String name) {
        if (name.length() > 20) {
            throw new TooLongNameException("Naam mag niet langer zijn dan 20 karakters");
        }

        televisionDatabase.add(name);
        return ResponseEntity.ok("Added: " + name);
    }




    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody String newName) {
        televisionDatabase.set(id, newName);
        return ResponseEntity.ok("Updated id " + id + " to: " + newName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        televisionDatabase.set(id, null);
        return ResponseEntity.ok("Television at id " + id + " removed");
    }
}

package com.example.demo.model;


import com.example.demo.EmployeeRepository;
import com.example.demo.PositionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class MainController {

    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;

    public MainController(EmployeeRepository employeeRepository, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
    }
    @GetMapping
    public List<Position> getValues()
    {
        List<Position> result = new LinkedList<>();
        positionRepository.findAll().forEach(result :: add);
        return result;
    }
    @PostMapping
    public ResponseEntity postValue(@RequestBody Position position)
    {
        return ResponseEntity.ok(positionRepository.save(position));
    }

}

package com.flamexander.spring.ws.HW;

import com.flamexander.spring.ws.entities.StudentEntity;
import com.flamexander.spring.ws.repositories.StudentRepository;
import com.flamexander.spring.ws.soap.students.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final productRepository productRepository;

    public static final Function<ProductEntity, Product> functionEntityToSoap = se -> {
        Student s = new Student();
        s.setId(se.getId());
        s.setTitle(se.getTitle());
        s.setCost(se.getCost());
        return s;
    };

    public List<Product> getAllProducts() {
        return productRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public Student getByTitle(String Title) {
        return productRepository.findByName(Title).map(functionEntityToSoap).get();
    }
}

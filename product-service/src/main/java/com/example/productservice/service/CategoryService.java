package com.example.productservice.service;

import com.example.productservice.model.Category;
import com.example.productservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ConcurrentHashMap<Long, Category> cache = new ConcurrentHashMap<>();

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Flux<Category> getAllCategories() {
        return categoryRepository.findAll()
                .doOnNext(c -> cache.put(c.getId(), c));
    }

    public Mono<Category> getCategoryById(Long id) {
        Category cached = cache.get(id);
        if (cached != null) {
            return Mono.just(cached);
        }
        return categoryRepository.findById(id)
                .doOnNext(c -> cache.put(id, c));
    }
}
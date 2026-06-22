package com.example.userservice.service;

import com.example.userservice.model.Role;
import com.example.userservice.repository.RoleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final ConcurrentHashMap<Long, Role> roleCache = new ConcurrentHashMap<>();

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Mono<Role> getRoleById(Long id) {
        Role cached = roleCache.get(id);
        if (cached != null) {
            return Mono.just(cached);
        }
        return roleRepository.findById(id)
                .doOnNext(role -> roleCache.put(id, role));
    }

    public Flux<Role> getAllRoles() {
        return roleRepository.findAll()
                .doOnNext(role -> roleCache.put(role.getId(), role));
    }

    public Mono<Role> createRole(Role role) {
        return roleRepository.save(role)
                .doOnNext(saved -> roleCache.put(saved.getId(), saved));
    }
}
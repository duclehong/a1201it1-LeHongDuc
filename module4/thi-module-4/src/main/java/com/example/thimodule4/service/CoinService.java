package com.example.thimodule4.service;

import com.example.thimodule4.model.Coin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoinService {
    Page<Coin> findAll(Pageable pageable);
    void save(Coin coin);
    void delete(int id);
    Coin findById(int id);
    Page<Coin> findAllByNameContaining(String name, Pageable pageable);
}

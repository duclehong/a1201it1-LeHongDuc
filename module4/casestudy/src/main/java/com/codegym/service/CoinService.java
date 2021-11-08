package com.codegym.service;


import com.codegym.model.Coin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoinService {
    Page<Coin> findAll(Pageable pageable);
    void save(Coin coin);
    void delete(int id);
    Coin findById(int id);
}

package com.example.thimodule4.service.impl;

import com.example.thimodule4.model.Coin;
import com.example.thimodule4.repository.CoinRepository;
import com.example.thimodule4.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoinServiceImpl implements CoinService {
    @Autowired
    CoinRepository coinRepository;
    @Override
    public Page<Coin> findAll(Pageable pageable) {
        return coinRepository.findAll(pageable);
    }

    @Override
    public void save(Coin coin) {
        coinRepository.save(coin);
    }

    @Override
    public void delete(int id) {
        coinRepository.deleteById(id);
    }

    @Override
    public Coin findById(int id) {
        return coinRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Coin> findAllByNameContaining(String name, Pageable pageable) {
        return coinRepository.findAllByNameContaining(name, pageable);
    }
}

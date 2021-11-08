package com.codegym.service.impl;


import com.codegym.model.Coin;
import com.codegym.repository.CoinRepository;
import com.codegym.service.CoinService;
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
}

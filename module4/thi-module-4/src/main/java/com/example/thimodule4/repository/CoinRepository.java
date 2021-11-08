package com.example.thimodule4.repository;

import com.example.thimodule4.model.Coin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository extends PagingAndSortingRepository<Coin,Integer> {
    Page<Coin> findAllByNameContaining(String name, Pageable pageable);
}

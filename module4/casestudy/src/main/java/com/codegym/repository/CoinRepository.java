package com.codegym.repository;


import com.codegym.model.Coin;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository extends PagingAndSortingRepository<Coin,Integer> {

}

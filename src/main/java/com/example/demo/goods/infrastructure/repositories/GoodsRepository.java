package com.example.demo.goods.infrastructure.repositories;

import com.example.demo.goods.domain.model.entites.Goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GoodsRepository extends JpaRepository<Goods, String>{
    
}

package com.example.demo.goods.infrastructure.repositories;

import com.example.demo.goods.domain.model.entites.Goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface GoodsRepository extends JpaRepository<Goods, String>{
    @Override
    @RestResource(exported = false)
    Goods save(Goods s);

    // Prevents DELETE /books/:id
    @Override
    @RestResource(exported = false)
    void delete(Goods t);
}

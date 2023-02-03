package com.wtiinfo.wtimeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wtiinfo.wtimeta.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

}

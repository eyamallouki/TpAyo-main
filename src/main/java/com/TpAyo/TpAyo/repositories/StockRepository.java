package com.TpAyo.TpAyo.repositories;

import com.TpAyo.TpAyo.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.TpAyo.TpAyo.entities.Stock;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock , Long> {
    @Query("SELECT s.produits FROM Stock s where s.qteStock < s.qteMin ")
    public List<Produit> getStockProduits();
}

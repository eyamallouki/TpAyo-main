package com.TpAyo.TpAyo.services;

import com.TpAyo.TpAyo.repositories.ProduitRepository;
import com.TpAyo.TpAyo.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.TpAyo.TpAyo.entities.Produit;
import com.TpAyo.TpAyo.entities.Stock;

import java.util.List;

@Service

public class StockServiceImp implements ICrudService<Stock , Long> , IStockService {
    @Autowired
    StockRepository stockRepository ;
    @Autowired
    ProduitRepository produitRepository ;
    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock add(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock update(Stock stock  , Long idProduit) {
        if(stockRepository.findById(idProduit).isPresent()) {
            Stock s = stockRepository.findById(idProduit).get();
            s.setQteStock(s.getQteStock());
            s.setQteMin(s.getQteMin());
            s.setLibelleStock(s.getLibelleStock());
            return stockRepository.save(s);
        }
        return  null;
    }
    @Override
    public void delete(Long idProduit) {
        stockRepository.deleteById(idProduit);
    }
    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Stock s = stockRepository.findById(idStock).get();
        Produit p = produitRepository.findById(idProduit).get();
        p.setStock(s);
        s.getProduits().add(p);
        System.out.println(s.getProduits());
        produitRepository.save(p);
        stockRepository.save(s);
    }
    @Scheduled(cron ="0 22 * * ?")
    @Override
    public String retrieveStatusStock() {
        List<Produit> produitList =  stockRepository.getStockProduits() ;
        produitList.stream().forEach(produit -> System.out.println(produit.getLibelleProduit()));
        return null ;
    }
}

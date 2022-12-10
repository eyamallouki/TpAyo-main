package com.TpAyo.TpAyo.services;

import com.TpAyo.TpAyo.entities.Fournisseur;
import com.TpAyo.TpAyo.repositories.FournisseurRepository;
import com.TpAyo.TpAyo.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TpAyo.TpAyo.entities.Produit;

import java.util.Date;
import java.util.List;

@Service
public class ProduitServiceImp implements ICrudService<Produit , Long> , IProduitService{
    @Autowired
    ProduitRepository produitRepository ;
    @Autowired
    FournisseurRepository fournisseurRepository ;
    @Override
    public List<Produit> getAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit add(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit update(Produit produit  , Long idProduit) {
        if(produitRepository.findById(idProduit).isPresent()) {

            Produit prod = produitRepository.findById(idProduit).get();
            prod.setCodeProduit(produit.getCodeProduit());
            prod.setLibelleProduit(produit.getLibelleProduit());
            prod.setPrixUnitaire(produit.getPrixUnitaire());
            prod.setDetailFactures(produit.getDetailFactures());
            prod.setFournisseurs(produit.getFournisseurs());
            return produitRepository.save(prod);
        }
        return  null;
    }

    @Override
    public void delete(Long idProduit) {
        produitRepository.deleteById(idProduit);
    }
    @Override
    public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
        Produit produit = produitRepository.findById(idProduit).orElse(null);
        return produitRepository.getRevenuBrutProduit(produit, startDate, endDate);
    }
}

package com.TpAyo.TpAyo.services;

import com.TpAyo.TpAyo.entities.Fournisseur;
import com.TpAyo.TpAyo.entities.Produit;
import com.TpAyo.TpAyo.repositories.DetailProduitRepository;
import com.TpAyo.TpAyo.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TpAyo.TpAyo.entities.DetailProduit;

import java.util.List;

@Service
public class DetailProduitServiceImp implements ICrudService<DetailProduit , Long> ,IDetailProduitService{

    @Autowired
    DetailProduitRepository detailProduitRepository ;

    @Autowired
    FournisseurRepository fournisseurRepository;




    @Override
    public List<DetailProduit> getAll() {
        return detailProduitRepository.findAll();
    }

    @Override
    public DetailProduit add(DetailProduit detailProduit) {
        return detailProduitRepository.save(detailProduit);
    }

    @Override
    public DetailProduit update(DetailProduit detailProduit, Long idDetailProduit) {
        if(detailProduitRepository.findById(idDetailProduit).isPresent()) {

            DetailProduit detProd = detailProduitRepository.findById(idDetailProduit).get();
            detProd.setProduit(detailProduit.getProduit());
            detProd.setCategoriProduit(detailProduit.getCategoriProduit());
            return detailProduitRepository.save(detProd);
        }
        return null;
    }
    @Override
    public void delete(Long idDetailProduit) {
        detailProduitRepository.deleteById(idDetailProduit);
    }


}

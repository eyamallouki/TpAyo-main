package com.TpAyo.TpAyo.services;

import com.TpAyo.TpAyo.repositories.DetailFactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TpAyo.TpAyo.entities.DetailFacture;

import java.util.List;

@Service
public class DetailFactureServiceImp implements ICrudService<DetailFacture , Long> , IDetailFactureService{
    @Autowired
    DetailFactureRepository detailFactureRepository ;
    @Override
    public List<DetailFacture> getAll() {
        return detailFactureRepository.findAll();
    }

    @Override
    public DetailFacture add(DetailFacture detailFacture) {
        return detailFactureRepository.save(detailFacture);
    }

    @Override
    public DetailFacture update(DetailFacture detailFacture, Long idDetailFActure) {
        if(detailFactureRepository.findById(idDetailFActure).isPresent()) {

            DetailFacture detfacture= detailFactureRepository.findById(idDetailFActure).get();
            detfacture.setMontantRemise(detailFacture.getMontantRemise());
            detfacture.setPourcentageRemise(detailFacture.getPourcentageRemise());
            detfacture.setQte(detailFacture.getQte());
            detfacture.setFacture(detailFacture.getFacture());
            detfacture.setPrixTotal(detfacture.getPrixTotal());
            detfacture.setProduit(detailFacture.getProduit());
            return detailFactureRepository.save(detfacture);
        }
        return null;
    }

    @Override
    public void delete(Long idDetailFActure) {
        detailFactureRepository.deleteById(idDetailFActure);


    }
}

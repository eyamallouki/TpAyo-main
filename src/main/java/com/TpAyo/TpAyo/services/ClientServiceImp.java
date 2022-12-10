package com.TpAyo.TpAyo.services;

import com.TpAyo.TpAyo.entities.CategorieClient;
import com.TpAyo.TpAyo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TpAyo.TpAyo.entities.Client;

import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImp implements ICrudService<Client , Long > , IClientService {
    @Autowired
    ClientRepository clientRepository ;
    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client  , Long idClient) {
        if(clientRepository.findById(idClient).isPresent()) {
            Client clientt = clientRepository.findById(idClient).get();
           clientt.setNom(client.getNom());
           clientt.setPrenom(client.getPrenom());
           clientt.setEmail(client.getEmail());
           clientt.setPassword(client.getPassword());
           clientt.setProfession(client.getProfession());
           clientt.setDateNaissance(client.getDateNaissance());
            return clientRepository.save(clientt);
        }
        return  null;
    }

    @Override
    public void delete(Long idClient) {
        clientRepository.deleteById(idClient);

    }

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
        try {
            return clientRepository.getChiffreAffaireParCategorieClient(categorieClient, startDate, endDate);
        } catch (Exception e) {
            return 0 ;
        }
    }
}


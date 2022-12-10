package com.TpAyo.TpAyo.services;

import com.TpAyo.TpAyo.entities.CategorieClient;

import java.util.Date;

public interface IClientService {
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);
}

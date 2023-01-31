package net.ent.etrs.ultramp3.model.dao;


import net.ent.etrs.ultramp3.model.dao.base.BaseDao;
import net.ent.etrs.ultramp3.model.entities.Musique;

import java.io.Serializable;
import java.util.Optional;

public interface DaoMusique extends BaseDao<Musique, Serializable> {

    Optional<Musique> searchMusiqueByTitre(String nom);

}

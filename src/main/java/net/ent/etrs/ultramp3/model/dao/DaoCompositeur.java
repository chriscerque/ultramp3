package net.ent.etrs.ultramp3.model.dao;


import net.ent.etrs.ultramp3.model.dao.base.BaseDao;
import net.ent.etrs.ultramp3.model.dao.impl.DaoException;
import net.ent.etrs.ultramp3.model.entities.Compositeur;
import net.ent.etrs.ultramp3.model.entities.references.Genre;

import java.io.Serializable;
import java.util.Set;

public interface DaoCompositeur extends BaseDao<Compositeur, Serializable> {

    Set<Compositeur> findByGenre(Genre genre) throws DaoException;
}

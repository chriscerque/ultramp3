package net.ent.etrs.megamovies.model.dao;


import net.ent.etrs.megamovies.model.dao.base.BaseDao;
import net.ent.etrs.megamovies.model.dao.impl.DaoException;
import net.ent.etrs.megamovies.model.entities.Realisateur;
import net.ent.etrs.megamovies.model.entities.references.Genre;

import java.io.Serializable;
import java.util.Set;

public interface DaoRealisateur extends BaseDao<Realisateur, Serializable> {

    Set<Realisateur> findByGenre(Genre genre) throws DaoException;
}

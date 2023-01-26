package net.ent.etrs.megamovies.model.dao.impl;

import net.ent.etrs.megamovies.model.dao.DaoRealisateur;
import net.ent.etrs.megamovies.model.entities.Realisateur;
import net.ent.etrs.megamovies.model.entities.references.Genre;

import java.io.Serializable;
import java.util.Set;

public class DaoRealisateurImpl extends AbstractDao<Realisateur, Serializable> implements DaoRealisateur {


    @Override
    public Set<Realisateur> findByGenre(Genre genre) {
        return null;
    }
}

package net.ent.etrs.ultramp3.model.dao.impl;

import net.ent.etrs.ultramp3.model.dao.DaoCompositeur;
import net.ent.etrs.ultramp3.model.entities.Compositeur;
import net.ent.etrs.ultramp3.model.entities.references.Genre;

import java.io.Serializable;
import java.util.Set;

public class DaoCompositeurImpl extends AbstractDao<Compositeur, Serializable> implements DaoCompositeur {


    @Override
    public Set<Compositeur> findByGenre(Genre genre) {
        return null;
    }
}

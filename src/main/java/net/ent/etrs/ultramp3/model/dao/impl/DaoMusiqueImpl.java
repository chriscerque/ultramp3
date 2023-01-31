package net.ent.etrs.ultramp3.model.dao.impl;

import net.ent.etrs.ultramp3.model.dao.DaoMusique;
import net.ent.etrs.ultramp3.model.dao.jpa.ReqDao;
import net.ent.etrs.ultramp3.model.entities.Musique;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Optional;

public class DaoMusiqueImpl extends AbstractDao<Musique, Serializable> implements DaoMusique {

    @Override
    public Optional<Musique> searchMusiqueByTitre(String titre) {

        try {
            TypedQuery<Musique> tp = super.getEm()
                    .createQuery(ReqDao.RECHERCHER_MUSIQUE_PAR_TITRE, Musique.class);
            tp.setParameter("titre", titre);
            return Optional.ofNullable(tp.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}

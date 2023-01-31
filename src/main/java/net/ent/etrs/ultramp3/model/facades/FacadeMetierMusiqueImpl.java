package net.ent.etrs.ultramp3.model.facades;

import net.ent.etrs.ultramp3.model.dao.DaoMusique;
import net.ent.etrs.ultramp3.model.dao.impl.DaoException;
import net.ent.etrs.ultramp3.model.dao.impl.DaoFactory;
import net.ent.etrs.ultramp3.model.entities.Compositeur;
import net.ent.etrs.ultramp3.model.entities.Musique;
import net.ent.etrs.ultramp3.model.exceptions.BusinessException;
import org.apache.commons.collections4.IterableUtils;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class FacadeMetierMusiqueImpl implements FacadeMetierMusique {

    private static DaoMusique daoMusique;

    static {
        daoMusique = DaoFactory.fabriquerDaoMusique();
    }

    @Override
    public Set<Musique> findAll() throws BusinessException {
        try {
            return IterableUtils.toList(daoMusique.findAll()).stream().collect(Collectors.toSet());
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @Override
    public Set<Musique> findByCompositeur(Compositeur compositeur) throws BusinessException {
        return null;
    }

    @Override
    public void delete(Musique musique) throws BusinessException {
        try {
            daoMusique.delete(musique.getId());
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @Override
    public Musique save(Musique musique) throws BusinessException {
        try {
            return daoMusique.save(musique).get();
        } catch (DaoException | NoSuchElementException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }


}

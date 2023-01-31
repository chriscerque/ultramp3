package net.ent.etrs.ultramp3.model.facades;

import net.ent.etrs.ultramp3.model.dao.DaoCompositeur;
import net.ent.etrs.ultramp3.model.dao.impl.DaoException;
import net.ent.etrs.ultramp3.model.dao.impl.DaoFactory;
import net.ent.etrs.ultramp3.model.entities.Compositeur;
import net.ent.etrs.ultramp3.model.entities.references.Genre;
import net.ent.etrs.ultramp3.model.exceptions.BusinessException;
import org.apache.commons.collections4.IterableUtils;

import java.util.Set;
import java.util.stream.Collectors;

public class FacadeMetierCompositeurImpl implements FacadeMetierCompositeur {

    private static DaoCompositeur daoCompositeur;

    static {
        daoCompositeur = DaoFactory.fabriquerDaoCompositeur();
    }

    @Override
    public Set<Compositeur> readAll() throws BusinessException {
        try {
            return IterableUtils.toList(daoCompositeur.findAll()).stream().collect(Collectors.toSet());
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @Override
    public Compositeur save(Compositeur compositeur) throws BusinessException {
        return null;
    }

    @Override
    public void delete(Compositeur compositeur) throws BusinessException {

    }

    @Override
    public Set<Compositeur> findByGenre(Genre genre) throws BusinessException {
        try {
            return daoCompositeur.findByGenre(genre);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }
}

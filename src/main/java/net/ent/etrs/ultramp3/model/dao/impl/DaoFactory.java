package net.ent.etrs.ultramp3.model.dao.impl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.ent.etrs.ultramp3.model.dao.DaoMusique;
import net.ent.etrs.ultramp3.model.dao.DaoCompositeur;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DaoFactory {

    public static DaoCompositeur fabriquerDaoCompositeur() {
        return new DaoCompositeurImpl();
    }

    public static DaoMusique fabriquerDaoMusique() {
        return new DaoMusiqueImpl();
    }

}

package net.ent.etrs.ultramp3.model.dao.impl;


import net.ent.etrs.ultramp3.model.dao.base.JpaBaseDao;
import net.ent.etrs.ultramp3.model.dao.commons.JpaUtils;

public class AbstractDao<T, K> extends JpaBaseDao<T, K> {

    public AbstractDao() {
        this.setEm(JpaUtils.getEm());
    }

}

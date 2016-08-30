package com.braunster.chatsdk.dao;

import com.braunster.chatsdk.dao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import com.braunster.chatsdk.dao.entities.BLinkedAccountEntity;

import java.util.Map;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS
// KEEP INCLUDES END
/**
 * Entity mapped to table BLINKED_ACCOUNT.
 */
public class BLinkedAccount extends BLinkedAccountEntity  {

    private Long id;
    private String Token;
    private Integer type;
    private Long BUserDaoId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BLinkedAccountDao myDao;

    private BUser BUser;
    private Long BUser__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public BLinkedAccount() {
    }

    public BLinkedAccount(Long id) {
        this.id = id;
    }

    public BLinkedAccount(Long id, String Token, Integer type, Long BUserDaoId) {
        this.id = id;
        this.Token = Token;
        this.type = type;
        this.BUserDaoId = BUserDaoId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBLinkedAccountDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getBUserDaoId() {
        return BUserDaoId;
    }

    public void setBUserDaoId(Long BUserDaoId) {
        this.BUserDaoId = BUserDaoId;
    }

    /** To-one relationship, resolved on first access. */
    public BUser getBUser() {
        Long __key = this.BUserDaoId;
        if (BUser__resolvedKey == null || !BUser__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BUserDao targetDao = daoSession.getBUserDao();
            BUser BUserNew = targetDao.load(__key);
            synchronized (this) {
                BUser = BUserNew;
            	BUser__resolvedKey = __key;
            }
        }
        return BUser;
    }

    public void setBUser(BUser BUser) {
        synchronized (this) {
            this.BUser = BUser;
            BUserDaoId = BUser == null ? null : BUser.getId();
            BUser__resolvedKey = BUserDaoId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here

    @Override
    public com.braunster.chatsdk.dao.entity_interface.Entity.Type getEntityType() {
        return null;
    }
    // KEEP METHODS END

}

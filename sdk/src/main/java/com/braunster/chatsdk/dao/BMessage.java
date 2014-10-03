package com.braunster.chatsdk.dao;

import android.util.Log;

import com.braunster.chatsdk.Utils.Debug;
import com.braunster.chatsdk.dao.entities.BMessageEntity;
import com.braunster.chatsdk.dao.entities.Entity;
import com.braunster.chatsdk.network.BDefines;
import com.braunster.chatsdk.network.BNetworkManager;
import com.braunster.chatsdk.network.firebase.BFirebaseDefines;
import com.braunster.chatsdk.network.firebase.BPath;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS
// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table BMESSAGE.
 */
public class BMessage extends BMessageEntity  {

    private Long id;
    private String entityID;
    private java.util.Date date;
    private Boolean dirty;
    private Boolean isRead;
    private String resources;
    private String resourcesPath;
    private String text;
    private Integer type;
    private Integer status;
    private Long OwnerThread;
    private Long Sender;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BMessageDao myDao;

    private BThread BThreadOwner;
    private Long BThreadOwner__resolvedKey;

    private BUser BUserSender;
    private Long BUserSender__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    public static final String TAG = BMessage.class.getSimpleName();
    public static final boolean DEBUG = Debug.BMessage;
    public String color = null;
    public String fontName = null;
    public String textColor = null;
    public int fontSize = -1;
    // KEEP FIELDS END

    public BMessage() {
    }

    public BMessage(Long id) {
        this.id = id;
    }

    public BMessage(Long id, String entityID, java.util.Date date, Boolean dirty, Boolean isRead, String resources, String resourcesPath, String text, Integer type, Integer status, Long OwnerThread, Long Sender) {
        this.id = id;
        this.entityID = entityID;
        this.date = date;
        this.dirty = dirty;
        this.isRead = isRead;
        this.resources = resources;
        this.resourcesPath = resourcesPath;
        this.text = text;
        this.type = type;
        this.status = status;
        this.OwnerThread = OwnerThread;
        this.Sender = Sender;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBMessageDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public Boolean getDirty() {
        return dirty;
    }

    public void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getOwnerThread() {
        return OwnerThread;
    }

    public void setOwnerThread(Long OwnerThread) {
        this.OwnerThread = OwnerThread;
    }

    public Long getSender() {
        return Sender;
    }

    public void setSender(Long Sender) {
        this.Sender = Sender;
    }

    /** To-one relationship, resolved on first access. */
    public BThread getBThreadOwner() {
        Long __key = this.OwnerThread;
        if (BThreadOwner__resolvedKey == null || !BThreadOwner__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BThreadDao targetDao = daoSession.getBThreadDao();
            BThread BThreadOwnerNew = targetDao.load(__key);
            synchronized (this) {
                BThreadOwner = BThreadOwnerNew;
            	BThreadOwner__resolvedKey = __key;
            }
        }
        return BThreadOwner;
    }

    public void setBThreadOwner(BThread BThreadOwner) {
        synchronized (this) {
            this.BThreadOwner = BThreadOwner;
            OwnerThread = BThreadOwner == null ? null : BThreadOwner.getId();
            BThreadOwner__resolvedKey = OwnerThread;
        }
    }

    /** To-one relationship, resolved on first access. */
    public BUser getBUserSender() {
        Long __key = this.Sender;
        if (BUserSender__resolvedKey == null || !BUserSender__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BUserDao targetDao = daoSession.getBUserDao();
            BUser BUserSenderNew = targetDao.load(__key);
            synchronized (this) {
                BUserSender = BUserSenderNew;
            	BUserSender__resolvedKey = __key;
            }
        }
        return BUserSender;
    }

    public void setBUserSender(BUser BUserSender) {
        synchronized (this) {
            this.BUserSender = BUserSender;
            Sender = BUserSender == null ? null : BUserSender.getId();
            BUserSender__resolvedKey = Sender;
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
    public void updateFrom(BMessage message) {
        if (message == null)
            return;

        if (message.lastUpdated().before(date))
            return;

        if (getEntityID() == null)
            entityID = message.getEntityID();

        if (message.getBUserSender() != null)
            setBUserSender(message.BUserSender);

        if (message.getText() != null)
            setText(message.getText());

        if (message.getResourcesPath() != null)
            setResourcesPath(message.getResourcesPath());

        // TODO create default value for message type.
        if (message.getType() != -1)
            setType(message.getType());

        if (message.color != null && !message.color.equals(""))
            color = message.color;

        if (message.textColor != null && !message.textColor.equals(""))
            textColor = message.textColor;

        if (message.fontName != null && !message.fontName.equals(""))
            fontName = message.fontName;

        if (message.fontSize != -1)
            fontSize = message.fontSize;
    }

    // TODO get PAth
    @Override
    public BPath getPath() {
        if (getBThreadOwner() == null)
        {
            if (DEBUG) Log.e(TAG, "Owner Thread is null");
            return null;
        }
        return getBThreadOwner().getPath().addPathComponent(BFirebaseDefines.Path.BMessagesPath, entityID);
    }

    @Override
    public Entity.Type getEntityType() {
        return Entity.Type.bEntityTypeMessages;
    }

    @Override
    public void updateFromMap(Map<String, Object> map) {
        // TODO maybe chagne all tags to the firebase paths..
        if (map.containsKey(BDefines.Keys.BPayload) && !map.get(EntityProperties.Text).equals(""))
            this.text = (String) map.get(EntityProperties.Text);

        if (map.containsKey(EntityProperties.Type) && !map.get(EntityProperties.Type).equals(""))
            this.type = (Integer) map.get(EntityProperties.Type);

        if (map.containsKey(EntityProperties.Date) && !map.get(EntityProperties.Date).equals(""))
            this.date = (Date) map.get(EntityProperties.Date);

        if (map.containsKey(EntityProperties.MessageColor) && !map.get(EntityProperties.MessageColor).equals(""))
            this.color = (String) map.get(EntityProperties.MessageColor);

        if (map.containsKey(EntityProperties.TextColor) && !map.get(EntityProperties.TextColor).equals(""))
            this.textColor = (String) map.get(EntityProperties.TextColor);

        if (map.containsKey(EntityProperties.FontName) && !map.get(EntityProperties.FontName).equals(""))
            this.fontName = (String) map.get(EntityProperties.FontName);

        if (map.containsKey(EntityProperties.FontSize) && !map.get(EntityProperties.FontSize).equals(""))
            this.fontSize = (Integer) map.get(EntityProperties.FontSize);
    }

    @Override
    public Map<String, Object> asMap() {
        Map<String , Object> map = new HashMap<String, Object>();

        map.put(BDefines.Keys.BPayload, text);
        map.put(BDefines.Keys.BType, type);
        map.put(BDefines.Keys.BDate, date.getTime());
        map.put(BDefines.Keys.BUserFirebaseId, getBUserSender().getEntityID());

        return map;
    }

    @Override
    public Object getPriority() {
        return date.getTime();
    }

    public boolean isSameDayAsMessage(BMessage message){
        // Current time.
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(date);
        // Message time.
        Calendar messageCalendar = Calendar.getInstance();
        messageCalendar.setTime(message.getDate());
        // Compare
        return isSameDay(nowCalendar, messageCalendar);
    }

    private boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null)
            return false;

        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA)
                && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

    public boolean isMine(){
        return getBUserSender().equals(BNetworkManager.sharedManager().getNetworkAdapter().currentUser());
    }

    @Override
    public String color() {
        return getBUserSender().getMessageColor();
    }

    @Override
    public String textColor() {
        return getBUserSender().getTextColor();
    }

    @Override
    public int fontSize() {
        return getBUserSender().getFontSize();
    }

    @Override
    public String fontName() {
        return getBUserSender().getFontName();
    }

    public Integer getStatusOrNull(){
        if (status == null)
            status = BMessageEntity.Status.NULL;

        return status;
    }

    /** Null safe version of getIsRead*/
    public boolean wasRead(){
        return isRead==null || isRead;
    }

    // KEEP METHODS END

}

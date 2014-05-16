/*
	Controller class for Messages.
 */

package stu;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.Serializable;

/**
 *
 * 
 */
public class MessageManager extends Manager implements Serializable {
	 /* 
	 */
	private static final long serialVersionUID = 6855340018663445457L;

  
    private String entityType = "message";
    private Integer messageCount = 0;

    public MessageManager(EntityFactory factory, LocalDB db) {
        this.factory = factory;
        this.db = db;
        // Gets the number of messages in the archive.
        messageCount = db.getMessageList().size();
    }

    public boolean add(String subject, String message, Date date, String groupName) {
        // Given message components, create a Message and set the values and
        // save to the database.
        MessageEntity messageEntity;
        GroupEntity group;
        Boolean success = false;

        // Getting the groups associated with the groupName string.
        group =  db.fetchGroup(groupName);
       
        //Create a message Entity object.
        messageEntity = factory.createMessageEntity();
        
        //Add the information into message.
        messageCount++;
        messageEntity.setId(messageCount.toString());
        messageEntity.setSubject(subject);
        messageEntity.setMessage(message);
        messageEntity.setDate(date);
        messageEntity.setGroup(group);

        success = db.add(messageEntity);
        
        // If failed to add the message to the database, need to decrement
        // the number of messages in the archive.
        if(!success) {
            messageCount--;
        }

        return success;

    }

    public boolean edit(Entity entity) {
        //Not supported.
        //return database.edit(entity, entityType);
        return false;
    }

    public boolean delete(Entity entity) {
        //Not supported.
       // return database.delete(entity, entityType);
        return false;
    }

    public ArrayList<GroupEntity> getGroups() {
        return (ArrayList<GroupEntity>) db.getGroupList().clone();
    }


}

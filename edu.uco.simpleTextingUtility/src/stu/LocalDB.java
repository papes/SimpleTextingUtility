/*
	This class is used by our strategy pattern to be our current "database" in the system.
 */
package stu;


import java.util.*;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
  
@ManagedBean
@SessionScoped
public class LocalDB extends Database implements Serializable {
    
    /**
	 * 
	 */
	private static final Logger log = Logger.getLogger(LocalDB.class.getName());
	private static final long serialVersionUID = 621284664544274468L;
	private ArrayList<GroupEntity> groupList; 
    private ArrayList<AdminEntity> adminList;
    private ArrayList<MessageEntity> messageList;
    
    

    // default constructor
    public LocalDB() {
        this.adminList = new ArrayList<AdminEntity>();
        this.groupList = new ArrayList<GroupEntity>();
        this.messageList = new ArrayList<MessageEntity>();
        
        
      
    }
    
        
    public boolean add(ContactEntity data, String groupName){
        // find the applicable group and add the contact
        GroupEntity tempGroup = null; //temporarily hold the applicable group
        
        //loop to find group
        for (int i = 0; i < groupList.size(); i++){
            if (groupList.get(i).getName().contentEquals(groupName)){
                // assign the matching group to tempGroup
                tempGroup = groupList.get(i);
                // break out of loop because match was found
                break;
            }
        }
        // gets contact list from selected group and adds the contact
        return tempGroup.getContacts().add(data);
    }
    
    public boolean add(GroupEntity data){
        return groupList.add(data);
    }
    
    public boolean add(AdminEntity data){
        return adminList.add(data);
    }
    
    public boolean add(MessageEntity data){
        return messageList.add(data);
    }
    
    
    // junk for now
    public boolean editContact(ContactEntity data){
       /* ContactEntity tempContact;
        // find the contact (first appearance of it in any group)
        for (int i = 0; i < groupList.size(); i++){
            for (int j = 0; j < groupList.getContacts().size(); j++){
                                                
            }
        }*/
        return true;
    }
    
    // fetch for use
    /* maybe take this one out because it doesn't apply well
    public boolean fetch(String entityType, String fetchKey){
        // decide what to fetch
        if (entityType.contentEquals("contact")){
            fetchContact(fetchKey);
            return true;
        }
        else if (entityType.contentEquals("group")){
            fetchGroup(fetchKey);
            return true;
        }
        else if (entityType.contentEquals("admin")){
            fetchAdmin(fetchKey);
            return true;
        }
        else if (entityType.contentEquals("message")){
            fetchMessage(fetchKey);
            return true;
        }
        // nothing matched if this is reached so return false
        return false;
    }
    */
    
    // fetch a contact implementation.
    public ContactEntity fetchContact(String phoneNum){
        //find contact in group        
        for (int i = 0; i < groupList.size(); i++){
            // for each group look through the contacts
            for (int j = 0; j < groupList.get(i).getContacts().size(); j++){
                if (groupList.get(i).getContacts().get(j).getPhoneNum().contentEquals(phoneNum)){
                    return groupList.get(i).getContacts().get(j);
                }
            }
        }
        // error occured, null pointer returned
        return null;
    }
    
    public GroupEntity fetchGroup(String name){
        // find the group in the groupList
        for (int i = 0; i < groupList.size(); i++){
            // find by name comparison
            if (groupList.get(i).getName().contentEquals(name)){
                return groupList.get(i);
            }
        }
        // error occured, nothing matched so send null pointer
        return null;
    }
    
    public AdminEntity fetchAdmin(String userName){
        // find the group in the groupList
        for (int i = 0; i < adminList.size(); i++){
            // find by username comparison
            if (adminList.get(i).getUserName().contentEquals(userName)){
                return adminList.get(i);
            }
        }
        // error occured, nothing matched so send null pointer
        return null;
    }
    
    public MessageEntity fetchMessage(String key){
        for (int i = 0; i < messageList.size(); i++){
            // find by username comparison
            if (messageList.get(i).getId().contentEquals(key)){
                return messageList.get(i);
            }
        }
        // error occured, nothing matched so send null pointer
        return null;
    }
    
    public boolean delete(String entityType, String fetchKey){
        // decide what to fetch
        if (entityType.contentEquals("contact")){
            deleteContact(fetchKey);
            return true;
        }
        else if (entityType.contentEquals("group")){
            deleteGroup(fetchKey);
            return true;
        }
        else if (entityType.contentEquals("admin")){
            deleteAdmin(fetchKey);
            return true;
        }
        else if (entityType.contentEquals("message")){
            deleteMessage(fetchKey);
            return true;
        }
        // nothing matched if this is reached so return false
        return false;
    }
    
    public boolean deleteContact(String phoneNum){
        // seek and destroy
        boolean outcome = false;
        for (int i = 0; i < groupList.size(); i++){
            // for each group look through the contacts
            for (int j = 0; j < groupList.get(i).getContacts().size(); j++){
                if (groupList.get(i).getContacts().get(j).getPhoneNum().contentEquals(phoneNum)){
                    // remove the contact from all the groups it is in
                    groupList.get(i).getContacts().remove(j);
                    outcome = true;
                }
            }
        }
        return outcome;
    }
    
    public boolean deleteGroup(String name){
        boolean outcome = false;
        for (int i = 0; i < groupList.size(); i++){
            if (groupList.get(i).getName().contentEquals(name)){
                groupList.remove(i);
                outcome = true;
            }
        }
        return outcome;
    }
    
    public boolean deleteAdmin(String userName){
        boolean outcome = false;
        for (int i = 0; i < adminList.size(); i++){
            if (adminList.get(i).getUserName().contentEquals(userName)){
                adminList.remove(i);
                outcome = true;
            }
        }
        return outcome;
    }
    
    public boolean deleteMessage(String key){
        boolean outcome = false;
        for (int i = 0; i < messageList.size(); i++){
            if (messageList.get(i).getId().contentEquals(key)){
                messageList.remove(i);
                outcome = true;
            }
        }
        return outcome;
    }
    
    @Override
    public boolean connect(){
        // stub code
        return true;
    }

    ////////////////////////////////////////////////////////just for test
    public ArrayList<GroupEntity> getGroupList() {
        return groupList;
    }

    public ArrayList<AdminEntity> getAdminList() {
        return adminList;
    }

    public ArrayList<MessageEntity> getMessageList() {
        return messageList;
    }
    ////////////////////////////////////////////////////////just for test
    
}



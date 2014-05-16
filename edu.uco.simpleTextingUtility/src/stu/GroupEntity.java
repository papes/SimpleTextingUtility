/*
 	Model class for Groups.
 */
package stu;

import java.util.ArrayList;
import java.io.Serializable;
        
public class GroupEntity implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1562709136343121359L;
	private ArrayList<ContactEntity> contacts;
    private String name;
    
    // stub code
    /*
    public GroupEntity(String name) {
    this.name = name;
    }
     */
    
    public GroupEntity() {
        this.contacts = new ArrayList<ContactEntity>();
        this.name = "";
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public ArrayList<ContactEntity> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<ContactEntity> contacts) {
        this.contacts = contacts;
    }
}

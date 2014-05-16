/*
	Controller class for Contacts. Implements add(), edit(), delete() functions.
*/
package stu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
  
@ManagedBean
@SessionScoped 

public class ContactManager extends Manager implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5318798057076570040L;

	public ContactManager(EntityFactory factory, LocalDB db) {
        this.factory = factory;
        this.db = db;
       
    }

    public boolean add(String name, String phoneNum, String groupName){
        boolean outcome = false;
        ContactEntity toAdd = this.factory.createContactEntity();
        toAdd.setName(name);
        toAdd.setPhoneNum(phoneNum);
        if (this.db.add(toAdd, groupName)){
            outcome = true;
        }
        return outcome;
    }

    public boolean edit(String newName, String newPhoneNum, String currentPhoneNum){
        boolean outcome = false;
        ContactEntity toEdit = this.db.fetchContact(currentPhoneNum);
        if (toEdit != null){
            toEdit.setName(newName);
            toEdit.setPhoneNum(newPhoneNum);
            outcome = true;
        }
        return outcome;
    }
    
    public boolean delete(String phoneNum){
        boolean outcome = false;
        if (this.db.deleteContact(phoneNum)){
            outcome = true;
        }
        return outcome;
    }

}

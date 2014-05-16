/*
	Model class for Contacts
 */
package stu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
  
@ManagedBean
@SessionScoped

public class ContactEntity extends Entity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6760994720130622659L;
	private String name;
    private String phoneNum;
    
    public ContactEntity(){
        this.entityType = "contact";
        this.name = "";
        this.phoneNum = "";
    }

    public ContactEntity(String name, String phoneNum) {
        this.entityType = "contact";
        this.name = name;
        this.phoneNum = phoneNum;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
}

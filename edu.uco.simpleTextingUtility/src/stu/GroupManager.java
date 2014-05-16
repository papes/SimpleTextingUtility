/*
 	Controller class for Groups. Implements add(), edit(), delete() functions.
 */
package stu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
  

import java.util.logging.Logger;
@ManagedBean
@SessionScoped 
public class GroupManager extends Manager implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7436697371065638968L;
	private static final Logger log = Logger.getLogger(GroupManager.class.getName());
	
	public GroupManager(){
	
	}

    public GroupManager(EntityFactory factory, LocalDB db) {
        this.factory = factory;
        this.db = db;
    }

    public boolean add(String name){
        boolean outcome = false;
        GroupEntity toAdd = this.factory.createGroupEntity();
        toAdd.setName(name);
        
        if (this.db.add(toAdd)){
            outcome = true;
        }
        return outcome;
    }

    public boolean edit(String newName, String currentName){
        boolean outcome = false;
        GroupEntity toEdit = this.db.fetchGroup(currentName);
        if (toEdit != null){
            toEdit.setName(newName);
            outcome = true;
        }
        return outcome;
    }
    
    public boolean delete(String name){
        boolean outcome = false;
        if (this.db.deleteGroup(name)){
            outcome = true;
        }
        return outcome;
    }

}

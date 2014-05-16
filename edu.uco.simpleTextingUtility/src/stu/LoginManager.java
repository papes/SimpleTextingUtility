/*
 	Controller class for admins. Implements login ability.
 */
package stu;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginManager extends Manager implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4807396538636998650L;
	private boolean authenticated = false;
	public LoginManager(EntityFactory factory, LocalDB db) {
        this.factory = factory;
        this.db = db;
    }
	
    
    public String login(String username, String password){
       authenticated = false;
       
       for(int i = 0; i < db.getAdminList().size(); i++){
    	   if(username.equals(db.getAdminList().get(i).getUserName())){
    		   if(password.equals(db.getAdminList().get(i).getPassword())){
    			   authenticated = true;
    		   }
    	   }
    	   
       }
       return "admin.xhtml?faces-redirect=true";
        
    }
    
    public boolean addAdmin(AdminEntity toAdd){
        boolean outcome = false;
        if(this.db.fetchAdmin(toAdd.getUserName()).getUserName()== null ){
            if (this.db.add(toAdd)){
             outcome = true;
            }
        }
        return outcome;
    }
    
    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
    
}

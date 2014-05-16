/*
	Model class for Admins. 
 */

/**
 *
 */
package stu;
import java.io.Serializable;
public class AdminEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3306193392104006517L;
	private String userName;
    private String password;
    
    
    public AdminEntity(){}
    
    public AdminEntity(String un, String pw){
        this.userName=un;
        this.password=pw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

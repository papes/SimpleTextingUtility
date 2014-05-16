/*
 *  Depreciated class for login authentication. No longer being used, 
 *  leaving in just in case we decide to revert back to this class
 */
package stu;    
import javax.faces.bean.ManagedBean;
//import javax.enterprise.context.SessionScoped;
//import javax.inject.Named;
import javax.faces.bean.SessionScoped;

 
import java.io.Serializable;
import org.mortbay.log.Log;


import com.techventus.server.voice.Voice;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@ManagedBean
@SessionScoped
public class AdminInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(VoiceBean.class.getName());
	
	private String name;
	 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	 
	

	public AdminInfo() {
		this.name = "test";
	}
	
	public void send() {
		System.out.println("send was called");
		log.info("send was fired");
        Date d1 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat();
        try {
            Voice v = new Voice("softengcout@gmail.com", "wearenumberone!");
            v.sendSMS("4054643415", "Hello this is a test, this message was sent from ~~~ the cloud ~~~ --brett ");
            String s1 = "the date is " + formatter.format(d1);
           log.info(s1);
        } catch (Exception ex) {
            Logger.getLogger(VoiceBean.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
    }

}
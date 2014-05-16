/*
  Adapter class to let Google Voice 3rd party API work with our system.
 */
package stu;

import com.techventus.server.voice.Voice;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

import java.io.Serializable;
public class MessageAdapter extends GVMessageImp implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4974793086007504110L;

   
	public MessageAdapter(MessageManager messageMngr, LocalDB db) {
        super(messageMngr, db);
    }   
	public MessageAdapter(){
		super();
	}
    
    public boolean send(GroupEntity group, String text, String subject){
        boolean outcome = true;
        
        // code that follows uses Google Voice unofficial API
        Date d1 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat();
        try {
            Voice v = new Voice("softengcout@gmail.com", "wearenumberone!");
            // loop to send the message to each contact
            for (int i = 0; i < group.getContacts().size(); i++)
            {
                v.sendSMS(group.getContacts().get(i).getPhoneNum(),text);
            }
            String s1 = "the date is " + formatter.format(d1);
            System.out.println(s1);
            
        } catch (IOException ex) {
            Logger.getLogger(VoiceBean.class.getName()).log(Level.SEVERE, null, ex);
            // outcome is set to false if this catch block runs
            outcome = false;
        } 
        
        if (outcome){            
            // if the message sent successfully we push it to the database
            // create a message entity then add all of the info to it
            /*MessageEntity message = this.messageMngr.factory.createMessageEntity();
            message.setSubject(subject);
            message.setMessage(text);
            message.setDate(d1);
            message.setGroup(group);
            */
            this.messageMngr.add(subject, text, d1, group.getName());
            
        }
        return outcome;
    }
    
}

/*
 * Model class for Message.

 * It will contain information such as the subject of the message,
 * the message, the date, and the groups that it was sent to.
 *
 * Getters and setters are available to access the information that is stored.
 */
package stu;

//import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.Serializable;

/**
 *
 * @author Susan
 */

public class MessageEntity extends Entity implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8291791294002660716L;
	private String Id = "";
    private String subject = "";
    private String message = "";
    //private String date = "";
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
    Date date = new Date();
    // private ArrayList<GroupEntity> groups;
    private GroupEntity group;

    public MessageEntity() {
        this.entityType = "message";
        Id = "";
        subject = "";
        message = "";
        date = new Date();
        dateFormatter = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        //groups = new ArrayList<GroupEntity>();
        group = new GroupEntity();

    }

    public MessageEntity(String Id, String subject, String message, Date date, GroupEntity group){
        this.entityType = "message";
        this.Id = Id;
        this.subject = subject;
        this.message = message;
        this.date = date;
        this.group = group;
        this.dateFormatter = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");

    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup (GroupEntity group) {
        this.group = group;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}

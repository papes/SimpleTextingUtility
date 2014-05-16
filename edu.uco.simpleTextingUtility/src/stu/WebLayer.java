/*
	This class is used to initialize all the necessary objects that we need in our web app and pull/push
	necessary information from the web pages.
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;

@ManagedBean(eager=true)
@ApplicationScoped
public class WebLayer implements Serializable {
	/**
	 * 
	 */
	String subject;
	String message;
	String name;
	String groupName;
	String phoneNum;
	String username;
	String password;
	int index;
	private static final long serialVersionUID = 3726242759626030934L;
	private static final Logger log = Logger.getLogger(WebLayer.class.getName());
	LocalDB myDB;
	GroupEntity myGroupEntity;
	LoginManager myAdminManager;
	GroupManager myGroupManager;
	ContactManager myContactManager;
	MessageManager myMessageManager; 
	ArrayList<GroupEntity> test;
	ArrayList<String> groupNames;
	MessageAdapter myMessageAdapter;
    // main method for some testing
	
	
     public WebLayer(){
    	 subject = "";
    	 message = "";
    	 groupName = "";
    	 username = "";
    	 password = "";
    	 name = "";
    	 
    	
        EntityFactory myEntityFactory = new EntityFactory();
        
        //create database
        myDB = new LocalDB();
        test = new ArrayList();
        myGroupManager = new GroupManager(myEntityFactory, myDB);
        myAdminManager = new LoginManager(myEntityFactory, myDB);
        myContactManager = new ContactManager(myEntityFactory, myDB);
        myMessageManager = new MessageManager(myEntityFactory, myDB); 
        myMessageAdapter = new MessageAdapter(myMessageManager, myDB);
        myGroupEntity = new GroupEntity();
     
        
        
        //create admin entity and push to database
        AdminEntity admin3 = myEntityFactory.createAdminEntity();
        admin3.setUserName("admin");
        admin3.setPassword("admin");
        myDB.add(admin3);
        
        //create group and add to database
        GroupEntity myGroup = myEntityFactory.createGroupEntity();
        myGroup.setName("The Avengers");
        log.info("The group name is: " + myGroup.getName());
        myDB.add(myGroup);
        test.add(myGroup);
        GroupEntity myGroup2 = myEntityFactory.createGroupEntity();
        
        //create contacts and add to database
        
        myDB.add(new ContactEntity("Micah", "4057406748"), "The Avengers");
        myDB.add(new ContactEntity("Susan", "4054643415"), "The Avengers");
        myDB.add(new ContactEntity("Brett", "5807168055"), "The Avengers");
        myDB.add(new ContactEntity("Chris", "4057088092"), "The Avengers");
        test = myDB.getGroupList();
        
     
        MessageManager myMessageManager = new MessageManager(myEntityFactory, myDB);
        GVMessageImp myGVImp = new GVMessageImp(myMessageManager,myDB);
        MessageAdapter myAdapter = new MessageAdapter(myMessageManager, myDB);
        String myMessage = "This is yet another test message";

     }


	public LocalDB getMyDB() {
		log.info("grabbing the database");
		log.info(myDB.getGroupList().get(0).getName());
		return myDB;
	}


	public void setMyDB(LocalDB myDB) {
		this.myDB = myDB;
		
	}


	public ContactManager getMyContactManager() {
		return myContactManager;
	}


	public void setMyContactManager(ContactManager myContactManager) {
		this.myContactManager = myContactManager;
	}


	public GroupManager getMyGroupManager() {
		return myGroupManager;
	}


	public void setMyGroupManager(GroupManager myGroupManager) {
		this.myGroupManager = myGroupManager;
	}


	public MessageManager getMyMessageManager() {
		return myMessageManager;
	}


	public void setMyMessageManager(MessageManager myMessageManager) {
		this.myMessageManager = myMessageManager;
	}


	public LoginManager getMyAdminManager() {
		return myAdminManager;
	}


	public void setMyAdminManager(LoginManager myAdminManager) {
		this.myAdminManager = myAdminManager;
	}


	public ArrayList<GroupEntity> getGroups(){
		return myDB.getGroupList();
	}


	

	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public ArrayList<GroupEntity> getTest() {
		return test;
	}


	public void setTest(ArrayList<GroupEntity> test) {
		this.test = test;
	}


	public MessageAdapter getMyMessageAdapter() {
		return myMessageAdapter;
	}


	public void setMyMessageAdapter(MessageAdapter myMessageAdapter) {
		this.myMessageAdapter = myMessageAdapter;
	}


	public GroupEntity getMyGroupEntity() {
		return myGroupEntity;
	}


	public void setMyGroupEntity(GroupEntity myGroupEntity) {
		this.myGroupEntity = myGroupEntity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}
	
	public String prepareToEdit(String _name){
		for(int i = 0; i < myDB.getGroupList().size(); i++){
			if(_name.equals(myDB.getGroupList().get(i).getName())){
			log.info(_name + " = " +  myDB.getGroupList().get(i).getName());
			index = i;
			groupName = _name;
			}
		}
		log.info("Index = " + index);
		log.info("Name = " + groupName);
		return "manageContacts.xhtml?faces-redirect=true";
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getGroupName() {
		for(int i = 0; i < myDB.getGroupList().size(); i++){
			if(groupName.equals(myDB.getGroupList().get(i).getName())){
			index = i;
			}
		}
		return groupName;
	}


	public void setGroupName(String groupName) {
		for(int i = 0; i < myDB.getGroupList().size(); i++){
			if(groupName.equals(myDB.getGroupList().get(i).getName())){
			index = i;
			}
		}
		this.groupName = groupName;
	}
	
	public void addContact(){
		log.info(name + " " + phoneNum + " "  + groupName);
		myContactManager.add(name, phoneNum, groupName);
		
		name = "";
		phoneNum = "";
		//groupName = "";
		
	}
	public void addGroup(){
		log.info(name + " " + phoneNum + " "  + groupName);
		myGroupManager.add(groupName);
	//	groupName = "";
		
	}
	
	public void delete(String number){
		myContactManager.delete(number);
		phoneNum = "";
	}
	
	
	public ArrayList<String> getGroupNames() {
		groupNames = new ArrayList();
		for(int i = 0; i < myDB.getGroupList().size(); i++){
			groupNames.add(myDB.getGroupList().get(i).getName());
		}
	
		return groupNames;
	}
	

	public void setGroupNames(ArrayList<String> groupNames) {
		this.groupNames = groupNames;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
       
}

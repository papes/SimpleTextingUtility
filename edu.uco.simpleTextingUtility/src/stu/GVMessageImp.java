/*
 	This class is currently being used by our adapter pattern to be the current voice sending API.
 */
package stu;



public class GVMessageImp extends MessageImplementer{

    public GVMessageImp(MessageManager messageMngr, LocalDB db) {
        // get references to the database and the contact manager
        this.db = db;
        this.messageMngr = messageMngr;
    }
    
    @Override
    public GroupEntity getGroup(String groupName){
        return this.db.fetchGroup(groupName);
    }
    public GVMessageImp(){
    	
    }
    @Override
    public MessageEntity createMessage(){
        return this.messageMngr.factory.createMessageEntity();
    }
    
}

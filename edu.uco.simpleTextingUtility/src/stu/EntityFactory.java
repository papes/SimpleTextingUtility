/*
 	Concrete factory class
 */
package stu;

public class EntityFactory extends AbstractFactory {
    @Override
    public boolean create(String toMake){
        if (toMake.contentEquals("group")){
            createGroupEntity();
            return true;
        }
        else if (toMake.contentEquals("contact")){
            createContactEntity();
            return true;
        }
        else if (toMake.contentEquals("admin")){
            createAdminEntity();
            return true;
        }
        else if (toMake.contentEquals("message")){
            createGroupEntity();
            return true;
        }
        // future objects go here
        
        // nothing matched so nothing was made
        else return false;
    }
    
    public GroupEntity createGroupEntity(){
        return new GroupEntity();
    }
    
    public ContactEntity createContactEntity(){
        return new ContactEntity();
    }
    
    public AdminEntity createAdminEntity(){
        return new AdminEntity();
    }
    
    public MessageEntity createMessageEntity(){
        return new MessageEntity();
    }
}

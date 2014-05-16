/*
 * Abstract class for our message sending API
 */
package stu;

public abstract class MessageImplementer {
    
    public LocalDB db;
    public MessageManager messageMngr;
    
    public abstract GroupEntity getGroup(String groupName);
    public abstract MessageEntity createMessage();
}

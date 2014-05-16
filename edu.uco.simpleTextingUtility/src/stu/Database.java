/*
 	Abstract database class
 */
package stu;

public abstract class Database {
    //public abstract boolean add(Entity data);
    //public abstract boolean edit(Entity data);
    public abstract boolean delete(String entityType, String fetchKey);
    public abstract boolean connect();
    //public abstract boolean fetch(String entityType, String fetchKey);
}

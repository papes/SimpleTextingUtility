/*
	Entity class is parent to all entities (groups,contacts, admins, messages)
 */

package stu;

public abstract class Entity {
    public String entityType;

    public String getEntityType() {
        return entityType;
    }
    
}

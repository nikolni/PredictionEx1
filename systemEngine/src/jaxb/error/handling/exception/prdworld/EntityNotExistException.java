package jaxb.error.handling.exception.prdworld;

public class EntityNotExistException extends  RuntimeException{
    private final String EXCEPTION_MESSAGE = "In the rule:%s, action:%s there is a reference to the entity:%s which not exist";
    private String entityName;
    private String ruleName;
    private String actionName;

    public EntityNotExistException(String entityName, String ruleName, String actionName) {
        this.entityName = entityName;
        this.ruleName = ruleName;
        this.actionName = actionName;
    }

    @Override
    public String getMessage() {
        return String.format(EXCEPTION_MESSAGE,ruleName,actionName,entityName);
    }
}

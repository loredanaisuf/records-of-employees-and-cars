package ro.siit.model;

public class TabelAutentificare {
    private String id;
    private String selector;
    private String validator;
    private String userId;

    public TabelAutentificare(String id, String selector, String validator, String userId) {
        this.id = id;
        this.selector = selector;
        this.validator = validator;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getSelector() {
        return selector;
    }

    public String getValidator() {
        return validator;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "TabelAutentificare{" +
                "id='" + id + '\'' +
                ", selector='" + selector + '\'' +
                ", validator='" + validator + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

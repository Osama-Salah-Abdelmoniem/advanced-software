package com.company;

public class NotificationsTemplate {
    private  String Template;
    private String Subject ;
    private String Type;
    private  String Language;
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String language;

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getType() {
        return Type;
    }

    public String getTemplate() {
        return Template;
    }

    public String getSubject() {
        return Subject;
    }

    public void setTemplate(String template) {
        Template = template;
    }

    public void setType(String type) {
        Type = type;
    }
}

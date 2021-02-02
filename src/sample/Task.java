package sample;

import javafx.beans.property.SimpleStringProperty;

public class Task {
    private final SimpleStringProperty title = new SimpleStringProperty("");
    private final SimpleStringProperty date = new SimpleStringProperty("");
    private final SimpleStringProperty description = new SimpleStringProperty("");
    private final SimpleStringProperty priority = new SimpleStringProperty("");
    private final SimpleStringProperty status = new SimpleStringProperty("");

    public String getTitle(){
        return title.get();
    }
    public void setTitle(String value){
        title.set(value);
    }
    public String getDate(){
        return date.get();
    }
    public void setDate(String value){
        date.set(value);
    }
    public String getDescription(){
        return description.get();
    }
    public void setDescription(String value){
        description.set(value);
    }
    public String getPriority(){
        return priority.get();
    }
    public void setPriority(String value){
        priority.set(value);
    }
    public String getStatus(){
        return status.get();
    }
    public void setStatus(String value){
        status.set(value);
    }
    public Task(String tl,String da,String des,String pr,String st){
        setTitle(tl);
        setDate(da);
        setDescription(des);
        setPriority(pr);
        setStatus(st);
    }
    public Task(){
        this("","","","","");
    }


}

package model;

public abstract class Person{

    private String id;
    private String numId;
    private String name;
    private String phoneNumber;

    public Person(String id, String numId, String name, String phoneNumber){
        this.id = id;
        this.numId = numId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getId(){
        return id;
    }

    public String getnumId(){
        return numId;
    }

    public String getname(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    
}

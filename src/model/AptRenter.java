package model;

public class AptRenter extends Person{

    public AptRenter(String id, String numId, String name, String phoneNumber, int typePhone) {
        super(id, numId, name, phoneNumber, typePhone);
    }

    public String getname(){
        String name = super.getname();
        return name;
    }
    
}

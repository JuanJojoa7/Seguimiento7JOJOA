package model;

public abstract class Person{

    private String id;
    private String numId;
    private String name;
    private String phoneNumber;
    private PhoneType typePhone;

    public Person(String id, String numId, String name, String phoneNumber,int typePhone){
        this.id = id;
        this.numId = numId;
        this.name = name;
        this.phoneNumber = phoneNumber;

        switch(typePhone){
            case 1:
                this.typePhone = PhoneType.HOME;
                break;
            case 2:
                this.typePhone = PhoneType.OFFICE;    
                break;
            case 3:
                this.typePhone = PhoneType.MOVIL;
                break;
            case 4:
                this.typePhone = PhoneType.FAMILY;
                break;      
            case 5:
                this.typePhone = PhoneType.OTHER;
                break;      
        }
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

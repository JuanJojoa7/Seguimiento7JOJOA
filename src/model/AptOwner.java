package model;

public class AptOwner extends Person{

    private String account;
    private String bank;

    public AptOwner(String id, String numId, String name, String phoneNumber, String account, String bank){
        super(id, numId, name, phoneNumber);
        
        this.account = account;
        this.bank = bank;
    }

    public String getAccount(){
        return account;
    }

    public String getBank(){
        return bank;
    }


}

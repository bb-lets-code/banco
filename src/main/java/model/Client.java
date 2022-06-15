package model;

public abstract class Client{
    private String fullName;

    public Client(String fullName) {
        this.fullName = fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getFullName(){
        return fullName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

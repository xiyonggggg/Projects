package newpackage;

public class Person {
    private String Name;
    private int Age;
    private int ICNo;
    private char Gender;
    private String PhoneNo;
    
    public Person(){
        
    }

    public Person(String Name, String PhoneNo) {
        this.Name = Name;
        this.PhoneNo = PhoneNo;
    }

    public Person(String Name, int Age, int ICNo, char Gender, String PhoneNo) {
        this.Name = Name;
        this.Age = Age;
        this.ICNo = ICNo;
        this.Gender = Gender;
        this.PhoneNo = PhoneNo;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getICNo() {
        return ICNo;
    }

    public void setICNo(int ICNo) {
        this.ICNo = ICNo;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }
}
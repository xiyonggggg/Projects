package newpackage;

public class Staff extends Person{
    private String StaffID;     
    private String password;
    private String position;

    public Staff() {
      
    } 

    public Staff(String StaffID, String password, String position, String Name, int Age, int ICNo, char Gender, String PhoneNo) {
        super(Name, Age, ICNo, Gender, PhoneNo);
        this.StaffID = StaffID;
        this.password = password;
        this.position = position;
    }
   
    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
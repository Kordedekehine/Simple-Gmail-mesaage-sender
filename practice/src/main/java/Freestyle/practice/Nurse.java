package Freestyle.practice;

public class Nurse implements Staff{
    
    private String schoolCert;
    
    public void assist(){
        System.out.println("Nurse is assisting");
    }


    public void setSchoolCert(String schoolCert ) {
        this.schoolCert = schoolCert;
    }

    public String getSchoolCert() {
        return schoolCert;
    }
}

import android.widget.Spinner;

public class information {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){

        this.gender = gender;
    }


    public Spinner getS2() {
        return s2;
    }

    public void setS2(Spinner s2) {
        this.s2 = s2;
    }
    String name, email;
    String age;
    String weight;
    String gender;
    public information(String name, String email, String age, String weight, String height, String gender, Spinner s2) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.s2 = s2;
    }

    String height;
    Spinner s2;

}

package local;

public class Worker {

    private String name;
    private String lastName;
    private int age;
    private String sex;
    private String petName;
    private String department;
    private String position;
    private int salary;
    private int bonus;
    private int workExp;

    //Getters
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getSex() {
        return sex;
    }
    public String getPetName() {
        return petName;
    }
    public String getDepartment() {
        return department;
    }
    public String getPosition() {
        return position;
    }
    public int getSalary() {
        return salary;
    }
    public int getBonus() {
        return bonus;
    }
    public int getWorkExp() {
        return workExp;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    public void setWorkExp(int workExp) {
        this.workExp = workExp;
    }

    //Constructor with parameters
    public Worker(String name, String lastName, int age, String sex, String petName, String department,
                  String position, int salary, int bonus, int workExp){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.petName = petName;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.bonus = bonus;
        this.workExp = workExp;
    }

    public void showWorker(){
        System.out.println(getName() + " " + getLastName() + " | " + getAge() + " | " + getSex()
        + " | " + getDepartment() + " " + getPosition() + " | " + getSalary() + " + " + getBonus()
        + " | " + getWorkExp() + " | " + getPetName());
    }
}

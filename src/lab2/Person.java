abstract class Person {
    protected String name;
    protected int age = 1;
    protected String sex;
    protected String birthPlace;
    static int count = 0;

    public Person(String name, int age, String sex, String birthPlace) {
        this.setName(name);
        this.setAge(age);
        this.setSex(sex);
        this.setBirthPlace(birthPlace);
        ++count;
    }

    public String getInf() {
        return "Information about person " + this.name + ": age - " + this.age + ", sex - " + this.sex + ", born in " + this.birthPlace;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 110) {
            this.age = age;
        }

    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        if (sex.equals("male") || sex.equals("female")) {
            this.sex = sex;
        }

    }

    public String getBirthPlace() {
        return this.birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
}

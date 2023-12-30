class Teacher extends Person {
    public String work;
    public String department;
    public int audience = 1;
    public String subject;

    public Teacher(String name, int age, String sex, String birthPlace, String work, String department, int audience, String subject) {
        super(name, age, sex, birthPlace);
        this.setWork(work);
        this.setDepartment(department);
        this.setAudience(audience);
        this.setSubject(subject);
    }

    public String getInf() {
        return "Information about teacher " + this.name + ": department - " + this.department + ", teach at audience - " + this.audience;
    }

    public void greetings(String hello) {
        System.out.println(hello + ", my name is " + this.name + ". I'm " + this.age + " years old, I was born in " + this.birthPlace);
    }

    public void greetings(int ages) {
        System.out.println("Hello, my name is " + this.name + ". I teach at the " + this.work + ". My subject is called " + this.subject + ". I've been teaching it for " + ages + " years");
    }

    public String getWork() {
        return this.work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAudience() {
        return this.audience;
    }

    public void setAudience(int audience) {
        this.audience = audience;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

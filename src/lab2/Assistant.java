class Assistant extends Person {
    public String work;
    public String curator;
    public int lengthOfWork = 1;
    public String subject;

    public Assistant(String name, int age, String sex, String birthPlace, String work, String curator, int lengthOfWork, String subject) {
        super(name, age, sex, birthPlace);
        this.setWork(work);
        this.setCurator(curator);
        this.setLengthOfWork(lengthOfWork);
        this.setSubject(subject);
    }

    public String getInf() {
        return "Information about assistant " + this.name + ": working in - " + this.work + ", length of work - " + this.lengthOfWork;
    }

    public void greetings(String hello) {
        System.out.println(hello + ", my name is " + this.name + ". I'm " + this.age + " years old, I was born in " + this.birthPlace);
    }

    public void greetings(int days) {
        System.out.println("Hello, my name is " + this.name + ". I working at this university for " + this.lengthOfWork + " years. My curator is " + this.curator + ". I'm working " + days + " days a week");
    }

    public String getWork() {
        return this.work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getCurator() {
        return this.curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public int getLengthOfWork() {
        return this.lengthOfWork;
    }

    public void setLengthOfWork(int lengthOfWork) {
        this.lengthOfWork = lengthOfWork;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

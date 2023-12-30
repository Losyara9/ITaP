class Student extends Person {
    public String university;
    public String direction;
    public int course = 1;
    public String groupNumber;

    public Student(String name, int age, String sex, String birthPlace, String university, String direction, int course, String groupNumber) {
        super(name, age, sex, birthPlace);
        this.setUniversity(university);
        this.setDirection(direction);
        this.setCourse(course);
        this.setGroupNumber(groupNumber);
    }

    public String getInf() {
        return "Information about student " + this.name + ": university - " + this.university + ", course - " + this.course;
    }

    public void greetings(String hello) {
        System.out.println(hello + ", my name is " + this.name + ". I'm " + this.age + " years old, I was born in " + this.birthPlace);
    }

    public void greetings(int days) {
        System.out.println("Hello, my name is " + this.name + ". I'm student of " + this.university + ". I'm " + this.course + "th year student, my group number is " + this.groupNumber + ". I study " + days + " days a week");
    }

    public String getUniversity() {
        return this.university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getCourse() {
        return this.course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroupNumber() {
        return this.groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
}

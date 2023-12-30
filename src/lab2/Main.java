public class Main {
    public static void main(String[] args) {
        Student kate = new Student("Kate", 19, "female", "Moscow", "MTUCI", "09.03.01", 2, "BVT2206");
        System.out.println(kate.getCourse());
        kate.greetings("YO");
        kate.greetings(6);
        Teacher mike = new Teacher("Mike", 27, "male", "Moscow", "MTUCI", "IT", 208, "Computer Science");
        mike.greetings("Hello");
        mike.greetings(6);
        Assistant john = new Assistant("John", 22, "male", "Saint-Peterburg", "MTUCI", "Mike", 3, "Computer Science");
        john.greetings(5);
        john.greetings("Hello");
        GroupStudent sofia = new GroupStudent("Sofia", 19, "female", "Moscow", "MTUCI", "09.03.01", 2, "BVT2206", 3, 21,"BVT222204");
        sofia.greetings("Hi");
        sofia.greetings(5);
        System.out.println(mike.getInf());
        System.out.println(kate.getInf());
        System.out.println(john.getInf());
        System.out.println(sofia.getInf());
        System.out.println(Person.count);
        }
    }

abstract class Person{

    protected String name;
    protected int age = 1;
    protected String sex;
    protected String birthPlace;
    static int count = 0;

    public Person(String name, int age, String sex, String birthPlace){
        setName(name);
        setAge(age);
        setSex(sex);
        setBirthPlace(birthPlace);
        count++;
    }

    public String getInf(){
        return "Information about person " + name + ": age - " + age + ", sex - " + sex + ", born in " + birthPlace;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        if(age > 0 && age < 110)
            this.age = age;
    }
    public String getSex(){
        return this.sex;
    }
    public void setSex(String sex){
        if(sex.equals("male") || sex.equals("female"))
            this.sex = sex;
    }
    public String getBirthPlace(){
        return this.birthPlace;
    }
    public void setBirthPlace(String birthPlace){
            this.birthPlace = birthPlace;
    }

}

class Student extends Person{
    public Student(String name, int age, String sex, String birthPlace, String university, String direction, int course, String groupNumber) {
        super(name, age, sex, birthPlace);
        setUniversity(university);
        setDirection(direction);
        setCourse(course);
        setGroupNumber(groupNumber);
    }

    @Override
    public String getInf(){
        return "Information about student " + name + ": university - " + university + ", course - " + course;
    }

    public void greetings(String hello){
        System.out.println(hello + ", my name is " + name + ". I'm " + age + " years old, I was born in " + birthPlace );
    }
    public void greetings(int days){
        System.out.println("Hello, my name is " + name + ". I'm student of " + university + ". I'm " + course + "th year student, my group number is " + groupNumber + ". I study " + days + " days a week");
    }
    public String university;
    public String direction;
    public int course = 1;
    public String groupNumber;

    public String getUniversity(){
        return this.university;
    }
    public void setUniversity (String university){
        this.university = university;
    }

    public String getDirection(){
        return this.direction;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }

    public int getCourse(){
        return this.course;
    }
    public void setCourse(int course){
        this.course = course;
    }

    public String getGroupNumber(){
        return this.groupNumber;
    }
    public void setGroupNumber(String groupNumber){
        this.groupNumber = groupNumber;
    }
}

class Teacher extends Person {
    public Teacher(String name, int age, String sex, String birthPlace, String work, String department, int audience, String subject) {
        super(name, age, sex, birthPlace);
        setWork(work);
        setDepartment(department);
        setAudience(audience);
        setSubject(subject);
    }

    @Override
    public String getInf(){
        return "Information about teacher " + name + ": department - " + department + ", teach at audience - " + audience;
    }

    public void greetings(String hello){
        System.out.println(hello + ", my name is " + name + ". I'm " + age + " years old, I was born in " + birthPlace );
    }
    public void greetings(int ages){
        System.out.println("Hello, my name is " + name + ". I teach at the " + work + ". My subject is called " + subject + ". I've been teaching it for " + ages + " years");
    }

    public String work;
    public String department;
    public int audience = 1;
    public String subject;

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

class Assistant extends Person {
    public Assistant(String name, int age, String sex, String birthPlace, String work, String curator, int lengthOfWork, String subject) {
        super(name, age, sex, birthPlace);
        setWork(work);
        setCurator(curator);
        setLengthOfWork(lengthOfWork);
        setSubject(subject);
    }

    @Override
    public String getInf() {
        return "Information about assistant " + name + ": working in - " + work + ", length of work - " + lengthOfWork;
    }

    public void greetings(String hello) {
        System.out.println(hello + ", my name is " + name + ". I'm " + age + " years old, I was born in " + birthPlace);
    }

    public void greetings(int days) {
        System.out.println("Hello, my name is " + name + ". I working at this university for " + lengthOfWork + " years. My curator is " + curator + ". I'm working " + days + " days a week");
    }

    public String work;
    public String curator;
    public int lengthOfWork = 1;
    public String subject;

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

class GroupStudent extends Student {
    public GroupStudent(String name, int age, String sex, String birthPlace, String university, String direction, int course, String groupNumber, int number, int rating, String bookNumber) {
        super(name, age, sex, birthPlace, university, direction, course, groupNumber);
        setNumber(number);
        setRating(rating);
        setBookNumber(bookNumber);
    }

    @Override
    public String getInf() {
        return "Information about student of group " + groupNumber + ": name - " + name + ", list number - " + number;
    }

    public int number;
    public int rating = 1;
    public String bookNumber;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBookNumber() {
        return this.bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }
}

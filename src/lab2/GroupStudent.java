class GroupStudent extends Student {
    public int number;
    public int rating = 1;
    public String bookNumber;

    public GroupStudent(String name, int age, String sex, String birthPlace, String university, String direction, int course, String groupNumber, int number, int rating, String bookNumber) {
        super(name, age, sex, birthPlace, university, direction, course, groupNumber);
        this.setNumber(number);
        this.setRating(rating);
        this.setBookNumber(bookNumber);
    }

    public String getInf() {
        return "Information about student of group " + this.groupNumber + ": name - " + this.name + ", list number - " + this.number;
    }

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

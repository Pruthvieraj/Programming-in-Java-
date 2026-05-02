public class Student {
    int StudentId;
    String Name, Branch;
    int Marks1, Marks2, Marks3, Marks4, Marks5;
    double Percentage;

    public Student(int StudentId, String Name, String Branch, int Marks1, int Marks2, int Marks3, int Marks4, int Marks5) {
        this.StudentId = StudentId;
        this.Name = Name;
        this.Branch = Branch;
        this.Marks1 = Marks1;
        this.Marks2 = Marks2;
        this.Marks3 = Marks3;
        this.Marks4 = Marks4;
        this.Marks5 = Marks5;
    }

    public void calculatePercentage() {
        this.Percentage = (this.Marks1 + this.Marks2 + this.Marks3 + this.Marks4 + this.Marks5) / 5.0;
    }

    public String toCSV() {
        return this.StudentId + "," + this.Name + "," + this.Branch + "," + this.Marks1 + "," + this.Marks2 + "," + this.Marks3 + "," + this.Marks4 + "," + this.Marks5 + "," + this.Percentage;
    }
}
package work.day2;

/**
 * @ClassName Student
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/11 15:52
 * @Version 1.0
 */
public class Student {
    private String name;
    private int age;
    private String education;
    private int englishScores;
    private int mathScores;
    private int chineseScores;
    private String gender;

    public Student(String name, int age, String education, int englishScores, int mathScores, int chineseScores, String gender) {
        this.name = name;
        this.age = age;
        this.education = education;
        this.englishScores = englishScores;
        this.mathScores = mathScores;
        this.chineseScores = chineseScores;
        this.gender = gender;
    }

    public String getSource(Student student) {
        int maxSource;
        int lowSource;
        int sumScores = student.mathScores + student.chineseScores + student.englishScores;
        int average = (student.mathScores + student.chineseScores + student.englishScores) / 3;
        if (student.mathScores > student.englishScores && student.mathScores > student.chineseScores) {
            maxSource = mathScores;
        }
        maxSource = Math.max(student.englishScores, student.chineseScores);

        if (student.mathScores < student.englishScores && student.mathScores < student.chineseScores) {
            lowSource = mathScores;
        }
        lowSource = Math.min(student.englishScores, student.chineseScores);

        return "hs:" + maxSource + "ls:" + lowSource + "ss:" + sumScores + "aa:" + average;
    }

//    public int sumScores(Student student) {
//        return (student.mathScores + student.chineseScores + student.englishScores);
//    }
//
//    public double average(Student student) {
//        return (student.mathScores + student.chineseScores + student.englishScores) / 3;
//    }
//
//    public int heightSource(Student student) {
//        if (student.mathScores > student.englishScores && student.mathScores > student.chineseScores) {
//            return mathScores;
//        }
//        return Math.max(student.englishScores, student.chineseScores);
//    }
//
//    public int lowSource(Student student) {
//
//        if (student.mathScores < student.englishScores && student.mathScores < student.chineseScores) {
//            return mathScores;
//        }
//        return Math.min(student.englishScores, student.chineseScores);
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", englishScores=" + englishScores +
                ", mathScores=" + mathScores +
                ", chineseScores=" + chineseScores +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getEnglishScores() {
        return englishScores;
    }

    public void setEnglishScores(int englishScores) {
        this.englishScores = englishScores;
    }

    public int getMathScores() {
        return mathScores;
    }

    public void setMathScores(int mathScores) {
        this.mathScores = mathScores;
    }

    public int getChineseScores() {
        return chineseScores;
    }

    public void setChineseScores(int chineseScores) {
        this.chineseScores = chineseScores;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

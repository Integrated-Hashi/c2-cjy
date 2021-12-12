public interface StudentDao {
    public void insertStudent(Student stu);
    public Student selectStuBySno(String sno);
    public void updateCollegeByStu(Student stu);
    public void deleteStuBySno(String sno);
    public void selectAllStudent();
}

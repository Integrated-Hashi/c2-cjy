import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMysql implements StudentDao{

    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    @Override
    public void insertStudent(Student stu) {
        try {
            conn = DBUtil.get_Conn();
            pstm = conn.prepareStatement("insert into student(sno, name, age, college) VALUES (?,?,?,?)");
            pstm.setString(1, stu.getSno());
            pstm.setString(2, stu.getName());
            pstm.setInt(3, stu.getAge());
            pstm.setString(4, stu.getCollege());
            int i = pstm.executeUpdate();
//            if(i>0){
//                System.out.println("插入成功");
//            } else{
//                System.out.println("插入失败");
//            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DBUtil.get_CloseConn(rs, pstm, conn);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Student selectStuBySno(String sno) {
        try {
            Student stu = new Student();
            conn = DBUtil.get_Conn();
            pstm = conn.prepareStatement("select * from student where sno=?");
            pstm.setString(1, sno);
            rs = pstm.executeQuery();
            while (rs.next()){
                stu.setSno(rs.getString("sno"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("age"));
                stu.setCollege(rs.getString("college"));
                return stu;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DBUtil.get_CloseConn(rs, pstm, conn);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void updateCollegeByStu(Student stu) {
        try {
            conn = DBUtil.get_Conn();
            pstm = conn.prepareStatement("update student set college=? where sno=?");
            pstm.setString(1, stu.getCollege());
            pstm.setString(2, stu.getSno());
            int i = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.get_CloseConn(rs, pstm, conn);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteStuBySno(String sno) {
        try {
            conn = DBUtil.get_Conn();
            pstm = conn.prepareStatement("delete from student where sno=?");
            pstm.setString(1, sno);
            int i = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.get_CloseConn(rs, pstm, conn);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void selectAllStudent() {
        try {
            conn = DBUtil.get_Conn();
            pstm = conn.prepareStatement("select * from student");
            rs = pstm.executeQuery();
            while(rs.next()) {
                System.out.println(
                        rs.getString(1) + "\t\t" +
                                rs.getString(2) + "\t\t" +
                                rs.getInt(3) + "\t\t" +
                                rs.getString(4)
                );
            }
//            System.out.println("查询成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.get_CloseConn(rs, pstm, conn);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


package com.app.service;

import com.app.entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {
    private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String uid = "****";
    private final String pwd = "****";
    private final String driver = "oracle.jdbc.driver.OracleDriver";

    public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {

        int start = 1 + (page-1) * 10;     //1, 11, 21, 31,
        int end = 10*page;                 //10 , 20, 30 ...

        String sql = "SELECT * FROM NOTICE_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,uid, pwd); //연결 객체
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, "%"+query+"%");
        st.setInt(2, start);
        st.setInt(3, end);
        ResultSet rs = st.executeQuery();

        List<Notice> list = new ArrayList<Notice>();

        while(rs.next()) {
            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String writerid = rs.getString("WRITER_ID");
            Date regDate = rs.getDate("REGDATE");
            String content = rs.getString("CONTENT");
            int hit = rs.getInt("hit");
            String files = rs.getString("FILES");

            Notice notice = new Notice(
                    id,
                    title,
                    writerid,
                    regDate,
                    content,
                    hit,
                    files
            );
            list.add(notice);
        }

        rs.close();
        st.close();
        con.close();
        return list;
    }

    //Scalar 값을 얻는다 -> 단일 값을 얻는다.
    public int getCount(String field, String query) throws ClassNotFoundException, SQLException {
        int count = 0;
        //String sql = "SELECT COUNT(ID) COUNT FROM NOTICE";
        String sql = "SELECT COUNT(ID) COUNT FROM NOTICE WHERE "+field+" LIKE '%"+query+"%'";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,uid, pwd); //연결 객체
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if(rs.next())
            count = rs.getInt("COUNT");

        rs.close();
        st.close();
        con.close();
        return count;
    }

    public int insert(Notice notice) throws ClassNotFoundException, SQLException {
        String title = notice.getTitle();
        String writerId = notice.getWriterid();
        String content = notice.getContent();
        String files = notice.getFiles();

        String sql = "INSERT INTO NOTICE (  " +
                "   title," +
                "   writer_id," +
                "   content," +
                "   files" +
                ") VALUES (?,?,?,?)";


        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,uid, pwd); //연결 객체

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,title);
        st.setString(2,writerId);
        st.setString(3,content);
        st.setString(4,files);

        int result = st.executeUpdate();


        st.close();
        con.close();
        return result;
    }

    public int update(Notice notice) throws ClassNotFoundException, SQLException {
        String title = notice.getTitle();
        String content = notice.getContent();
        String files = notice.getFiles();
        int id = notice.getId();

        String sql = "UPDATE NOTICE " +
                "SET" +
                "   TITLE = ?," +
                "   CONTENT=?," +
                "   FILES=?" +
                "WHERE ID = ?";


        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,uid, pwd);

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,title);
        st.setString(2,content);
        st.setString(3,files);
        st.setInt(4,id);

        int result = st.executeUpdate();


        st.close();
        con.close();
        return result;
    }

    public int delete(int id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE NOTICE WHERE ID = ?";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,uid, pwd); //연결 객체
        PreparedStatement st = con.prepareStatement(sql);

        st.setInt(1,id);

        int result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }

}

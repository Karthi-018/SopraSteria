package edu.steria.training;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollegeBO
{
    Connection conn = null;

    public List<College> findCollege(List<String> nameList)
    {
        List<College> nList = new ArrayList<>();
        try
        {
            conn = DBConnection.getConnection();
            for(String n: nameList)
            {
                PreparedStatement ps = conn.prepareStatement("select * from college where name = ?");
                ps.setString(1,n);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    College c = new College(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5), rs.getString(6),rs.getDate(7));
                    nList.add(c);
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return nList;
    }

    public List<College> findCollege(Date startingDate)
    {
        java.sql.Date d = (java.sql.Date) startingDate;
        List<College> nList = new ArrayList<>();
        try
        {
            conn = DBConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("select * from college where startingDate = ?");
            ps1.setDate(1,d);
            ResultSet rs = ps1.executeQuery();
            while(rs.next())
            {
                College c = new College(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5), rs.getString(6),rs.getDate(7) );
                nList.add(c);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return nList;
    }

    public List<College> findCollege(String location)
    {
        List<College> nList = new ArrayList<>();
        try
        {
            conn = DBConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("select * from college where location = ?");
            ps1.setString(1,location);
            ResultSet rs = ps1.executeQuery();
            while(rs.next())
            {
                College c = new College(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5), rs.getString(6),rs.getDate(7) );
                nList.add(c);
            }

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return nList;
    }

    public List<College> getCollegeList()
    {
        List<College> clist = new ArrayList<>();
        conn = DBConnection.getConnection();
        try
        {
            PreparedStatement ps1 = conn.prepareStatement("select * from college");
            ResultSet rs = ps1.executeQuery();
            while(rs.next())
            {
                College c = new College(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5), rs.getString(6),rs.getDate(7) );
                clist.add(c);
            }

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return clist;
    }
}

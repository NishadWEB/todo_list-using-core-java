package com.ihub.repository;

import com.ihub.util.DBConnection;
import com.ihub.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    public void addTask(Task task){

        String sql="INSERT INTO tasks(title,description,status,priority) VALUES(?,?,?,?)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,task.getTitle());
            ps.setString(2,task.getDescription());
            ps.setString(3,task.getStatus());
            ps.setInt(4,task.getPriority());

            ps.executeUpdate();

        }catch(Exception e){
//            e.printStackTrace();
            throw new RuntimeException("task insertion failed ! ", e);
        }
    }


    public List<Task> getAllTasks(){

        List<Task> tasks = new ArrayList<>();

        String sql="SELECT * FROM tasks ORDER BY priority";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){

            while(rs.next()){

                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getInt("priority")
                );

                tasks.add(task);
            }

        }catch(Exception e){
//            e.printStackTrace();
            throw new RuntimeException("fetching all tasks from the db is FAILED ! ,", e);
        }

        return tasks;
    }


    public boolean updateStatus(int id,String status){

        String sql="UPDATE tasks SET status=? WHERE id=?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,status);
            ps.setInt(2,id);

            int rows = ps.executeUpdate();

            return rows > 0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }


    public int countByStatus(String status){

        String sql="SELECT COUNT(*) FROM tasks WHERE status=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setString(1,status);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                return rs.getInt(1);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return 0;
    }
}
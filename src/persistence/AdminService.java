package persistence;
import model.Job;
import model.TableSpace;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminService implements IAdminService{

    private final String jdbcURL;
    private final String uname;
    private final String pwd;
    public AdminService()
    {
        jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
        uname = "CAMILOADMIN";
        pwd = "basesdedatos2021";
    }
    @Override
    public List<Job> getJobs(User u) {
        List<Job> jobList = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);
            String jobsQuery = "select * from all_scheduler_jobs where OWNER = '" +  u.getUsername().toUpperCase() + "'";
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(jobsQuery);

            while (resultSet.next())
            {
                Job jobcito = new Job();
                jobcito.setOwner(resultSet.getString("OWNER"));
                jobcito.setName(resultSet.getString("JOB_NAME"));
                jobcito.setJobClass(resultSet.getString("JOB_CLASS"));
                jobcito.setComments(resultSet.getString("COMMENTS"));
                jobcito.setEnabled(resultSet.getString("ENABLED"));
                jobcito.setCredentialName(resultSet.getString("CREDENTIAL_NAME"));
                jobcito.setDestination(resultSet.getString("DESTINATION"));
                jobcito.setProgramName(resultSet.getString("PROGRAM_NAME"));
                jobcito.setJobType(resultSet.getString("JOB_TYPE"));
                jobcito.setJobAction(resultSet.getString("JOB_ACTION"));
                jobcito.setNumberOfArguments(resultSet.getString("NUMBER_OF_ARGUMENTS"));
                jobcito.setScheduleOwner(resultSet.getString("SCHEDULE_OWNER"));
                jobcito.setShceduleName(resultSet.getString("SCHEDULE_NAME"));
                jobcito.setScheduleType(resultSet.getString("SCHEDULE_TYPE"));
                jobcito.setStartDate(resultSet.getString("START_DATE"));
                jobcito.setRepeatInterval(resultSet.getString("REPEAT_INTERVAL"));
                jobcito.setEndDate(resultSet.getString("END_DATE"));

                jobList.add( jobcito );
            }


        }catch (Exception e)
        {

        }

        return jobList;
    }

    @Override
    public boolean changeJobState(Job j, User u) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(jdbcURL, uname, pwd);

            String jobsQuery;
            if( j.isEnabled() )
            {
                jobsQuery = "BEGIN DBMS_SCHEDULER.ENABLE ( name =>  '" + u.getUsername() + "." + j.getName() + "' );END;";
            }
            else {
                jobsQuery = "BEGIN DBMS_SCHEDULER.DISABLE ( name =>  '" + u.getUsername() + "." + j.getName() + "' );END;";
            }
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(jobsQuery);
        }catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public List<TableSpace> getTableSpaces() {
        List<TableSpace> ts = new ArrayList<>();

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(jdbcURL, uname, pwd);

            String query = "SELECT tablespace_name, round(sum(BYTES/1024/1024),0) ,  (round  (  max(MAXBYTES/1024/1024) , 0 ) - round(sum(BYTES/1024/1024),0)  )   FROM dba_data_files WHERE tablespace_name NOT LIKE 'TEMP%' GROUP BY dba_data_files.tablespace_name";


            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                TableSpace tablespace = new TableSpace();

                tablespace.setName(resultSet.getString(1));
                tablespace.setOccupiedSpace(resultSet.getString(2) + " MB");
                tablespace.setAvailibleSpace(resultSet.getString(3) + "MB");

                ts.add(tablespace);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ts;
    }
}

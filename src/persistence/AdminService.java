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
        jdbcURL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        uname = "AdminDB";
        pwd = "amendoza1";
    }
    @Override
    public List<Job> getJobs(User u) {
        List<Job> jobList = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(jdbcURL,uname,pwd);
            String jobsQuery = "select * from all_scheduler_jobs where OWNER = '" + u.getUsername().toUpperCase() + "'";
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
                //jobsQuery = "BEGIN    DBMS_SCHEDULER.ENABLE                        (                           name    =>  '" + u.getUsername().toUpperCase() + "." + j.getName().toUpperCase() + "'                        );END;";
                jobsQuery = "DBMS_SCHEDULER.ENABLE (  name    =>  '?.?'  )";

            }
            else {
                //jobsQuery = "BEGIN    DBMS_SCHEDULER.DISABLE                        (                           name    =>  '" + u.getUsername().toUpperCase() + "." + j.getName().toUpperCase() + "'                        );END;";
                jobsQuery = "BEGIN DBMS_SCHEDULER.DISABLE (  name    =>  '?.?'  );END;";
            }
            CallableStatement callableStatement = dbConnection.prepareCall(jobsQuery);
            callableStatement.setString(1,u.getUsername().toUpperCase());
            callableStatement.setString(2,j.getName().toUpperCase());
            callableStatement.executeUpdate();
            float res = callableStatement.getFloat(1);

            //ResultSet resultSet = statement.executeQuery(jobsQuery);

        }catch (Exception e)
        {
            System.out.println( e.getMessage());
            return false;
        }
        return  true;

    }

    @Override
    public List<TableSpace> getTableSpaces() {
        return null;
    }
}

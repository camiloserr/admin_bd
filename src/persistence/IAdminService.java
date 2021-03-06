package persistence;

import model.Job;
import model.TableSpace;
import model.User;

import java.util.List;

public interface IAdminService {

    List<Job> getJobs(User u);
    boolean changeJobState(Job j, User u);
    List<TableSpace> getTableSpaces();

}

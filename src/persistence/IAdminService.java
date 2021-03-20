package persistence;

import model.Job;
import model.TableSpace;

import java.util.List;

public interface IAdminService {

    List<Job> getJobs();
    boolean changeJobState(Job j);
    List<TableSpace> getTableSpaces();

}

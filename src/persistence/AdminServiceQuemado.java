package persistence;

import model.Job;
import model.TableSpace;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceQuemado implements IAdminService{
    @Override
    public List<Job> getJobs(User u) {

        String comentarios= "comentario 1";
        List<Job> jobs = new ArrayList<>();

        jobs.add(new Job("Job 1", true, "Juan",
                "este es el tipo de job", comentarios, "Credential name",
                "Destination", "program name", "job type", "Job action",
                "2", "schedule owner", "schedule name",
                "schedule type", "20/10/2020", "todos los dias", "12/12/2021"));

        jobs.add(new Job("Job 2", false, "SYSTEM",
                "este es el tipo de job", comentarios, "Credential name",
                "Destination", "program name", "job type", "Job action",
                "2", "schedule owner", "schedule name",
                "schedule type", "20/10/2020", "todos los dias", "12/12/2021"));

        return jobs;
    }

    @Override
    public boolean changeJobState(Job j, User u) {
        return false;
    }

    @Override
    public List<TableSpace> getTableSpaces() {

        List<TableSpace> tableSpaces = new ArrayList<>();

        tableSpaces.add(new TableSpace("Tablespace 1", "178 MB", "33 MB"));
        tableSpaces.add(new TableSpace("Tablespace 2", "66 MB", "9 GB"));
        tableSpaces.add(new TableSpace("Tablespace inventado", "0 MB", "12 MB"));
        tableSpaces.add(new TableSpace("otro Tablespace", "890 MB", "1 GB"));

        return  tableSpaces;
    }
}

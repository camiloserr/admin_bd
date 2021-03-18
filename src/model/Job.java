package model;

import java.util.List;

public class Job {
    private String name;
    private boolean enabled;
    private String owner;
    private String jobClass;
    private List<String> comments;
    private String credentialName;
    private String destination;
    private String programName;
    private String jobType;
    private String jobAction;
    private int numberOfArguments;
    private String scheduleOwner;
    private String shceduleName;
    private String scheduleType;
    private String startDate;
    private String repeatInterval;
    private String endDate;

    public Job(String name, boolean enabled, String owner, String jobClass, List<String> comments,
               String credentialName, String destination, String programName, String jobType, String jobAction,
               int numberOfArguments, String scheduleOwner, String shceduleName, String scheduleType, String startDate,
               String repeatInterval, String endDate) {
        this.name = name;
        this.enabled = enabled;
        this.owner = owner;
        this.jobClass = jobClass;
        this.comments = comments;
        this.credentialName = credentialName;
        this.destination = destination;
        this.programName = programName;
        this.jobType = jobType;
        this.jobAction = jobAction;
        this.numberOfArguments = numberOfArguments;
        this.scheduleOwner = scheduleOwner;
        this.shceduleName = shceduleName;
        this.scheduleType = scheduleType;
        this.startDate = startDate;
        this.repeatInterval = repeatInterval;
        this.endDate = endDate;
    }
}

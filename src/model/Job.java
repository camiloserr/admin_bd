package model;

import java.util.List;

public class Job {
    private String name;
    private boolean enabled;
    private String owner;
    private String jobClass;
    private String comments;
    private String credentialName;
    private String destination;
    private String programName;
    private String jobType;
    private String jobAction;
    private String numberOfArguments;
    private String scheduleOwner;
    private String shceduleName;
    private String scheduleType;
    private String startDate;
    private String repeatInterval;
    private String endDate;

    public Job(String name, boolean enabled, String owner, String jobClass, String comments, String credentialName,
               String destination, String programName, String jobType, String jobAction, String numberOfArguments,
               String scheduleOwner, String shceduleName, String scheduleType, String startDate, String repeatInterval,
               String endDate) {
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

    public Job() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        if(enabled.equals(""))
        {
            this.enabled = true;
        }
        else
        {
            this.enabled = false;
        }
    }
    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCredentialName() {
        return credentialName;
    }

    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobAction() {
        return jobAction;
    }

    public void setJobAction(String jobAction) {
        this.jobAction = jobAction;
    }

    public String getNumberOfArguments() {
        return numberOfArguments;
    }

    public void setNumberOfArguments(String numberOfArguments) {
        this.numberOfArguments = numberOfArguments;
    }

    public String getScheduleOwner() {
        return scheduleOwner;
    }

    public void setScheduleOwner(String scheduleOwner) {
        this.scheduleOwner = scheduleOwner;
    }

    public String getShceduleName() {
        return shceduleName;
    }

    public void setShceduleName(String shceduleName) {
        this.shceduleName = shceduleName;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(String repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

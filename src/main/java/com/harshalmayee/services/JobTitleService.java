package com.harshalmayee.services;

import com.harshalmayee.models.JobTitle;
import com.harshalmayee.models.Location;

import java.util.List;

public interface JobTitleService {

    public List<JobTitle> getAllJobTitles();

    public void addNewJobTitle(JobTitle jobTitle);

    public JobTitle getJobTitleById(int id);

    void delete(int id);
}

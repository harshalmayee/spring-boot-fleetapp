package com.harshalmayee.services.impl;

import com.harshalmayee.models.JobTitle;
import com.harshalmayee.models.Location;
import com.harshalmayee.repositories.JobTitleRepository;
import com.harshalmayee.repositories.LocationRepository;
import com.harshalmayee.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class JobTitleServiceImpl implements JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    @Override
    public List<JobTitle> getAllJobTitles() {
        return jobTitleRepository.findAll();
    }

    @Override
    public void addNewJobTitle(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    @Override
    public JobTitle getJobTitleById(int id) {
        Optional<JobTitle> optional = jobTitleRepository.findById(id);
        JobTitle jobTitle=null;
        if(optional.isPresent()){
            jobTitle=optional.get();
        }else{
            throw new RuntimeException("JobTitle Not found for "+id);
        }
        return jobTitle;
    }

    @Override
    public void delete(int id) {
        jobTitleRepository.deleteById(id);
    }
}

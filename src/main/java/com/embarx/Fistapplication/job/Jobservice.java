package com.embarx.Fistapplication.job;

import java.util.List;

public interface Jobservice {
    List<Job> findAll();
    void create(Job job);
    Job findJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJob(Long id, Job updatedJob);
}

package com.embarx.Fistapplication.job;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Jobserviceimpl implements Jobservice {

    private final List<Job> jobs = new ArrayList<>();
    private Long jobId = 1L;

    public Jobserviceimpl() {
        jobs.add(new Job(jobId++, "Software Engineer", "Develop Java applications", "50000", "100000", "Bangalore"));
        jobs.add(new Job(jobId++, "Data Analyst", "Analyze business data", "40000", "80000", "Hyderabad"));
        jobs.add(new Job(jobId++, "DevOps Engineer", "Manage CI/CD pipelines", "60000", "110000", "Mumbai"));
    }

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void create(Job job) {
        job.setId(jobId++);
        jobs.add(job);
    }

    @Override
    public Job findJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        return jobs.removeIf(job -> job.getId().equals(id));
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinsalary(updatedJob.getMinsalary());  // ✅ Using minsalary
                job.setMaxsalary(updatedJob.getMaxsalary());  // ✅ Using maxsalary
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }
}

package me.ele.pmo.service;

import me.ele.pmo.model.Project;
import me.ele.pmo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kimi on 6/22/16.
 */
@Service(value = "projectService1Impl")
public class ProjectService1Impl implements ProjectService1 {
    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project) {
        return this.projectRepository.save(project);
    }

    public Iterable<Project> findAll() {
        return this.projectRepository.findAll();
    }

}

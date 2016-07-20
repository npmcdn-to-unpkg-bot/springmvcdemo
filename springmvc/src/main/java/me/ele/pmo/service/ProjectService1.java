package me.ele.pmo.service;

import me.ele.pmo.model.Project;

/**
 * Created by kimi on 6/22/16.
 */
public interface ProjectService1 {
    Project save(Project project);

    Iterable<Project> findAll();
}

package me.ele.pmo.repository;
/**
 * Created by kimi on 6/22/16.
 */

import me.ele.pmo.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}

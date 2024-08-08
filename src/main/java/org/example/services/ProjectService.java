package org.example.services;

import org.example.daos.ProjectDao;
import org.example.models.Project;

import java.sql.SQLException;
import java.util.List;

public class ProjectService {
     ProjectDao projectDao;

     public ProjectService(ProjectDao projectDao) {
         this.projectDao = projectDao;
    }

    public List<Project> getAllProjects() throws SQLException {
        return projectDao.getAllProjects();
    }
}

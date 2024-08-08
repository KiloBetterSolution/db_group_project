package org.example.services;


import org.example.daos.ProjectDao;

import org.example.models.Project;

import java.sql.SQLException;


public class ProjectService {
    ProjectDao projectDao;

    public ProjectService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public Project getHighestValueProject() throws SQLException {
        return projectDao.getClientHighestValueProject();
    }
}


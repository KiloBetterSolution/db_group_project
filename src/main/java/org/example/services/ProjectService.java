package org.example.services;

import org.example.daos.ProjectDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.Project;
import org.example.models.ProjectRequest;
import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    ProjectDao projectDao;

    public ProjectService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public Project getHighestValueProject() throws SQLException {
        return projectDao.getClientHighestValueProject();
    }

    public List<Project> getAllProjects() throws SQLException {
        return projectDao.getAllProjects();
    }

    public int createProject(ProjectRequest projectRequest)
            throws FailedToCreateException, SQLException, InvalidException {

        int id = projectDao.createProject(projectRequest);

        if (id == -1) {
            throw new FailedToCreateException(Entity.PROJECT);
        }
        return id;
    }
}

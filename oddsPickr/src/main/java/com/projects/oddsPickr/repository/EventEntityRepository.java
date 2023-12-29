package com.projects.oddsPickr.repository;

import com.projects.oddsPickr.model.SavedTeamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface EventEntityRepository extends MongoRepository<SavedTeamEntity, Integer> {

    }

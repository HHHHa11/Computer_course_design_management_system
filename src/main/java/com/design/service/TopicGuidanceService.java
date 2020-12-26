package com.design.service;

import com.design.entity.TopicGuidances;

import java.util.List;

public interface TopicGuidanceService {
    void inserttopicGuidances(TopicGuidances topicGuidances);

    List<TopicGuidances> getguidanceInsertList(Integer topicId);

    Long getguidanceCountByTypeId(Integer topicId);
}

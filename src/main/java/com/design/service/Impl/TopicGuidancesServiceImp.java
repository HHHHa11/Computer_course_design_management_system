package com.design.service.Impl;

import com.design.dao.TopicGuidancesMapper;
import com.design.entity.TopicGuidances;
import com.design.entity.TopicGuidancesExample;
import com.design.service.TopicGuidanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicGuidancesServiceImp implements TopicGuidanceService {
    @Autowired
    private TopicGuidancesMapper topicGuidancesMapper;

    @Override
    public void inserttopicGuidances(TopicGuidances topicGuidances) {
        topicGuidancesMapper.insert(topicGuidances);
    }

    @Override
    public List<TopicGuidances> getguidanceInsertList(Integer topicId) {

        return topicGuidancesMapper.guidanceInsertList(topicId);
    }

    @Override
    public Long getguidanceCountByTypeId(Integer topicId) {
        TopicGuidancesExample example =new TopicGuidancesExample();
        TopicGuidancesExample.Criteria criteria = example.createCriteria();
        criteria.andTopicIdEqualTo(topicId);
        return topicGuidancesMapper.countByExample(example);
    }
}

package com.qin.apps.cms.service.impl;

import com.qin.apps.cms.bean.Logs;
import com.qin.apps.cms.dao.LogsMapper;
import com.qin.apps.cms.service.ILogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogsServiceImpl implements ILogsService {
    @Autowired
    private LogsMapper logsMapper;

    @Override
    public void saveLog(Logs logs) {
        logsMapper.insert(logs);
    }

    @Override
    public void updateLog(Logs logs) {
        logsMapper.updateByPrimaryKey(logs);
    }
}

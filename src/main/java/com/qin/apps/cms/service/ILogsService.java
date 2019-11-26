package com.qin.apps.cms.service;

import com.qin.apps.cms.bean.Logs;

public interface ILogsService {
    void saveLog(Logs logs);
    void updateLog(Logs logs);
}

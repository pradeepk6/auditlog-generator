package com.talend;

import org.talend.logging.audit.AuditEvent;
import org.talend.logging.audit.LogLevel;
import org.talend.logging.audit.StandardEventAuditLogger;

public interface CustomEventAuditLogger extends StandardEventAuditLogger {

    @AuditEvent(category = "security.alarm", message = "Send email to client security officer", level = LogLevel.WARNING)
    void raiseAlarm(Object... args);
}
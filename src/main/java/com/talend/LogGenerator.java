package com.talend;

import org.talend.logging.audit.*;

import java.util.HashMap;
import java.util.Map;

public class LogGenerator {

    public static void main(String... args) {
        LogGenerator lg = new LogGenerator();
        lg.generateLogs();
    }

    public void generateLogs() {

        AuditLogger auditLogger = AuditLoggerFactory.getAuditLogger();
        auditLogger.warning("security", "user1 Account has been locked");

        StandardEventAuditLogger sl = AuditLoggerFactory.getEventAuditLogger(StandardEventAuditLogger.class);
        Context ctx2 = ContextBuilder.create("user", "user2").build();
        sl.loginSuccess(ctx2);

        Context ctx3 = ContextBuilder.create("user", "user3").build();
        Exception e = new Exception("testing exception");
        sl.loginFail(ctx3, e);

        CustomEventAuditLogger cl = AuditLoggerFactory.getEventAuditLogger(CustomEventAuditLogger.class);
        Map<String, String> map4 = new HashMap<>();
        map4.put("user", "user4");
        map4.put("alarm.algo", "user deleting too much data");
        Context ctx4 = ContextBuilder
                .create(map4)
                .build();
        cl.raiseAlarm(ctx4);

        Map<String, String> map5 = new HashMap<>();
        map5.put("user", "user5");
        map5.put("feature", "export as bar charts");
        Context ctx5 = ContextBuilder
                .create(map5)
                .build();
        Exception e5 = new Exception("Flow has crashed");
        sl.systemException(e5, ctx5);
    }
}


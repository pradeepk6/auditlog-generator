package com.talend;

import org.talend.logging.audit.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LogGenerator {
    private static int count = 0;
    private static int num_logs_tobe_generated = 0; //default
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMYYY_HHmmss");

    public static void main(String... args) {
        //final AuditConfigurationMap config = AuditConfiguration.loadFromClasspath("/configurer.audit.properties");
        //Log4j1Configurer.configure(config);
        Long timeInMilles = null;
        try {
            num_logs_tobe_generated = getNumLogs();
            timeInMilles = new Date().getTime();
            while (true) {

                LogGenerator.generateLogs();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Generated " + count + " logs in " + (new Date().getTime() - timeInMilles) / 1000 + " seconds.");
    }

    //
    public static void generateLogs() throws Exception {
        //
        AuditLogger auditLogger = AuditLoggerFactory.getAuditLogger();
        auditLogger.warning("security", generateRandomUserName() + " testing auditLogger.warning");
        auditLogger.activityError(generateRandomUserName() + " testing auditLogger.activityError");
        auditLogger.info("security", generateRandomUserName() + " testing auditLogger.info");
        auditLogger.securityWarning(generateRandomUserName() + " testing auditLogger.securityWarning");

        //
        StandardEventAuditLogger sl = AuditLoggerFactory.getEventAuditLogger(StandardEventAuditLogger.class);
        Context ctx2 = ContextBuilder.create("user", generateRandomUserName()).build();
        sl.loginSuccess(ctx2);

        //
        Context ctx3 = ContextBuilder.create("user", generateRandomUserName()).build();
        Exception e = new Exception("testing exception");
        sl.loginFail(ctx3, e);

        //
        CustomEventAuditLogger cl = AuditLoggerFactory.getEventAuditLogger(CustomEventAuditLogger.class);
        Map<String, String> map4 = new HashMap<>();
        map4.put("user", generateRandomUserName());
        map4.put("alarm.algo", "user deleting too much data");
        Context ctx4 = ContextBuilder
                .create(map4)
                .build();
        cl.raiseAlarm(ctx4);

        //
        Map<String, String> map5 = new HashMap<>();
        map5.put("user", generateRandomUserName());
        map5.put("feature", "export as bar charts");
        Context ctx5 = ContextBuilder
                .create(map5)
                .build();
        Exception e5 = new Exception("Flow has crashed");
        sl.systemException(e5, ctx5);

        sl.invalidInput(ContextBuilder.create("user", generateRandomUserName()).build());
        sl.invalidSession(ContextBuilder.create("user", generateRandomUserName()).build());
        sl.passwordChanged(ContextBuilder.create("user", generateRandomUserName()).build());
        sl.passwordReset(ContextBuilder.create("user", generateRandomUserName()).build());
        sl.roleAssigned(ContextBuilder.create("user", generateRandomUserName()).build());
        sl.roleCreated(ContextBuilder.create("user", generateRandomUserName()).build());
        sl.roleDeleted(ContextBuilder.create("user", generateRandomUserName()).build());
        sl.roleRevoked(ContextBuilder.create("user", generateRandomUserName()).build());
        sl.userCreated(ContextBuilder.create("user", generateRandomUserName()).build());
        sl.userDeleted(ContextBuilder.create("user", generateRandomUserName()).build());
        sl.userLockout(ContextBuilder.create("user", generateRandomUserName()).build());
        sl.userModified(ContextBuilder.create("user", generateRandomUserName()).build());

    }

    private static String generateRandomUserName() throws Exception {
        if (count == num_logs_tobe_generated) throw new Exception("Num of logs to be generated reached");
        String time = LocalDateTime.now().format(format);
        return "user_" + time + "_" + ++count;
    }

    private static int getNumLogs() {
        System.out.println("Enter num of logs to be generated.");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        try {
            num_logs_tobe_generated = Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("Problem with your input and so generating default num of logs.");
        }
        return num_logs_tobe_generated;
    }

}


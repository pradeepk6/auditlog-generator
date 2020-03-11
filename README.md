#### A java application that generates sample audit logs using daikon-audit library

##### sample output of 5 log events when file appender is chosen

```json
{
  "severity": "WARN",
  "eventid": "4daa3984-2afb-4786-b332-88175ded4c90",
  "instance": "TestInstance1",
  "logMessage": "user1 Account has been locked",
  "logSource": {
    "logger.name": "audit.security",
    "host.name": "it-Precision-5520",
    "host.address": "127.0.1.1"
  },
  "threadName": "main",
  "agentTimestamp": "2020-02-25T23:28:28.885Z",
  "logTimestamp": "2020-02-25T23:28:28.834Z",
  "application": "auditlog-generator",
  "audit": "true",
  "service": "ServiceA",
  "@version": 1,
  "category": "security"
}
{
  "severity": "INFO",
  "eventid": "5c946ab5-e024-441b-8a69-e9278af0abc9",
  "instance": "TestInstance1",
  "logMessage": "User has logged in successfully.",
  "logSource": {
    "logger.name": "audit.security",
    "host.name": "it-Precision-5520",
    "host.address": "127.0.1.1"
  },
  "customInfo": {
    "user": "user2"
  },
  "threadName": "main",
  "agentTimestamp": "2020-02-25T23:28:28.909Z",
  "logTimestamp": "2020-02-25T23:28:28.909Z",
  "application": "auditlog-generator",
  "audit": "true",
  "service": "ServiceA",
  "@version": 1,
  "category": "security"
}
{
  "severity": "INFO",
  "eventid": "d24ff2e9-d98f-4c26-90b2-2a8c5a3f73cf",
  "instance": "TestInstance1",
  "logMessage": "User login attempt failed.",
  "logSource": {
    "logger.name": "audit.security",
    "host.name": "it-Precision-5520",
    "host.address": "127.0.1.1"
  },
  "exceptionClass": "java.lang.Exception",
  "customInfo": {
    "user": "user3"
  },
  "threadName": "main",
  "agentTimestamp": "2020-02-25T23:28:28.910Z",
  "logTimestamp": "2020-02-25T23:28:28.910Z",
  "application": "auditlog-generator",
  "audit": "true",
  "service": "ServiceA",
  "@version": 1,
  "stackTrace": "java.lang.Exception: testing exception\n\tat com.talend.LogGenerator.generateLogs(LogGenerator.java:20)\n\tat com.talend.LogGenerator.main(LogGenerator.java:44)\n",
  "category": "security",
  "exceptionMessage": "testing exception"
}
{
  "severity": "WARN",
  "eventid": "d5850056-11ce-466e-a640-a33a512786b8",
  "instance": "TestInstance1",
  "logMessage": "Send email to client security officer",
  "logSource": {
    "logger.name": "audit.security.alarm",
    "host.name": "it-Precision-5520",
    "host.address": "127.0.1.1"
  },
  "customInfo": {
    "alarm.algo": "user deleting too much data",
    "user": "user4"
  },
  "threadName": "main",
  "agentTimestamp": "2020-02-25T23:28:28.914Z",
  "logTimestamp": "2020-02-25T23:28:28.914Z",
  "application": "auditlog-generator",
  "audit": "true",
  "service": "ServiceA",
  "@version": 1,
  "category": "security.alarm"
}
{
  "severity": "INFO",
  "eventid": "6f1519cb-123f-4422-944d-16cedde315cb",
  "instance": "TestInstance1",
  "logMessage": "Unexpected exception.",
  "logSource": {
    "logger.name": "audit.failure",
    "host.name": "it-Precision-5520",
    "host.address": "127.0.1.1"
  },
  "exceptionClass": "java.lang.Exception",
  "customInfo": {
    "feature": "export as bar charts",
    "user": "user5"
  },
  "threadName": "main",
  "agentTimestamp": "2020-02-25T23:28:28.914Z",
  "logTimestamp": "2020-02-25T23:28:28.914Z",
  "application": "auditlog-generator",
  "audit": "true",
  "service": "ServiceA",
  "@version": 1,
  "stackTrace": "java.lang.Exception: Flow has crashed\n\tat com.talend.LogGenerator.generateLogs(LogGenerator.java:38)\n\tat com.talend.LogGenerator.main(LogGenerator.java:44)\n",
  "category": "failure",
  "exceptionMessage": "Flow has crashed"
}
```

##### sample output of the same 5 log events as above when console appender is chosen
2020-02-26 00:19:06 WARN  audit.security - user1 Account has been locked  
2020-02-26 00:19:06 INFO  audit.security - User has logged in successfully.  
2020-02-26 00:19:06 INFO  audit.security - User login attempt failed.  
java.lang.Exception: testing exception  
    + at com.talend.LogGenerator.generateLogs(LogGenerator.java:20)  
    + at com.talend.LogGenerator.main(LogGenerator.java:44)  
2020-02-26 00:19:06 WARN  audit.security.alarm - Send email to client security officer  
2020-02-26 00:19:06 INFO  audit.failure - Unexpected exception.  
java.lang.Exception: Flow has crashed  
    + at com.talend.LogGenerator.generateLogs(LogGenerator.java:38)  
    + at com.talend.LogGenerator.main(LogGenerator.java:44)  

package com.adoph.test.proxy.task;

import java.util.Properties;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/6/26
 */
public class TaskManager {
    public static void doExec() {
        getTask().exec();
    }

    private static AbstractTask getTask() {
        AbstractTask task = null;
        try {
            Properties props = new Properties();
            props.load(TaskManager.class.getClassLoader().getResourceAsStream("task-config.properties"));
            String taskFlag = props.getProperty("taskFlag");
            task = (AbstractTask) Class.forName(taskFlag).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return task;
    }
}

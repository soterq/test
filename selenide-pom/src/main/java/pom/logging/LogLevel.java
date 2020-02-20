package pom.logging;

import org.apache.log4j.Level;

public class LogLevel extends Level {
    /**
     * Numerical value for PASS.
     */
    private static final int PASS_INT = 30000;
    /**
     * Numerical value for FAIL.
     */
    private static final int FAIL_INT = 40000;
    /**
     * Numerical value for SKIP.
     */
    private static final int SKIP_INT = 50000;
    /**
     * Numerical value for STEP.
     */
    private static final int STEP_INT = 60000;
    /**
     * Numerical value for TEST.
     */
    private static final int TEST_INT = 70000;


    public static final LogLevel PASS = new LogLevel(PASS_INT, "PASS", 6);
    public static final LogLevel FAIL = new LogLevel(FAIL_INT, "FAIL", 6);
    public static final LogLevel SKIP = new LogLevel(SKIP_INT, "SKIP", 6);
    public static final LogLevel STEP = new LogLevel(STEP_INT, "STEP", 6);
    public static final LogLevel TEST = new LogLevel(TEST_INT, "TEST", 6);

    /**
     * Create new instance.
     *
     * @param level            numeric value for level.
     * @param levelStr         symbolic name for level.
     * @param syslogEquivalent Equivalent syslog severity.
     */
    private LogLevel(int level, String levelStr, int syslogEquivalent) {
        super(level, levelStr, syslogEquivalent);
    }
}

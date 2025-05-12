package utils;

public class TestConfig {
    private static final String EXECUTION_MODE = System.getProperty("execution.mode", "sequential");
    
    public static boolean isParallelExecution() {
        return "parallel".equalsIgnoreCase(EXECUTION_MODE);
    }
    
    public static int getThreadCount() {
        return Integer.parseInt(System.getProperty("thread.count", "2"));
    }
} 
package com.example.demo.model;

public class Home {
    private long target_object;
    private long succeed_object;
    private long failed_object;
    private long total_object;
    private long AGV_battery_wrong;

    private double factory1_AGV_battery_AVG;
    private double factory2_AGV_battery_AVG;
    private double factory3_AGV_battery_AVG;

    public Home() {}

    public Home(long target_object, long succeed_object, long failed_object, long total_object,
                long AGV_battery_wrong, double factory1_AVG, double factory2_AVG, double factory3_AVG) {
        this.target_object = target_object;
        this.succeed_object = succeed_object;
        this.failed_object = failed_object;
        this.total_object = total_object;
        this.AGV_battery_wrong = AGV_battery_wrong;
        this.factory1_AGV_battery_AVG = factory1_AVG;
        this.factory2_AGV_battery_AVG = factory2_AVG;
        this.factory3_AGV_battery_AVG = factory3_AVG;
    }

    public long getTarget_object() { return target_object; }
    public void setTarget_object(long target_object) { this.target_object = target_object; }

    public long getSucceed_object() { return succeed_object; }
    public void setSucceed_object(long succeed_object) { this.succeed_object = succeed_object; }

    public long getFailed_object() { return failed_object; }
    public void setFailed_object(long failed_object) { this.failed_object = failed_object; }

    public long getTotal_object() { return total_object; }
    public void setTotal_object(long total_object) { this.total_object = total_object; }

    public long getAGV_battery_wrong() { return AGV_battery_wrong; }
    public void setAGV_battery_wrong(long AGV_battery_wrong) { this.AGV_battery_wrong = AGV_battery_wrong; }

    public double getFactory1_AGV_battery_AVG() { return factory1_AGV_battery_AVG; }
    public void setFactory1_AGV_battery_AVG(double factory1_AGV_battery_AVG) { this.factory1_AGV_battery_AVG = factory1_AGV_battery_AVG; }

    public double getFactory2_AGV_battery_AVG() { return factory2_AGV_battery_AVG; }
    public void setFactory2_AGV_battery_AVG(double factory2_AGV_battery_AVG) { this.factory2_AGV_battery_AVG = factory2_AGV_battery_AVG; }

    public double getFactory3_AGV_battery_AVG() { return factory3_AGV_battery_AVG; }
    public void setFactory3_AGV_battery_AVG(double factory3_AGV_battery_AVG) { this.factory3_AGV_battery_AVG = factory3_AGV_battery_AVG; }
}
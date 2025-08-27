package com.example.demo.model;

public class Home {
    private long target_object;
    private long succeed_object;
    private long failed_object;
    private long total_object;
    private long AGV_battery_wrong;

    private double factory1_avg_speed;
    private double factory2_avg_speed;
    private double factory3_avg_speed;

    private double factory1_avg_weight;
    private double factory2_avg_weight;
    private double factory3_avg_weight;

    public Home() {}

    public Home(long target_object, long succeed_object, long failed_object, long total_object,
                long AGV_battery_wrong, double factory1_AVG, double factory2_AVG, double factory3_AVG) {
        this.target_object = target_object;
        this.succeed_object = succeed_object;
        this.failed_object = failed_object;
        this.total_object = total_object;
        this.AGV_battery_wrong = AGV_battery_wrong;
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

    public double getFactory1_avg_speed() {return factory1_avg_speed;}
    public void setFactory1_avg_speed(double factory1_avg_speed) {this.factory1_avg_speed = factory1_avg_speed;}

    public double getFactory2_avg_speed() {return factory2_avg_speed;}
    public void setFactory2_avg_speed(double factory2_avg_speed) {this.factory2_avg_speed = factory2_avg_speed;}

    public double getFactory3_avg_speed() {return factory3_avg_speed;}
    public void setFactory3_avg_speed(double factory3_avg_speed) {this.factory3_avg_speed = factory3_avg_speed;}

    public double getFactory1_avg_weight() {return factory1_avg_weight;}
    public void setFactory1_avg_weight(double factory1_avg_weight) {this.factory1_avg_weight = factory1_avg_weight;}

    public double getFactory2_avg_weight() {return factory2_avg_weight;}
    public void setFactory2_avg_weight(double factory2_avg_weight) {this.factory2_avg_weight = factory2_avg_weight;}

    public double getFactory3_avg_weight() {return factory3_avg_weight;}
    public void setFactory3_avg_weight(double factory3_avg_weight) {this.factory3_avg_weight = factory3_avg_weight;}
}
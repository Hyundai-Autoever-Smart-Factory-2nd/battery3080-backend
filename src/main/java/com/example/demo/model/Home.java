package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Home {
    private long achievement_target;
    private long achievement_achieved;
    private long defect_production;
    private long defect_defective;

    private long total_battery_wrong;
    private long agv_battery_wrong;
    private long robot_arm_battery_wrong;
    private long lift_car_battery_wrong;
    private long etc_battery_wrong;
    private double factory1_agv_avg;
    private double factory1_robot_avg;
    private double factory1_lift_avg;
    private double factory2_agv_avg;
    private double factory2_robot_avg;
    private double factory2_lift_avg;
    private double factory3_agv_avg;
    private double factory3_robot_avg;
    private double factory3_lift_avg;
}

//
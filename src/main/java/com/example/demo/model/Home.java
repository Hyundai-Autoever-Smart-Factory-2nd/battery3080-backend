package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Home {
    private long achievement_target;
    private long achievement_achieved;
    private long defect_production;
    private long defect_defective;

    private long total_production;
    private long line_a_production;
    private long line_b_production;
    private long line_c_production;
    private long line_d_production;
    private long quality_defective;
    private long quality_rework;
    private long quality_waste;
    private long operation_workers;
    private long operation_equipment;
    private long operation_downtime;
    private long resource_material;
    private long resource_energy;
    private long resource_efficiency;
}

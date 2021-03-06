package org.strykeforce.thirdcoast.telemetry.grapher

/** Available telemetry measurement types.  */
enum class Measure constructor(val description: String) {

    // BaseMotorController
    BASE_ID("Base ID"),
    BUS_VOLTAGE("Bus Voltage"),
    CLOSED_LOOP_ERROR("Closed Loop Error (PID 0)"),
    CLOSED_LOOP_TARGET("Closed-loop Setpoint (PID 0)"),
    CONTROL_MODE("Control Mode"),
    DEVICE_ID("Device ID"),
    ERROR_DERIVATIVE("Error Derivative (PID 0)"),
    FIRMWARE_VERSION("Firmware Version"),
    INTEGRAL_ACCUMULATOR("Integral Accumulator (PID 0)"),
    OUTPUT_PERCENT("Output Percentage"),
    OUTPUT_VOLTAGE("Output Voltage"),
    OUTPUT_CURRENT("Output Current"),
    SELECTED_SENSOR_POSITION("Selected Sensor Position (PID 0)"),
    SELECTED_SENSOR_VELOCITY("Selected Sensor Velocity (PID 0)"),
    ACTIVE_TRAJECTORY_HEADING("Active Trajectory Heading"),
    ACTIVE_TRAJECTORY_POSITION("Active Trajectory Position"),
    ACTIVE_TRAJECTORY_VELOCITY("Active Trajectory Velocity"),

    // TalonSRX SensorCollection
    ANALOG_IN("Analog Position Input"),
    ANALOG_IN_RAW("Analog Raw Input"),
    ANALOG_IN_VELOCITY("Analog Velocity Input"),
    QUAD_A_PIN("Quad A Pin State"),
    QUAD_B_PIN("Quad B Pin State"),
    QUAD_IDX_PIN("Quad Index Pin State"),
    PULSE_WIDTH_POSITION("Pulse Width Position"),
    PULSE_WIDTH_RISE_TO_FALL("PWM Pulse Width"),
    PULSE_WIDTH_RISE_TO_RISE("PWM Period"),
    PULSE_WIDTH_VELOCITY("Pulse Width Velocity"),
    QUAD_POSITION("Quadrature Position"),
    QUAD_VELOCITY("Quadrature Velocity"),
    FORWARD_LIMIT_SWITCH_CLOSED("Forward Limit Switch Closed"),
    REVERSE_LIMIT_SWITCH_CLOSED("Reverse Limit Switch Closed"),
    //  FORWARD_SOFT_LIMIT("Forward Soft Limit"),
    //  REVERSE_SOFT_LIMIT("Reverse Soft Limit"),

    // Canifier
    PWM0_PULSE_WIDTH("PWM 0 Pulse Width"),
    PWM0_PERIOD("PWM 0 Period"),
    PWM0_PULSE_WIDTH_POSITION("PWM 0 Pulse Width Position"),
    PWM1_PULSE_WIDTH("PWM 1 Pulse Width"),
    PWM1_PERIOD("PWM 1 Period"),
    PWM1_PULSE_WIDTH_POSITION("PWM 1 Pulse Width Position"),
    PWM2_PULSE_WIDTH("PWM 2 Pulse Width"),
    PWM2_PERIOD("PWM 2 Period"),
    PWM2_PULSE_WIDTH_POSITION("PWM 2 Pulse Width Position"),
    PWM3_PULSE_WIDTH("PWM 3 Pulse Width"),
    PWM3_PERIOD("PWM 3 Period"),
    PWM3_PULSE_WIDTH_POSITION("PWM 3 Pulse Width Position"),

    // General
    DISPLACEMENT_X("X Displacement"),
    DISPLACEMENT_Y("Y Displacement"),
    DISPLACEMENT_Z("Z Displacement"),
    ROTATION_X("X Rotation (Roll)"),
    ROTATION_Y("Y Rotation (Pitch)"),
    ROTATION_Z("Z Rotation (Yaw)"),
    ROTATION_RATE_X("X Rotation Rate (Roll)"),
    ROTATION_RATE_Y("Y Rotation Rate (Pitch)"),
    ROTATION_RATE_Z("Z Rotation Rate (Yaw)"),

    COMPONENT_FORWARD("Forward Component"),
    COMPONENT_STRAFE("Strafe Component"),
    COMPONENT_YAW("Yaw Component"),

    DISPLACEMENT_EXPECTED("Expected Displacement"),
    DISPLACEMENT_ACTUAL("Actual Displacement"),
    DISPLACEMENT_ERROR("Displacement Error"),
    VELOCITY_EXPECTED("Expected Velocity"),
    VELOCITY_ACTUAL("Actual Velocity"),
    VELOCITY_ERROR("Velocity Error"),
    ACCELERATION_EXPECTED("Expected Acceleration"),
    ACCELERATION_ACTUAL("Actual Acceleration"),
    ACCELERATION_ERROR("Acceleration Error"),
    JERK_EXPECTED("Expected Jerk"),
    JERK_ACTUAL("Actual Jerk"),
    JERK_ERROR("Jerk Error"),

    ENCODER_EXPECTED("Expected Encoder Value"),
    ENCODER_ACTUAL("Actual Encoder Value"),
    ENCODER_ERROR("Encoder Value Error"),

    POSITION("Position"),
    RANGE("Range"),
    ANGLE("Angle"),
    VALUE("Measured Value"),
    UNKNOWN("Unknown Measurement"),
}

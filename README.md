# Third Coast Swerve Drive
[![Build Status](https://travis-ci.org/strykeforce/thirdcoast.svg?branch=master)](https://travis-ci.org/strykeforce/thirdcoast)

Example Third Coast swerve drive and Talon configuration API for FRC robots. It is designed to run on swerve drive hardware described in this [paper](https://www.chiefdelphi.com/media/papers/3375).

Read the Third Coast [javadocs](https://strykeforce.github.io/thirdcoast/javadoc/).


## Demonstration Robot
A demonstration of Third Coast API usage is in [`org.strykeforce.thirdcoast.robot`](src/main/java/org/strykeforce/thirdcoast/robot). This uses [GradleRIO](https://github.com/Open-RIO/GradleRIO) to build.

**Note:** you must edit the [`thirdcoast.toml`](src/main/resources/org/strykeforce/thirdcoast.toml) configuration file and provide Talon position-mode PID parameters for your hardware. This file will be copied from the deployed JAR file to `/home/lvuser/thirdcoast.toml` the first time you deploy and run the robot code.

## Swerve Drive
The swerve drive is controlled using the [`SwerveDrive`](src/main/java/org/strykeforce/thirdcoast/swerve) class. Derivation of inverse kinematic equations are from Ether's [Swerve Kinematics and Programming](https://www.chiefdelphi.com/media/papers/2426).

The swerve-drive inverse kinematics algorithm will always calculate individual wheel angles as -0.5 to 0.5 rotations, measured clockwise with zero being the straight-ahead position. Wheel speed is calculated as 0 to 1 in the direction of the wheel angle. The [`Wheel`](src/main/java/org/strykeforce/thirdcoast/swerve) class will calculate how to implement this angle and drive direction optimally for the azimuth and drive motors. In some cases it makes sense to reverse wheel direction to avoid rotating the wheel azimuth 180 degrees.

Hardware assumed by the `Wheel` class includes a CTRE magnetic encoder on the azimuth motor and no limits on wheel azimuth rotation. Azimuth Talons have an ID in the range 0-3 with corresponding drive Talon IDs in the range 10-13.


## Talon Configurations

Third Coast provides a library for storing any number of Talon configurations in a [TOML](https://github.com/toml-lang/toml) file and applying them to Talons. The configuration file is stored in the robot application JAR and loaded by the class loader.

The structure of a Talon configuration file is:

```toml
# first Talon configuration
[[TALON]]
name = "drive"
mode = "Voltage"
# etc...

# second Talon configuration
[[TALON]]
name = "azimuth"
mode = "Position"
# etc...
```

### Talon Configuration Parameter Reference

Talon parameters may apply to all or specific modes as listed below.

#### Talon Parameters Applicable to all Operating Modes

##### name

Each talon configuration name needs to be globally unique.

```toml
name = "drive_teleop"
```

##### mode

Select a control mode from the following list. Note this is case-sensitive. If not specified, defaults to Voltage.

- Current
- Disabled
- Follower
- MotionMagic
- MotionProfile
- PercentVbus
- Position
- Speed
- Voltage

```toml
mode = "Voltage"
```

##### setpoint_max

Max input or throttle will scale to this absolute value. Units are the same at the setpoint, i.e. volts, ticks, etc... Applies to all modes.

```toml
setpoint_max = 12.0 # max volts
```

##### current_limit

Limit current to specified maximum. A value of zero will disable current limit. Applies to all modes.

```toml
current_limit = 50
```

##### feedback_device

Select feedback device from the following list. Note this is case-sensitive. If not specified, defaults to QuadEncoder. Applies to all modes.

- AnalogEncoder
- AnalogPot
- CtreMagEncoder_Absolute
- CtreMagEncoder_Relative
- EncFalling
- EncRising
- PulseWidth
- QuadEncoder

```toml
feedback_device = "QuadEncoder"
```

##### ticks_per_revolution

Configure how many codes per revolution are generated by this encoder. See Talon software manual section 7.2\. If not specified, Talon will use native units. Applies to all modes.

```toml
ticks_per_revolution = 4096
```

##### brake_in_neutral

Set to true to brake during neutral, false to coast during neutral. If not specified, defaults to true. Applies to all modes.

```toml
brake_in_neutral = true
```

##### forward_limit_switch, reverse_limit_switch

Limit switches are normally-open, normally-closed, or disabled. If not specified, defaults to disabled. Applies to all modes.

- NormallyOpen
- NormallyClosed
- Disabled

```toml
forward_limit_switch = "NormallyOpen"
reverse_limit_switch = "Disabled"
```

##### forward_soft_limit, reverse_soft_limit

Soft limits are set if the following options are present. Units are the same at the setpoint, i.e. volts, ticks. Applies to all modes.

```toml
forward_soft_limit = 10000.0
reverse_soft_limit = 12000.0
```

##### encoder_reversed

Set to true to reverse the encoder sensing direction to be in-phase with motor output. If not specified, defaults to false. Applies to all modes.

```toml
encoder_reversed = false
```

##### output_reversed

Set to true to reverse motor output. If not specified, defaults to false. Applies to all modes.

```toml
output_reversed = false
```

##### voltage_ramp_rate

Set a maximum output voltage ramp rate, in volts/sec. A value at or near zero will disable ramping (see Talon software manual section 6.4). Applies to all modes.

```toml
voltage_ramp_rate = 0.0
```

##### velocity_measurement_period

The Velocity Measurement Sample Period is selected from a fixed list of pre-supported sampling periods [1, 5, 10, 20, 25, 50, 100] milliseconds (see Talon software manual section 7.8). If not specified, defaults to 100 ms.

```toml
velocity_measurement_period = 100
```

##### velocity_measurement_window

The Velocity Measurement Rolling Average Window is selected from a fixed list of pre-supported sample counts: [1, 2, 4, 8, 16, 32, 64]. If an alternative value is specified, it is rounded down to the nearest supported value. If not specified, defaults to 64.

```toml
velocity_measurement_window = 64
```

#### Talon Parameters Applicable to Closed-loop Operating Modes

##### PIDF, I-zone

##### allowable_closed_loop_error

Within this error range, PID gains are zero, F still in effect. Units are mA for current, talon native units for position and velocity. If not specified, defaults to zero. Applies to closed-loop modes.

```toml
allowable_closed_loop_error = 0
```

##### forward_output_voltage_nominal, reverse_output_voltage_nominal

Output magnitude between zero and this value is set to this value. If not specified, defaults to zero. Applies to closed-loop modes.

```toml
forward_output_voltage_nominal = 0.0
reverse_output_voltage_nominal = 0.0
```

##### forward_output_voltage_peak, reverse_output_voltage_peak

Output voltage will be limited to this value. If not specified, defaults to no limit, Applies to closed-loop modes.

```toml
forward_output_voltage_peak = 5.0
reverse_output_voltage_peak = 5.0
```

##### nominal_closed_loop_voltage

When set, the output of the Closed Loop mode is compensated for the measured battery voltage. Set to zero to disable. If not specified, defaults to disabled. Applies to closed-loop modes.

```toml
nominal_closed_loop_voltage = 12.0
```

##### output_voltage_max

Set the maximum voltage that the Talon will ever output. This can be used to limit the maximum output voltage (positive or negative) in closed-loop modes so that motors which cannot withstand full bus voltage can be used safely. If not specified, defaults to no limit.

```toml
output_voltage_max = 12.0
```

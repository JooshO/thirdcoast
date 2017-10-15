package org.strykeforce.thirdcoast.telemetry.grapher;

import com.ctre.CANTalon;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;

/**
 * <a href="https://google.github.io/dagger/">Dagger</a> dependency-injection support for {@link
 * Inventory}.
 */
@Module
public class InventoryModule {

  @Provides
  @Singleton
  static Inventory inventory() {
    List<CANTalon> talons = new ArrayList<>(16);
    talons.add(new CANTalon(1));
    long vers = talons.get(0).GetFirmwareVersion();
    System.out.println("vers = " + vers);
    return RobotInventory.of(talons);
  }
}

package com;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.mojang.api.profiles.HttpProfileRepository;
import com.mojang.api.profiles.Profile;

public class PUUID {
  
  /* Created by Heirteir
   * for Bukkit and Spigot and any other Bukkit fork users
   * Please give @Heirteir credit or at least don't say you made it.
   * thanks for using my library and I hope it helps.
   */
  private static final String AGENT = "minecraft";
  private static final HttpProfileRepository repository = new HttpProfileRepository(AGENT);

  /**
   * Get the UUID from a playername
   * 
   * @param name Name of player to get the UUID of
   * @return String (UUID)
   */

  public static String getUUID(String name) {

    Profile[] profiles = repository.findProfilesByNames(name.toString());

    for (Player p : Bukkit.getOnlinePlayers()) {
      if (p.getName().equalsIgnoreCase(name)) {
        return p.getUniqueId().toString();
      }
    }

    if (profiles.length == 1) {

      StringBuilder str = new StringBuilder(profiles[0].getId());
      str.insert(8, "-");
      str.insert(13, "-");
      str.insert(18, "-");
      str.insert(23, "-");

      return str.toString();
    } else
      return "UUID Not Found";
  }

  public static String getNameFromUUID (String uuid) {
    return Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
  }
}

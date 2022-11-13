package kr.pak.skill

import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerToggleSneakEvent
import java.util.*

class Escape : Listener {

    var escpmsg =
        ChatColor.GRAY.toString() + "[" + ChatColor.BLUE + "Escape" + ChatColor.GRAY + "]"

    @EventHandler
    fun es(e: PlayerToggleSneakEvent) {
        val p = e.player
        if (p.isSneaking && loc1.isEmpty()) {
            loc1[p.uniqueId] = p.location
            p.sendActionBar(escpmsg + ChatColor.BLUE + "위치 저장")
        } else if (p.isSneaking) {
            loc2[p.uniqueId] = p.location
            p.teleport(loc1[p.uniqueId]!!)
            p.world.createExplosion(loc2[p.uniqueId]!!, 3f, false, false)
            p.sendActionBar(escpmsg + ChatColor.BLUE + "위치 이동")
            loc1.remove(p.uniqueId)
            loc2.remove(p.uniqueId)
        }
    }

    companion object {
        private val loc1 = HashMap<UUID, Location>()
        private val loc2 = HashMap<UUID, Location>()
    }
}
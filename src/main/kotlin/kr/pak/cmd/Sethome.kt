package kr.pak.cmd

import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

class Sethome : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(ChatColor.RED.toString() + "플레이어만 가능합니다!")
        } else if (sender is Player) {
            val p = sender
            if (label.equals("sethome", ignoreCase = true)) {
                home[p.uniqueId] = p.location
                p.playSound(p.location, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f)
                p.sendActionBar(ChatColor.GREEN.toString() + "집이 저장되었습니다!")
            } else if (label.equals("home", ignoreCase = true)) {
                if (home.containsKey(p.uniqueId)) {
                    val loc = home[p.uniqueId]
                    p.teleport(loc!!)
                    p.playSound(p.location, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f)
                    p.sendActionBar(ChatColor.GREEN.toString() + "집으로 이동하였습니다!")
                } else {
                    p.sendActionBar(ChatColor.RED.toString() + "집을 설정하십시오!")
                }
            }
        }
        return false
    }

    companion object {
        private val home = HashMap<UUID, Location>()
    }
}
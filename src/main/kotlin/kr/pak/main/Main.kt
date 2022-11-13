package kr.pak.main

import kr.pak.cmd.Sethome
import kr.pak.skill.Escape
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    override fun onEnable() {
        logger.info("Hello")
        server.pluginManager.registerEvents(Escape(), this)
        getCommand("sethome")!!.setExecutor(Sethome())
        getCommand("home")!!.setExecutor(Sethome())
    }

    override fun onDisable() {
        logger.info("Bye")
    }
}
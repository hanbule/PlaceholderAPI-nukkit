package com.creeperface.nukkit.placeholderapi

import cn.nukkit.plugin.Plugin

/**
 * @author CreeperFace
 */
class Configuration(private val plugin: Plugin) {

    val version: Double

    val updateInterval: Int

    val dateFormat: String

    val timeFormat: String

    val coordsAccuracy: Int

    val booleanFalseFormat: String

    val booleanTrueFormat: String

    init {
        val cfg = plugin.config

        version = cfg.getDouble("version", 0.0)
        updateInterval = cfg.getInt("min_update_interval", 10)
        dateFormat = cfg.getString("date_format", "yyyy-MM-dd")
        timeFormat = cfg.getString("time_format", "HH:mm:ss")
        coordsAccuracy = cfg.getInt("coordinates_accuracy", 2)
        booleanFalseFormat = cfg.getString("boolean_format.false_value", "no")
        booleanTrueFormat = cfg.getString("boolean_format.true_value", "yes")

        if (version < VERSION) {
            plugin.logger.warning("Current config version is outdated and some properties might be missing")
        }
    }

    companion object {

        const val VERSION = 3
    }
}
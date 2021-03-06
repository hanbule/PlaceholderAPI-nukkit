package com.creeperface.nukkit.placeholderapi.api

/**
 * @author CreeperFace
 */
class PlaceholderParameters(private val params: Map<String, String>, private val unnamed: List<String>) {

    fun single() = unnamed.firstOrNull() ?: params.values.firstOrNull()

    operator fun get(key: String) = params[key]

    fun getNamed() = params.toMap()

    fun getUnnamed() = unnamed.toList()

    fun get() = params.values + unnamed

    @Deprecated("", replaceWith = ReplaceWith("get()"))
    fun getAll() = params.toMap()

    companion object {
        val EMPTY = PlaceholderParameters(emptyMap(), emptyList())
    }
}
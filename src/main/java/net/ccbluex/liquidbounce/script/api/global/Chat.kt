/*
 * RinBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/rattermc/rinbounce69
 */
package net.ccbluex.liquidbounce.script.api.global

import net.ccbluex.liquidbounce.utils.client.chat

/**
 * Object used by the script API to provide an easier way of calling chat-related methods.
 */
object Chat {

    /**
     * Prints a message to the chat (client-side)
     * @param message Message to be printed
     */
    @Suppress("unused")
    @JvmStatic
    fun print(message : String) = chat(message)
}
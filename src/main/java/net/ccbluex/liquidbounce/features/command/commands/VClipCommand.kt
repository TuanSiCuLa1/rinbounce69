/*
 * RinBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/rattermc/rinbounce69
 */
package net.ccbluex.liquidbounce.features.command.commands

import net.ccbluex.liquidbounce.features.command.Command

object VClipCommand : Command("vclip") {
    /**
     * Execute commands with provided [args]
     */
    override fun execute(args: Array<String>) {
        if (args.size > 1) {
            try {
                val y = args[1].toDouble()
                val player = mc.thePlayer ?: return

                val entity = if (player.isRiding) player.ridingEntity else player

                entity.setPosition(entity.posX, entity.posY + y, entity.posZ)
                chat("You were teleported.")
            } catch (ex: NumberFormatException) {
                chatSyntaxError()
            }

            return
        }

        chatSyntax("vclip <value>")
    }
}

/*
 * RinBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/rattermc/rinbounce69
 */
package net.ccbluex.liquidbounce.features.command.commands

import net.ccbluex.liquidbounce.event.Listenable
import net.ccbluex.liquidbounce.LiquidBounce.CLIENT_NAME
import net.ccbluex.liquidbounce.event.Render2DEvent
import net.ccbluex.liquidbounce.event.UpdateEvent
import net.ccbluex.liquidbounce.event.handler
import net.ccbluex.liquidbounce.features.command.Command
import net.ccbluex.liquidbounce.utils.extensions.component1
import net.ccbluex.liquidbounce.utils.extensions.component2
import net.ccbluex.liquidbounce.utils.render.RenderUtils.deltaTime
import net.ccbluex.liquidbounce.utils.render.RenderUtils.drawImage
import net.minecraft.client.gui.ScaledResolution
import net.minecraft.util.ResourceLocation

object TacoCommand : Command("taco"), Listenable {
    var tacoToggle = false
    private var image = 0
    private var running = 0f
    val name = CLIENT_NAME.lowercase()
    private val tacoTextures = arrayOf(
        ResourceLocation("${name}/taco/1.png"),
        ResourceLocation("${name}/taco/2.png"),
        ResourceLocation("${name}/taco/3.png"),
        ResourceLocation("${name}/taco/4.png"),
        ResourceLocation("${name}/taco/5.png"),
        ResourceLocation("${name}/taco/6.png"),
        ResourceLocation("${name}/taco/7.png"),
        ResourceLocation("${name}/taco/8.png"),
        ResourceLocation("${name}/taco/9.png"),
        ResourceLocation("${name}/taco/10.png"),
        ResourceLocation("${name}/taco/11.png"),
        ResourceLocation("${name}/taco/12.png")
    )

    /**
     * Execute commands with provided [args]
     */
    override fun execute(args: Array<String>) {
        tacoToggle = !tacoToggle
        chat(if (tacoToggle) "§aTACO TACO TACO. :)" else "§cYou made the little taco sad! :(")
    }

    val onRender2D = handler<Render2DEvent> {
        if (!tacoToggle)
            return@handler

        running += 0.15f * deltaTime
        val (width, height) = ScaledResolution(mc)
        drawImage(tacoTextures[image], running.toInt(), height - 60, 64, 32)
        if (width <= running)
            running = -64f
    }

    val onUpdate = handler<UpdateEvent> {
        if (!tacoToggle) {
            image = 0
            return@handler
        }

        image++
        if (image >= tacoTextures.size) image = 0
    }


    override fun tabComplete(args: Array<String>) = listOf("TACO")
}
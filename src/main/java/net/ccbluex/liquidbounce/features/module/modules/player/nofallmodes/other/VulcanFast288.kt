/*
 * RinBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/rattermc/rinbounce69
 */
package net.ccbluex.liquidbounce.features.module.modules.player.nofallmodes.other

import net.ccbluex.liquidbounce.event.PacketEvent
import net.ccbluex.liquidbounce.features.module.modules.player.nofallmodes.NoFallMode
import net.ccbluex.liquidbounce.utils.extensions.stopXZ
import net.ccbluex.liquidbounce.utils.movement.FallingPlayer
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition

/*
* Working on Vulcan: 2.8.8
* Tested on: eu.loyisa.cn, anticheat-test.com
* Credit: @ion1x & @Razzy52 / VulcanTP
*/
object VulcanFast288 : NoFallMode("VulcanFast2.8.8") {
    override fun onPacket(event: PacketEvent) {
        val player = mc.thePlayer ?: return
        val packet = event.packet

        if (packet is C04PacketPlayerPosition) {
            val fallingPlayer = FallingPlayer()
            if (player.fallDistance > 2.5 && player.fallDistance < 50) {
                // Checks to prevent fast falling to void.
                if (fallingPlayer.findCollision(500) != null) {
                    packet.onGround = true

                    player.stopXZ()
                    player.motionY = -99.887575
                    player.isSneaking = true
                }
            }
        }
    }
}

/*
 * RinBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/rattermc/rinbounce69
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.speedmodes.ncp

import net.ccbluex.liquidbounce.features.module.modules.movement.speedmodes.SpeedMode
import net.ccbluex.liquidbounce.utils.extensions.isMoving
import net.ccbluex.liquidbounce.utils.movement.MovementUtils.speed
import net.ccbluex.liquidbounce.utils.movement.MovementUtils.strafe

object MiJump : SpeedMode("MiJump") {
    override fun onMotion() {
        if (!mc.thePlayer.isMoving) return
        if (mc.thePlayer.onGround && !mc.thePlayer.movementInput.jump) {
            mc.thePlayer.motionY += 0.1
            val multiplier = 1.8
            mc.thePlayer.motionX *= multiplier
            mc.thePlayer.motionZ *= multiplier
            val currentSpeed = speed
            val maxSpeed = 0.66
            if (currentSpeed > maxSpeed) {
                mc.thePlayer.motionX = mc.thePlayer.motionX / currentSpeed * maxSpeed
                mc.thePlayer.motionZ = mc.thePlayer.motionZ / currentSpeed * maxSpeed
            }
        }
        strafe()
    }

}
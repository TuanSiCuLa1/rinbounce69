/*
 * RinBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/rattermc/rinbounce69
 */
package net.ccbluex.liquidbounce.features.module.modules.player

import net.ccbluex.liquidbounce.event.BlockBBEvent
import net.ccbluex.liquidbounce.event.handler
import net.ccbluex.liquidbounce.features.module.Category
import net.ccbluex.liquidbounce.features.module.Module
import net.minecraft.block.BlockCactus
import net.minecraft.util.AxisAlignedBB

object AntiCactus : Module("AntiCactus", Category.PLAYER, gameDetecting = false) {

    val onBlockBB = handler<BlockBBEvent> { event ->
        if (event.block is BlockCactus)
            event.boundingBox = AxisAlignedBB(
                event.x.toDouble(), event.y.toDouble(), event.z.toDouble(),
                event.x + 1.0, event.y + 1.0, event.z + 1.0
            )
    }
}

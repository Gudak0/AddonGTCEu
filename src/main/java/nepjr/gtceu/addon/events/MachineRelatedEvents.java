package nepjr.gtceu.addon.events;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.Level;

import gregtech.api.block.machines.BlockMachine;
import gregtech.api.block.machines.MachineItemBlock;
import io.netty.handler.logging.LogLevel;
import nepjr.gtceu.addon.NepJrAddon;
import nepjr.gtceu.addon.config.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.event.world.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = NepJrAddon.MODID)
public class MachineRelatedEvents 
{
	@SubscribeEvent
	public static void disallowRegularMachinesInSpace(EntityPlaceEvent event)
	{
		// Make sure we're a real player
		if (event.getEntity() instanceof EntityPlayer)
		{
			// Check if we're in space dimensions
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (ArrayUtils.contains(ModConfig.space.spaceDims, event.getWorld().provider.getDimension())) // Checks if the current dimension a player is in equals a space dimension
			{
				// Check the held item and see if it's a GT machine
				Item item = player.getHeldItemMainhand().getItem();
				if (item instanceof MachineItemBlock)
				{
					// I want that machine OBLITTERATED! (not really but still)
					if(!(ArrayUtils.contains(ModConfig.space.allowedMachines, player.getHeldItemMainhand().getMetadata()))
							&& player.getHeldItemMainhand().getMetadata() < 672
							|| (player.getHeldItemMainhand().getMetadata() > 1269
							&& player.getHeldItemMainhand().getMetadata() < 16000))
					{
						player.sendMessage(new TextComponentString("This machine is not advanced enough to be in space! (The item may turn into a ghost item!)"));
						event.setCanceled(true);
					}
				}
				// Same shit different hand
				Item item2 = player.getHeldItemOffhand().getItem();
				if (item2 instanceof MachineItemBlock)
				{
					// you know who else wants that machine oblitterated?
					if(!(ArrayUtils.contains(ModConfig.space.allowedMachines, player.getHeldItemOffhand().getMetadata())) 
							&& (player.getHeldItemOffhand().getMetadata() < 672 
							|| (player.getHeldItemOffhand().getMetadata() > 1269 
							&& player.getHeldItemOffhand().getMetadata() < 16000)))
					{
						player.sendMessage(new TextComponentString("This machine is not advanced enough to be in space! (The item may turn into a ghost item!)"));
						event.setCanceled(true);
					}
				}
			}
		}
	}
}
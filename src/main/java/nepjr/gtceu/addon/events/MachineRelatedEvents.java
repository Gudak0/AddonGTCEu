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
		if (event.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (ArrayUtils.contains(ModConfig.space.spaceDims, event.getWorld().provider.getDimension()))
			{
				ItemStack item = player.getHeldItemMainhand();
				if (player.getHeldItemMainhand().getItem() instanceof MachineItemBlock)
				{
					MachineItemBlock machine = (MachineItemBlock) player.getHeldItemMainhand().getItem();
					if (!(machine.getMetadata(item) != 1650 || machine.getMetadata(item) != 1669 || machine.getMetadata(item) != 1668) && machine.getMetadata(item) < 16000 || machine.getMetadata(item) > 16609)
					{
						player.sendMessage(new TextComponentString("This machine is not advanced enough to be placed in space (it may turn into a ghost item)"));
						event.setCanceled(true);
					}
					NepJrAddon.logger.log(Level.INFO, machine.getMetadata(item));
				}
				if (player.getHeldItemOffhand().getItem() instanceof MachineItemBlock)
				{
					MachineItemBlock machine = (MachineItemBlock) player.getHeldItemOffhand().getItem();
					if (!(machine.getMetadata(item) != 1650 || machine.getMetadata(item) != 1669 || machine.getMetadata(item) != 1668) && machine.getMetadata(item) < 16000 || machine.getMetadata(item) > 16609)
					{
						player.sendMessage(new TextComponentString("This machine is not advanced enough to be placed in space (it may turn into a ghost item)"));
						event.setCanceled(true);
					}
					NepJrAddon.logger.log(Level.INFO, machine.getMetadata(item));
				}
			}
		}

	}
	
}

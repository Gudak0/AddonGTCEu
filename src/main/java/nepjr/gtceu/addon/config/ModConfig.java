package nepjr.gtceu.addon.config;

import org.apache.logging.log4j.Level;


import morph.avaritia.Avaritia;
import nepjr.gtceu.addon.NepJrAddon;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = NepJrAddon.MODID)
public class ModConfig 
{
	@Config.Comment("General stuff for the mod")
	@Config.Name("General Options")
	@Config.RequiresMcRestart
	public static GeneralOptions general = new GeneralOptions();
	
	@Config.Comment("Options for Mod Compatibility")
	@Config.Name("Compat Options")
	@Config.RequiresMcRestart
	public static CompatOptions compat = new CompatOptions();
	
	@Config.Comment("Space related options in the mod")
	@Config.Name("Space Options")
	public static SpaceMachineOptions space = new SpaceMachineOptions();
	
	public static class GeneralOptions 
	{
		@Config.Comment("Intended for the LDS Craft Modpack")
		@Config.Name("Enable LDS Mode")
		public boolean ldsMode = false;
	}
	
	public static class CompatOptions
	{
		@Config.Comment("Enables or Disables Avaritia stuff")
		@Config.Name("Avaritia Compatibility")
		public boolean avaritiaCompat = true;
		
		@Config.Comment("Enables or Disables ProjectE stuff")
		@Config.Name("ProjectE Compatibility")
		public boolean projecteCompat = true;
	}
	
	public static class SpaceMachineOptions
	{
		@Config.Comment("What dimensions are considered space? If you have GalactiCraft installed for example, you should set it to the dimension IDs of the space station and moon")
		@Config.Name("Space Dimensions")
		public int spaceDims[] = new int[] {-1,1};
		
		@Config.Comment("What machines are allowed to be placed in space? To get these IDs, check the metadata number of the machine. By default Gas collectors are allowed. By default it everything, so long as the metadata value is < 672 < 11500")
		@Config.Name("Allowed Machines in space")
		public int allowedMachines[] = new int[] {530, 531, 532, 533, 534, 535, 536, 537};
		
	}
}

package nepjr.gtceu.addon;

import org.apache.logging.log4j.Level;

import morph.avaritia.Avaritia;
import moze_intel.projecte.PECore;
import nepjr.gtceu.addon.config.ModConfig;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Loader;

@Mod.EventBusSubscriber(modid = NepJrAddon.MODID)
public class CommonProxy {

	public void preLoad()
	{
		
	}
	
    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(NepJrAddon.MODID)) {
            ConfigManager.sync(NepJrAddon.MODID, Type.INSTANCE);
        }
    }
    
    public static void checkModSupport()
    {
    	if(ModConfig.compat.avaritiaCompat && !Loader.isModLoaded(Avaritia.MOD_ID))
    	{
    		ModConfig.compat.avaritiaCompat = false;
    		NepJrAddon.logger.log(Level.WARN, "Avaritia Compatibility enabled, but Avaritia wasn't found. Disabling Avaritia Compatibility");
    	}
    	else {NepJrAddon.logger.log(Level.INFO, "Avaritia Detected, adding Avaritia support since it's enabled!");}
    	
    	if(ModConfig.compat.projecteCompat && !Loader.isModLoaded(PECore.MODID))
    	{
    		ModConfig.compat.projecteCompat = false;
    		NepJrAddon.logger.log(Level.WARN, "ProjectE Compatibility enabled, but ProjectE wasn't found. Disabling ProjectE Compatibility");
    	}
    	else {NepJrAddon.logger.log(Level.INFO, "ProjectE Detected, adding ProjectE support since it's enabled!");}
    }
	
}

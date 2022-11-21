package nepjr.gtceu.addon.config;

import org.apache.logging.log4j.Level;

import morph.avaritia.Avaritia;
import nepjr.gtceu.addon.NepJrAddon;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;

public class ModConfig 
{
	private static final String CAT_GENERAL = "general";
	private static final String CAT_COMPAT = "compat";
	
	// General
	public static boolean ldsCraftMode = false;
	
	// Compat
	public static boolean compatAvaritia = true;
	
	public static void readConfig()
	{
		Configuration cfg = NepJrAddon.config;
		try
		{
			cfg.load();
			doGeneralStuff(cfg);
			doCompatStuff(cfg);
		} catch (Exception error1)
		{
			NepJrAddon.logger.log(Level.ERROR, "Problem loading config", error1);
		}
		finally
		{
			if (cfg.hasChanged())
			{
				cfg.save();
			}
		}
	}
	
	private static void doGeneralStuff(Configuration cfg)
	{
		cfg.addCustomCategoryComment(CAT_GENERAL, "General Configuration");
		ldsCraftMode = cfg.getBoolean("LDS Craft Mode", CAT_GENERAL, ldsCraftMode, "This addon was made for this modpack but I decided to put a boolean to enable and disable features that I implemented specifically for that modpack. You can enable it if you want those features");
		
	}
	
	private static void doCompatStuff(Configuration cfg)
	{
		cfg.addCustomCategoryComment(CAT_COMPAT, "Compatibility Configuration");
		compatAvaritia = cfg.getBoolean("Avaritia Compatibility", CAT_COMPAT, compatAvaritia, "Enable Avaritia compatibility");
		if (!Loader.isModLoaded(Avaritia.MOD_ID))
		{
			compatAvaritia = false;
		}
	}
}

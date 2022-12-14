package nepjr.gtceu.addon;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

import org.apache.logging.log4j.Logger;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI.MaterialEvent;
import nepjr.gtceu.addon.covers.AddonCoverBehaviour;
import nepjr.gtceu.addon.items.AddonMetaItems;
import nepjr.gtceu.addon.ldsmode.mats.LDSMaterials;
import nepjr.gtceu.addon.mats.ModMaterials;
import nepjr.gtceu.addon.recipes.Recipes;
import nepjr.gtceu.addon.tile.AddonMetaTileEntitiesLV;
import nepjr.gtceu.addon.tile.AddonMetaTileEntitiesMultiblock;
import nepjr.gtceu.addon.tile.AddonMetaTileEntitiesUHV;
import nepjr.gtceu.addon.config.ModConfig;

// To anyone browsing and/or editing this code: do NOT remove the dependencies part in the @Mod section below, or the game will crash
// If you remove it and complain to me, I WILL call you dumpy
@Mod(modid = NepJrAddon.MODID, name = NepJrAddon.NAME, version = NepJrAddon.VERSION, dependencies = "required-after:" + GTValues.MODID)
public class NepJrAddon
{
    public static final String MODID = "gregiousmaximus";
    public static final String NAME = "Gregious Maxmimus";
    public static final String VERSION = "1.1-b2";
    public static Configuration config;
    
    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	System.out.println("NepJr's GTCEu says \"Hello from PreInit!\"");

		File directory = event.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), MODID + ".cfg"));
		ModConfig.readConfig();

    	MinecraftForge.EVENT_BUS.register(ModMaterials.class);
    	
    	// For machines starting at LV tier
    	AddonMetaTileEntitiesLV.init();
    	
    	// For machines starting at UHV tier
    	AddonMetaTileEntitiesUHV.init();
    	
    	// Multiblocks
    	AddonMetaTileEntitiesMultiblock.init();
    	
    	MinecraftForge.EVENT_BUS.register(ModMaterials.class);
    	
    	AddonMetaItems.init();


		// If LDS mode is turned on, activate LDS Craft stuff
		if (ModConfig.ldsCraftMode)
		{
			MinecraftForge.EVENT_BUS.register(LDSMaterials.class);
		}

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
    	System.out.println("NepJr's GTCEu says \"Hello from Init!\"");
    	AddonCoverBehaviour.init();
    	Recipes.register();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	System.out.println("NepJr's GTCEu says \"Hello from PostInit!\"");
    	if(config.hasChanged())
    	{
    		config.save();
    	}
    }
}

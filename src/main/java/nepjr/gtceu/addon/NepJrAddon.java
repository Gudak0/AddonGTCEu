package nepjr.gtceu.addon;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import gregtech.api.GTValues;
import nepjr.gtceu.addon.items.AddonMetaItems;
import nepjr.gtceu.addon.tile.AddonMetaTileEntities;

@Mod(modid = NepJrAddon.MODID, name = NepJrAddon.NAME, version = NepJrAddon.VERSION)
public class NepJrAddon
{
    public static final String MODID = "nepjr-gtceu-addon";
    public static final String NAME = "NepJr's GTCEu Addon";
    public static final String VERSION = "1.1";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	System.out.println("NepJr's GTCEu says \"Hello from PreInit!\"");

    	AddonMetaTileEntities.init();
    	AddonMetaItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
    	System.out.println("NepJr's GTCEu says \"Hello from Init!\"");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	System.out.println("NepJr's GTCEu says \"Hello from PostInit!\"");
    }
}

package nepjr.gtceu.addon.mats;

import gregtech.api.GregTechAPI.MaterialEvent;
import gregtech.api.unification.material.Material;
import nepjr.gtceu.addon.NepJrAddon;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid = NepJrAddon.MODID)
public class ModMaterials 
{   
    public static Material liquidEMC;
    
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void register(MaterialEvent event) 
    { 
    	ModMaterials.liquidEMC = new Material.Builder(24000, "emc.liquid")
    			.fluid()
    			.build();
    }
}


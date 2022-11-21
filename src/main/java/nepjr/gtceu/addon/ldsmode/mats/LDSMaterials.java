package nepjr.gtceu.addon.ldsmode.mats;

import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.Material;
import nepjr.gtceu.addon.NepJrAddon;
import nepjr.gtceu.addon.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = NepJrAddon.MODID)
public class LDSMaterials
{
    public static Material Dantanium;

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void register(GregTechAPI.MaterialEvent event)
    {
        if(ModConfig.ldsCraftMode == true)
        {
            Dantanium = new Material.Builder(22000, "dantanium")
                    .color(0xFF00FF)
                    .ingot().dust().fluid()
                    .build();
        }
    }
}

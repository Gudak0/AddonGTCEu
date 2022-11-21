package nepjr.gtceu.addon.tile;

import gregtech.api.GTValues;
import nepjr.gtceu.addon.tile.multi.elec.AddonMetaTileEntityFusionReactor;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

// I have to register mutli blocks like this, probably because I fucked up somewhere lmao
public class AddonMetaTileEntitiesMultiblock 
{
	public static AddonMetaTileEntityFusionReactor MOD_FUSION_REACTOR;
	
	public static void init()
	{
        MOD_FUSION_REACTOR = registerMetaTileEntity(2000, new AddonMetaTileEntityFusionReactor(AddonMetaTileEntitiesUHV.addonId("fusion_reactor.uhv")));
	}
}

package nepjr.gtceu.addon.tile;

import gregtech.api.GTValues;
import nepjr.gtceu.addon.tile.multi.elec.AddonMetaTileEntityFusionReactor;
import nepjr.gtceu.addon.tile.multi.elec.AddonMetaTileEntityResourceMiner;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

// I have to register mutli blocks like this, probably because I fucked up somewhere lmao
public class AddonMetaTileEntitiesMultiblock 
{
	public static AddonMetaTileEntityFusionReactor MOD_FUSION_REACTOR;
	public static AddonMetaTileEntityResourceMiner[] MOD_RESOURCE_MINER = new AddonMetaTileEntityResourceMiner[GTValues.V.length];
	
	public static void init()
	{
		
        //MOD_FUSION_REACTOR = registerMetaTileEntity(2000, new AddonMetaTileEntityFusionReactor(AddonMetaTileEntitiesUHV.addonId("fusion_reactor.uhv")));
        //MOD_RESOURCE_MINER[1] = registerMetaTileEntity(2001, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.lv"), GTValues.LV));
        //MOD_RESOURCE_MINER[2] = registerMetaTileEntity(2002, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.mv"), GTValues.MV));
        //MOD_RESOURCE_MINER[3] = registerMetaTileEntity(2003, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.hv"), GTValues.HV));
        //MOD_RESOURCE_MINER[4] = registerMetaTileEntity(2004, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.ev"), GTValues.EV));
        //MOD_RESOURCE_MINER[5] = registerMetaTileEntity(2005, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.iv"), GTValues.IV));
        //MOD_RESOURCE_MINER[6] = registerMetaTileEntity(2006, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.luv"), GTValues.LuV));
        //MOD_RESOURCE_MINER[7] = registerMetaTileEntity(2007, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.zpm"), GTValues.ZPM));
        //MOD_RESOURCE_MINER[8] = registerMetaTileEntity(2008, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.uv"), GTValues.UV));
        
        //MOD_RESOURCE_MINER[9] =  registerMetaTileEntity(2009, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.uhv"), GTValues.UHV));
        //MOD_RESOURCE_MINER[10] = registerMetaTileEntity(2010, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.uiv"), GTValues.UIV));
        //MOD_RESOURCE_MINER[11] = registerMetaTileEntity(2011, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.uev"), GTValues.UEV));
        //MOD_RESOURCE_MINER[12] = registerMetaTileEntity(2012, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.uxv"), GTValues.UXV));
        //MOD_RESOURCE_MINER[13] = registerMetaTileEntity(2013, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.opv"), GTValues.OpV));
        //MOD_RESOURCE_MINER[14] = registerMetaTileEntity(2014, new AddonMetaTileEntityResourceMiner(AddonMetaTileEntitiesUHV.addonId("resource_miner.max"), GTValues.MAX));

	}
}

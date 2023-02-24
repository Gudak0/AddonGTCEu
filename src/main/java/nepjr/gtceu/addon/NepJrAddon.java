package nepjr.gtceu.addon;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.io.File;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;

import javax.annotation.Nullable;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI.MaterialEvent;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import moze_intel.projecte.PECore;
import moze_intel.projecte.emc.EMCMapper;
import moze_intel.projecte.emc.SimpleStack;
import moze_intel.projecte.impl.EMCProxyImpl;
import nepjr.gtceu.addon.covers.AddonCoverBehaviour;
import nepjr.gtceu.addon.items.AddonMetaItems;
import nepjr.gtceu.addon.mats.ModMaterials;
import nepjr.gtceu.addon.recipes.ModRecipeMaps;
import nepjr.gtceu.addon.recipes.Recipes;
import nepjr.gtceu.addon.tile.AddonMetaTileEntitiesLV;
import nepjr.gtceu.addon.tile.AddonMetaTileEntitiesMultiblock;
import nepjr.gtceu.addon.tile.AddonMetaTileEntitiesSpace;
import nepjr.gtceu.addon.tile.AddonMetaTileEntitiesUHV;
import nepjr.gtceu.addon.config.ModConfig;

// To anyone browsing and/or editing this code: do NOT remove the dependencies part in the @Mod section below, or the game will crash
// If you remove it and complain to me, I WILL call you dumpy
@Mod(modid = NepJrAddon.MODID, name = NepJrAddon.NAME, version = NepJrAddon.VERSION, dependencies = GTValues.MOD_VERSION_DEP  + "after:" + PECore.MODID)
public class NepJrAddon
{
    public static final String MODID = "gregiousmaximus";
    public static final String NAME = "Gregious Maxmimus";
    public static final String VERSION = "1.1-b2";
    
    public static Logger logger = LogManager.getLogger(MODID);
    
    @SidedProxy(modId = MODID, clientSide = "nepjr.gtceu.addon.client.ClientProxy", serverSide = "nepjr.gtceu.addon.CommonProxy")
    public static CommonProxy proxy;
 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	System.out.println("NepJr's GTCEu says \"Hello from PreInit!\"");
    	
    	// This is to make sure that when a mod compatibility is enabled, that we actually have the mod installed
    	proxy.checkModSupport();
    	
    	proxy.preLoad();
    	
    	// For machines starting at LV tier
    	AddonMetaTileEntitiesLV.init();
    	
    	// For machines starting at UHV tier
    	AddonMetaTileEntitiesUHV.init();
    	
    	// Space Grade Machines (LV - MAX)
    	AddonMetaTileEntitiesSpace.init();
    	
    	// Multiblocks
    	AddonMetaTileEntitiesMultiblock.init();
    	
    	// Items
    	AddonMetaItems.init();
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
    }
    
    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
    if(ModConfig.compat.projecteCompat && Loader.isModLoaded(PECore.MODID))
    	{
    	for(SimpleStack sstack : EMCMapper.emc.keySet())
    	{
    		ItemStack item = sstack.toItemStack();
    		//NepJrAddon.logger.log(Level.INFO, item);
			//NepJrAddon.logger.log(Level.INFO, "EMC Maker: Attempting to convert " + item + " into EMC!");
    		long emc = EMCProxyImpl.instance.getValue(item);
    		
    		if(emc > 0)
    		{
        		ModRecipeMaps.EMC_MAKER.recipeBuilder()
    				.input(item.getItem(), 1, item.getItemDamage())
    				.fluidOutputs(ModMaterials.liquidEMC.getFluid((int) emc))
    				.EUt((int) emc)
    				.duration(600)
    				.buildAndRegister();
        		
        		ModRecipeMaps.EMCER.recipeBuilder()
        			.notConsumable(item)
        			.fluidInputs(ModMaterials.liquidEMC.getFluid((int) emc))
        			.output(item.getItem(), 1, item.getItemDamage())
        			.EUt((int) emc)
        			.duration(600)
        			.buildAndRegister();
    			}
    		}
    	}
    }
    
    @EventHandler
    public void serverStopping(FMLServerStoppingEvent event)
    {
    	if(ModConfig.compat.projecteCompat && Loader.isModLoaded(PECore.MODID))
    	{
    		for(Recipe r : ModRecipeMaps.EMCER.getRecipeList())
    		{
    			ModRecipeMaps.EMCER.removeRecipe(r);
    		}
    		
    		for(Recipe r : ModRecipeMaps.EMC_MAKER.getRecipeList())
    		{
    			ModRecipeMaps.EMC_MAKER.removeRecipe(r);
    		}
    	}
    }
}

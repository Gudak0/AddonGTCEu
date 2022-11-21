package nepjr.gtceu.addon.mats;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI.MaterialEvent;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import morph.avaritia.Avaritia;
import nepjr.gtceu.addon.NepJrAddon;
import nepjr.gtceu.addon.config.ModConfig;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;

@Mod.EventBusSubscriber(modid = NepJrAddon.MODID)
public class ModMaterials 
{
    public static Material infinity;
    public static Material element_zero;
    public static Material nepjrium;
    public static Material proton;
    public static Material neutron;
    public static Material darquadahstadtium;
    
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void register(MaterialEvent event) 
    {   
		  if(ModConfig.compatAvaritia && Loader.isModLoaded(Avaritia.MOD_ID))
		  {
			ModMaterials.infinity = new Material.Builder(24000, "infinity")
					  .color(0xFFFFFF)
					  .flags(GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_DENSE, GENERATE_ROUND)
					  .cableProperties(2147483647, 1, 0, true)
					  .itemPipeProperties(2147483647, 2147483647)			  
					  .components(Iron, 5400, Gold, 3600, Lapis, 3600, Redstone, 6300, NetherQuartz, 1600, Diamond, 4500, Emerald, 3600, Copper, 5400, Tin, 5400, Lead, 4500, Silver, 4500, Nickel, 5400)
					  .build();
		  }
		  if (ModConfig.ldsCraftMode)
		  {
			ModMaterials.element_zero = new Material.Builder(24001, "element_zero")
					  .color(0x000000)
					  .ingot().dust()
					  .fluid()
			  	      .flags(GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_DENSE, GENERATE_ROUND)
			  	      .cableProperties(GTValues.V[13], 1, 0, true)
			  	      .fluidPipeProperties(2147483647, 119304647, true)
					  .build();
		  }
		 ModMaterials.nepjrium = new Material.Builder(24002, "nepjrium")
				 .color(0xFF00FF)
				 .ingot().dust().fluid()
		  	     .flags(GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_DENSE, GENERATE_ROUND)
		  	     .cableProperties(GTValues.V[10], 1, 0, true)
				 .build();
		 
		 ModMaterials.darquadahstadtium = new Material.Builder(24003, "darquadahstadtium")
				 .color(0x00FF00)
				 .ingot().dust().fluid()
		  	     .flags(GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_DENSE, GENERATE_ROUND)
		  	     .cableProperties(GTValues.V[9], 1, 0, true)
		  	     .components(Naquadah, 9, Darmstadtium, 9)
				 .build();
		 }
}


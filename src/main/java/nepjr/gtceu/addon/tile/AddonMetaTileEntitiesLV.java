package nepjr.gtceu.addon.tile;

import java.util.function.Function;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.metatileentities.electric.MetaTileEntityHull;
import gregtech.common.metatileentities.electric.MetaTileEntityMacerator;
import gregtech.common.metatileentities.multi.electric.MetaTileEntityFusionReactor;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityFluidHatch;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityItemBus;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiFluidHatch;
import gregtech.integration.jei.multiblock.MultiblockInfoCategory;
import moze_intel.projecte.PECore;
import nepjr.gtceu.addon.config.ModConfig;
import nepjr.gtceu.addon.recipes.ModRecipeMaps;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import scala.actors.threadpool.Arrays;

public class AddonMetaTileEntitiesLV
{	
    //public static final SimpleMachineMetaTileEntity[] MOD_REPLICATOR = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] EMC_CREATOR = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] EMCER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] TEST = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static void init()
	{
        // The replicator was here to simply test if this code works.
        //registerSimpleMetaTileEntity(MOD_REPLICATOR, 365, "replicator", RecipeMaps.REPLICATOR_RECIPES, Textures.REPLICATOR_OVERLAY, true);
    	if(ModConfig.compat.projecteCompat && Loader.isModLoaded(PECore.MODID))
    	{
    		registerSimpleMetaTileEntity(EMC_CREATOR, 10500, "emc_creator", ModRecipeMaps.EMC_MAKER, Textures.ASSEMBLER_OVERLAY, true, emcTank);
    		registerSimpleMetaTileEntity(EMCER, 10508, "emcer", ModRecipeMaps.EMCER, Textures.ASSEMBLER_OVERLAY, true, emcTank);	
    	}
    	registerSimpleMetaTileEntity(TEST, 365, "test", ModRecipeMaps.TEST, Textures.FERMENTER_OVERLAY, true);
	}	
	
	    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines,
                                                    int startId,
                                                    String name,
                                                    RecipeMap<?> map,
                                                     ICubeRenderer texture,
                                                    boolean hasFrontFacing,
                                                    Function<Integer, Integer> tankScalingFunction) {
        registerSimpleMetaTileEntity(machines, startId, name, map, texture, hasFrontFacing, AddonMetaTileEntitiesUHV::addonId, tankScalingFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines,
                                                    int startId,
                                                    String name,
                                                    RecipeMap<?> map,
                                                     ICubeRenderer texture,
                                                    boolean hasFrontFacing) {
        registerSimpleMetaTileEntity(machines, startId, name, map, texture, hasFrontFacing, GTUtility.defaultTankSizeFunction);
    }

    public static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines,
                                                    int startId,
                                                    String name,
                                                    RecipeMap<?> map,
                                                    ICubeRenderer texture,
                                                    boolean hasFrontFacing,
                                                    Function<String, ResourceLocation> resourceId,
                                                    Function<Integer, Integer> tankScalingFunction) {
    	for (int i = 0; i < machines.length - 1; i++) {		
            if (i > 7) break;
            String voltageName = GTValues.VN[i + 1].toLowerCase();
            // Need to subtract startId by 8 then add i to make the metadata id in the game align with the startId
            machines[i + 1] = registerMetaTileEntity(startId + i,
                    new SimpleMachineMetaTileEntity(resourceId.apply(String.format("%s.%s", name, voltageName)), map, texture, i + 1, hasFrontFacing, tankScalingFunction));
        }
    }
    

    public static <T extends MetaTileEntity> T registerMetaTileEntity(int id, T sampleMetaTileEntity) {
        if (sampleMetaTileEntity instanceof IMultiblockAbilityPart) {
            IMultiblockAbilityPart<?> abilityPart = (IMultiblockAbilityPart<?>) sampleMetaTileEntity;
            MultiblockAbility.registerMultiblockAbility(abilityPart.getAbility(), sampleMetaTileEntity);
        }
        if (sampleMetaTileEntity instanceof MultiblockControllerBase && Loader.isModLoaded(GTValues.MODID_JEI)) {
            if (((MultiblockControllerBase) sampleMetaTileEntity).shouldShowInJei()) {
                MultiblockInfoCategory.registerMultiblock((MultiblockControllerBase) sampleMetaTileEntity);
            }
        }
        GregTechAPI.MTE_REGISTRY.register(id, sampleMetaTileEntity.metaTileEntityId, sampleMetaTileEntity);
        return sampleMetaTileEntity;
    }

	  private static ResourceLocation gregtechId(String name) {
	        return new ResourceLocation(GTValues.MODID, name);
	    }
	  
    public static final Function<Integer, Integer> emcTank = tier -> {
	        return (int) GTValues.V[tier];
	    };
}

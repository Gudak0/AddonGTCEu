package nepjr.gtceu.addon.recipes;

import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.VA;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.FusionRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import nepjr.gtceu.addon.recipes.machines.EMCMakerRecipeBuilder;
import nepjr.gtceu.addon.recipes.machines.SimpleSpaceRecipeBuilder;
import nepjr.gtceu.addon.recipes.multiblock.HyperFusionRecipeBuilder;
import nepjr.gtceu.addon.recipes.multiblock.ResourceMinerRecipeBuilder;
import net.minecraft.util.SoundEvent;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mods.nepjr.addon.gtceu.recipes.AddonRecipeMaps")
@ZenRegister
public class ModRecipeMaps 
{

    @ZenProperty
    public static final RecipeMap<HyperFusionRecipeBuilder> HYPER_FUSION_RECIPES = new RecipeMap<>("hyper_fusion_reactor", 0, 0, 0, 0, 2, 2, 0, 1, new HyperFusionRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);
    
    @ZenProperty
    public static final RecipeMap<ResourceMinerRecipeBuilder> RESOURCE_MINER = new RecipeMap<>("resource_miner", 1, 0, 1, 0, 1, 0, 1, 0, new ResourceMinerRecipeBuilder(), false)
    		.setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, MoveType.HORIZONTAL)
    		.setSound(GTSoundEvents.DRILL_TOOL);
	
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> EMC_MAKER = new RecipeMap<>("emc_builder", 1, 1, 0, 0, 0, 0, 1, 1, new SimpleRecipeBuilder(), false)
    		.setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, MoveType.HORIZONTAL)
    		.setSound(GTSoundEvents.ARC);
    
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> EMCER = new RecipeMap<>("emcer", 1, 1, 1, 1, 1, 1, 0, 0, new SimpleRecipeBuilder(), false)
    		.setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, MoveType.HORIZONTAL)
    		.setSound(GTSoundEvents.ARC);
    
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> TEST = new RecipeMap<>("test", 1, 3, 1, 1, 0, 0, 0, 0, new SimpleRecipeBuilder(), false)
    		.setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, MoveType.HORIZONTAL)
    		.setSound(GTSoundEvents.ARC);
    
    @ZenProperty
    public static final RecipeMap<SimpleSpaceRecipeBuilder> VOID_ORE_MINER = new RecipeMap<>("void_ore_miner", 0, 1, 0, 25, 0, 0, 0, 0, new SimpleSpaceRecipeBuilder(), false)
    		.setSlotOverlay(false, false, GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER)
    		.setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, MoveType.HORIZONTAL)
    		.setSound(GTSoundEvents.DRILL_TOOL);
    
    @ZenProperty
    public static final RecipeMap<SimpleSpaceRecipeBuilder> SPACE_CHEMICAL_REACTOR = new RecipeMap<>("space_chemical_reactor", 0, 2, 0, 2, 0, 3, 0, 2, new SimpleSpaceRecipeBuilder().EUt(VA[LV]), false)
            .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, MoveType.HORIZONTAL)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.CHEMICAL_REACTOR);
    
    @ZenProperty
    public static final RecipeMap<SimpleSpaceRecipeBuilder> SPACE_ALLOY_SMELTER_RECIPES = new RecipeMap<>("space_alloy_smelter", 1, 2, 1, 1, 0, 0, 0, 0, new SimpleSpaceRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.FURNACE_OVERLAY_1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    
}

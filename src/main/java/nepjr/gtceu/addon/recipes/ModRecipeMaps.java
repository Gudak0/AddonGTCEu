package nepjr.gtceu.addon.recipes;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.FusionRecipeBuilder;
import gregtech.api.sound.GTSounds;
import nepjr.gtceu.addon.recipes.multiblock.HyperFusionRecipeBuilder;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mods.nepjr.addon.gtceu.recipes.AddonRecipeMaps")
@ZenRegister
public class ModRecipeMaps 
{

    @ZenProperty
    public static final RecipeMap<HyperFusionRecipeBuilder> HYPER_FUSION_RECIPES = new RecipeMap<>("hyper_fusion_reactor", 0, 0, 0, 0, 2, 2, 0, 1, new HyperFusionRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, MoveType.HORIZONTAL)
            .setSound(GTSounds.ARC);
	
}

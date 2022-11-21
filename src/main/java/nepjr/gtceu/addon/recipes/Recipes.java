package nepjr.gtceu.addon.recipes;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import nepjr.gtceu.addon.mats.ModMaterials;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;

public class Recipes {
	public static void register()
	{
		ModRecipeMaps.HYPER_FUSION_RECIPES.recipeBuilder()
		.fluidInputs(Materials.Neutronium.getFluid(16000), Materials.Naquadah.getFluid(16000))
		.fluidOutputs(ModMaterials.nepjrium.getFluid(144))
		.duration(950)
		.EUt(524288)
		.AddonEUToStart(2147483647)
		.buildAndRegister();

		RecipeMaps.FUSION_RECIPES.recipeBuilder()
		.fluidInputs(Materials.Neutronium.getFluid(16000), Materials.Naquadah.getFluid(16000))
		.fluidOutputs(Materials.Iron.getFluid(144))
		.duration(950)
		.EUt(524288)
		.EUToStart(640000000)
		.buildAndRegister();
		
		RecipeMaps.FUSION_RECIPES.recipeBuilder()
		.fluidInputs(Materials.Naquadah.getFluid(144), Materials.Darmstadtium.getFluid(144))
		.fluidOutputs(ModMaterials.darquadahstadtium.getFluid(16))
		.duration(72000)
		.EUt(524288)
		.EUToStart(640000000)
		.buildAndRegister();
		
	}
}

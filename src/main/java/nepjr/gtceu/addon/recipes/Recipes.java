package nepjr.gtceu.addon.recipes;

import static gregtech.api.unification.material.Materials.Air;

import java.util.Iterator;
import java.util.Objects;

import org.apache.logging.log4j.Level;

import com.cleanroommc.groovyscript.api.IIngredient;

import appeng.fluids.util.FluidSorters;
import gregtech.api.GTValues;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.ValidationResult;
import moze_intel.projecte.emc.EMCMapper;
import moze_intel.projecte.emc.IngredientMap;
import moze_intel.projecte.emc.SimpleStack;
import moze_intel.projecte.impl.EMCProxyImpl;
import nepjr.gtceu.addon.NepJrAddon;
import nepjr.gtceu.addon.config.ModConfig;
import nepjr.gtceu.addon.mats.ModMaterials;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.item.ItemStack;

public class Recipes {
	static int i, dim;
	public static void register()
	{	
		ModRecipeMaps.TEST.recipeBuilder()
		.inputs(Items.APPLE.getDefaultInstance(), Items.DIAMOND.getDefaultInstance(), Item.getItemFromBlock(Blocks.BEDROCK).getDefaultInstance())
		.output(Items.BED)
		.duration(1)
		.EUt(32)
		.buildAndRegister();
		
		RecipeMaps.GAS_COLLECTOR_RECIPES.recipeBuilder()
        .notConsumable(new IntCircuitIngredient(4))
        .fluidOutputs(Materials.Naquadah.getFluid(10000))
        .duration(20)
		.EUt(32)
		.buildAndRegister();
		

		// add space machine recipes here to account for all space dimensions
		
		for (Recipe r : RecipeMaps.CHEMICAL_RECIPES.getRecipeList())
		{
			ModRecipeMaps.SPACE_CHEMICAL_REACTOR.recipeBuilder().append(r, 1, false).dimension(ModConfig.space.spaceDims).buildAndRegister();
		}
		
		for (Recipe r : RecipeMaps.ALLOY_SMELTER_RECIPES.getRecipeList())
		{
			ModRecipeMaps.SPACE_ALLOY_SMELTER_RECIPES.recipeBuilder().append(r, 1, false).dimension(ModConfig.space.spaceDims).buildAndRegister();
		}
		ModRecipeMaps.SPACE_CHEMICAL_REACTOR.recipeBuilder()
				.fluidInputs(Materials.Iron.getFluid(144), Materials.Water.getFluid(144))
				.fluidOutputs(Materials.Brass.getFluid(144))
				.EUt(32)
				.duration(10)
				.dimension(ModConfig.space.spaceDims)
				.buildAndRegister();
					
		ModRecipeMaps.SPACE_ALLOY_SMELTER_RECIPES.recipeBuilder()
				.inputs(Items.IRON_INGOT.getDefaultInstance(), Items.COAL.getDefaultInstance())
				.output(OrePrefix.ingot, Materials.Steel, 1)
				.EUt(32767)
				.duration(10)
				.dimension(ModConfig.space.spaceDims)
				.buildAndRegister();
	}
}

package nepjr.gtceu.addon.recipes.machines;

import java.util.List;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import crafttweaker.CraftTweakerAPI;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.GasCollectorRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.recipeproperties.GasCollectorDimensionProperty;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntLists;

public class SimpleSpaceRecipeBuilder extends RecipeBuilder<SimpleSpaceRecipeBuilder> {

    public SimpleSpaceRecipeBuilder() {
    }

    public SimpleSpaceRecipeBuilder(Recipe recipe, RecipeMap<SimpleSpaceRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public SimpleSpaceRecipeBuilder(RecipeBuilder<SimpleSpaceRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public SimpleSpaceRecipeBuilder copy() {
        return new SimpleSpaceRecipeBuilder(this);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(GasCollectorDimensionProperty.KEY)) {
            if (value instanceof Integer) {
                this.dimension((Integer) value);
            } else if (value instanceof List && !((List<?>) value).isEmpty() && ((List<?>) value).get(0) instanceof Integer) {
                IntList dimensionIDs = getDimensionIDs();
                if (dimensionIDs == IntLists.EMPTY_LIST) {
                    dimensionIDs = new IntArrayList();
                    this.applyProperty(GasCollectorDimensionProperty.getInstance(), dimensionIDs);
                }
                dimensionIDs.addAll((List<Integer>) value);
            } else {
                if (isCTRecipe) {
                    CraftTweakerAPI.logError("Dimension for Gas Collector needs to be a Integer");
                    return false;
                }
                throw new IllegalArgumentException("Invalid Dimension Property Type!");
            }
            return true;
        }
        return super.applyProperty(key, value);
    }

    public SimpleSpaceRecipeBuilder dimension(int dimensionID) {
        IntList dimensionIDs = getDimensionIDs();
        if (dimensionIDs == IntLists.EMPTY_LIST) {
            dimensionIDs = new IntArrayList();
            this.applyProperty(GasCollectorDimensionProperty.getInstance(), dimensionIDs);
        }
        dimensionIDs.add(dimensionID);
        return this;
    }

    public IntList getDimensionIDs() {
        return this.recipePropertyStorage == null ? IntLists.EMPTY_LIST :
                this.recipePropertyStorage.getRecipePropertyValue(GasCollectorDimensionProperty.getInstance(),
                        IntLists.EMPTY_LIST);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(GasCollectorDimensionProperty.getInstance().getKey(), getDimensionIDs().toString())
                .toString();
    }
    
}

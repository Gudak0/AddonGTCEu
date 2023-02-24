package nepjr.gtceu.addon.recipes.multiblock;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.FusionEUToStartProperty;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTLog;

public class ResourceMinerRecipeBuilder extends RecipeBuilder<ResourceMinerRecipeBuilder>
{
    public ResourceMinerRecipeBuilder() {
    }

    public ResourceMinerRecipeBuilder(Recipe recipe, RecipeMap<ResourceMinerRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public ResourceMinerRecipeBuilder(RecipeBuilder<ResourceMinerRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public ResourceMinerRecipeBuilder copy() {
        return new ResourceMinerRecipeBuilder(this);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(FusionEUToStartProperty.KEY)) {
            this.AddonEUToStart(((Number) value).longValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public ResourceMinerRecipeBuilder AddonEUToStart(long EUToStart) {
        if (EUToStart <= 0) {
            GTLog.logger.error("EU to start cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(ModFusionEUToStartProperty.getInstance(), EUToStart);
        return this;
    }

    public long getEUToStart() {
        return this.recipePropertyStorage == null ? 0L :
                this.recipePropertyStorage.getRecipePropertyValue(ModFusionEUToStartProperty.getInstance(), 0L);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(ModFusionEUToStartProperty.getInstance().getKey(), getEUToStart())
                .toString();
    }
}

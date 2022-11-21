package nepjr.gtceu.addon.recipes.multiblock;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.Level;

import gregtech.api.recipes.recipeproperties.FusionEUToStartProperty;
import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;
import nepjr.gtceu.addon.NepJrAddon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class ModFusionEUToStartProperty extends RecipeProperty<Long> {

    public static final String KEY = "eu_to_start";

    private static final TreeMap<Long, String> registeredFusionTiers = new TreeMap<>();

    private static ModFusionEUToStartProperty INSTANCE;

    protected ModFusionEUToStartProperty() {
        super(KEY, Long.class);
    }

    public static ModFusionEUToStartProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ModFusionEUToStartProperty();
        }

        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gregtech.recipe.eu_to_start",
                castValue(value)) + getFusionTier(castValue(value)), x, y, color);
    }
    
    private String getFusionTier(Long eu) {
        return "MK Hyper";
    }
    
}

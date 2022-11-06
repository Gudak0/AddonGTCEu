package nepjr.gtceu.addon.covers;

import java.util.function.BiFunction;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.cover.CoverBehavior;
import gregtech.api.cover.CoverDefinition;
import gregtech.api.cover.ICoverable;
import gregtech.api.items.metaitem.MetaItem.MetaValueItem;
import gregtech.api.util.GTLog;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.covers.detector.*;
import gregtech.common.covers.filter.OreDictionaryItemFilter;
import gregtech.common.covers.filter.SimpleFluidFilter;
import gregtech.common.covers.filter.SimpleItemFilter;
import gregtech.common.covers.filter.SmartItemFilter;
import gregtech.common.items.MetaItems;
import gregtech.common.items.behaviors.CoverDigitalInterfaceWirelessPlaceBehaviour;
import gregtech.common.items.behaviors.CoverPlaceBehavior;
import nepjr.gtceu.addon.NepJrAddon;
import nepjr.gtceu.addon.items.AddonMetaItems;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class AddonCoverBehaviour 
{

    public static void init() 
    {
    	registerBehavior(104, new ResourceLocation(GTValues.MODID, "conveyor.uhv"), AddonMetaItems.CONVEYOR_MODULE_UHV, (tile, side) -> new AddonCoverConveyor(tile, side, GTValues.UHV, 32 * 64));
    	registerBehavior(105, new ResourceLocation(GTValues.MODID, "conveyor.uev"), AddonMetaItems.CONVEYOR_MODULE_UEV, (tile, side) -> new AddonCoverConveyor(tile, side, GTValues.UEV, 64 * 64));
    	registerBehavior(106, new ResourceLocation(GTValues.MODID, "conveyor.uiv"), AddonMetaItems.CONVEYOR_MODULE_UIV, (tile, side) -> new AddonCoverConveyor(tile, side, GTValues.UIV, 128 * 64));
    	registerBehavior(107, new ResourceLocation(GTValues.MODID, "conveyor.uxv"), AddonMetaItems.CONVEYOR_MODULE_UXV, (tile, side) -> new AddonCoverConveyor(tile, side, GTValues.UXV, 256 * 64));
    	registerBehavior(108, new ResourceLocation(GTValues.MODID, "conveyor.opv"), AddonMetaItems.CONVEYOR_MODULE_OpV, (tile, side) -> new AddonCoverConveyor(tile, side, GTValues.OpV, 512 * 64));
    	registerBehavior(109, new ResourceLocation(GTValues.MODID, "conveyor.max"), AddonMetaItems.CONVEYOR_MODULE_MAX, (tile, side) -> new AddonCoverConveyor(tile, side, GTValues.MAX, 2147483647));
    }
	
    public static void registerBehavior(int coverNetworkId, ResourceLocation coverId, MetaValueItem placerItem, BiFunction<ICoverable, EnumFacing, CoverBehavior> behaviorCreator) {
        placerItem.addComponents(new CoverPlaceBehavior(registerCover(coverNetworkId, coverId, placerItem, behaviorCreator)));
    }

    public static CoverDefinition registerCover(int coverNetworkId, ResourceLocation coverId, MetaValueItem itemStack, BiFunction<ICoverable, EnumFacing, CoverBehavior> behaviorCreator) {
        CoverDefinition coverDefinition = new CoverDefinition(coverId, behaviorCreator, itemStack.getStackForm());
        GregTechAPI.COVER_REGISTRY.register(coverNetworkId, coverId, coverDefinition);
        return coverDefinition;
    }
    
}

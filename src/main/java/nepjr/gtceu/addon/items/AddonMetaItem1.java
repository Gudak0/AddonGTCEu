package nepjr.gtceu.addon.items;

import gregtech.api.GTValues;
import gregtech.api.items.metaitem.*;
import gregtech.api.items.metaitem.stats.IItemComponent;
import gregtech.api.items.metaitem.stats.IItemContainerItemProvider;
import gregtech.api.items.metaitem.stats.ItemFluidContainer;
import gregtech.api.terminal.hardware.HardwareProvider;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterial;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.MarkerMaterials.Component;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.util.RandomPotionEffect;
import gregtech.common.ConfigHolder;
import gregtech.common.items.behaviors.*;
import gregtech.common.items.behaviors.monitorplugin.AdvancedMonitorPluginBehavior;
import gregtech.common.items.behaviors.monitorplugin.FakeGuiPluginBehavior;
import gregtech.common.items.behaviors.monitorplugin.OnlinePicPluginBehavior;
import gregtech.common.items.behaviors.monitorplugin.TextPluginBehavior;
import gregtech.core.sound.GTSoundEvents;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import static gregtech.api.GTValues.M;
import static gregtech.api.util.DyeUtil.getOredictColorName;
import static gregtech.common.items.MetaItems.*;

public class AddonMetaItem1 extends StandardMetaItem {
	
	public AddonMetaItem1()
	{
		super();
	}
	
	@Override
	public void registerSubItems()
	{
		// Motors
        ELECTRIC_MOTOR_UHV = 						addItem(1, "electric.motor.uhv");
        ELECTRIC_MOTOR_UEV = 						addItem(2, "electric.motor.uev");
        ELECTRIC_MOTOR_UIV = 						addItem(3, "electric.motor.uiv");
        ELECTRIC_MOTOR_UXV = 						addItem(4, "electric.motor.uxv");
        ELECTRIC_MOTOR_OpV = 						addItem(5, "electric.motor.opv");
        AddonMetaItems.ELECTRIC_MOTOR_MAX = 		addItem(6, "electric.motor.max");
        
        // Pumps
        ELECTRIC_PUMP_UHV = 						addItem(7, "electric.pump.uhv");
        ELECTRIC_PUMP_UEV = 						addItem(8, "electric.pump.uev");
        ELECTRIC_PUMP_UIV = 						addItem(9, "electric.pump.uiv");
        ELECTRIC_PUMP_UXV = 						addItem(10, "electric.pump.uxv");
        ELECTRIC_PUMP_OpV = 						addItem(11, "electric.pump.opv");
        AddonMetaItems.ELECTRIC_PUMP_MAX =  		addItem(12, "electric.pump.max");
        
        // Conveyors
        AddonMetaItems.CONVEYOR_MODULE_UHV =		addItem(13, "conveyor.module.uhv");
        AddonMetaItems.CONVEYOR_MODULE_UEV =		addItem(14, "conveyor.module.uev");
        AddonMetaItems.CONVEYOR_MODULE_UIV =		addItem(15, "conveyor.module.uiv");
        AddonMetaItems.CONVEYOR_MODULE_UXV =		addItem(16, "conveyor.module.uxv");
        AddonMetaItems.CONVEYOR_MODULE_OpV =		addItem(17, "conveyor.module.opv");
        AddonMetaItems.CONVEYOR_MODULE_MAX =		addItem(18, "conveyor.module.max");
        
        // Circuits
        AddonMetaItems.CIRCUIT_UHV_1 = 				addItem(19, "circuit.uhv.1").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        AddonMetaItems.CIRCUIT_UHV_2 = 				addItem(20, "circuit.uhv.2").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        
        AddonMetaItems.CIRCUIT_UEV_1 = 				addItem(21, "circuit.uev.1").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        AddonMetaItems.CIRCUIT_UEV_2 = 				addItem(22, "circuit.uev.2").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        AddonMetaItems.CIRCUIT_UEV_3 = 				addItem(23, "circuit.uev.3").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        
        AddonMetaItems.CIRCUIT_UIV_1 = 				addItem(24, "circuit.uiv.1").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        AddonMetaItems.CIRCUIT_UIV_2 = 				addItem(25, "circuit.uiv.2").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        AddonMetaItems.CIRCUIT_UIV_3 = 				addItem(26, "circuit.uiv.3").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        
        AddonMetaItems.CIRCUIT_UXV_1 = 				addItem(27, "circuit.uxv.1").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        AddonMetaItems.CIRCUIT_UXV_2 = 				addItem(28, "circuit.uxv.2").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        AddonMetaItems.CIRCUIT_UXV_3 = 				addItem(29, "circuit.uxv.3").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV); 
        
        AddonMetaItems.CIRCUIT_OpV_1 = 				addItem(30, "circuit.opv.1").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        AddonMetaItems.CIRCUIT_OpV_2 = 				addItem(31, "circuit.opv.2").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        AddonMetaItems.CIRCUIT_OpV_3 = 				addItem(32, "circuit.opv.3").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        
        AddonMetaItems.CIRCUIT_MAX_1 = 				addItem(33, "circuit.max.1").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);
        AddonMetaItems.CIRCUIT_MAX_2 = 				addItem(34, "circuit.max.2").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);
        AddonMetaItems.CIRCUIT_MAX_3 = 				addItem(35, "circuit.max.3").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);
	
        // Void Miner Drill Cores
	}

}

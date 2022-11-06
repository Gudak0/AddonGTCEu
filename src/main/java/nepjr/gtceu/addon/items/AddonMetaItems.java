package nepjr.gtceu.addon.items;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.common.items.MetaItems;

public class AddonMetaItems 
{

	public static MetaItem<?>.MetaValueItem ELECTRIC_MOTOR_MAX;
	public static MetaItem<?>.MetaValueItem ELECTRIC_PUMP_MAX;
	public static MetaItem<?>.MetaValueItem ELECTRIC_PISTON_MAX;
	
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UHV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UEV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UIV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UXV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_OpV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_MAX;
	
	public static MetaItem<?>.MetaValueItem ROBOT_ARM_MAX;
	
	public static MetaItem<?>.MetaValueItem FIELD_GENERATOR_MAX;
	
	public static MetaItem<?>.MetaValueItem EMITTER_MAX;
	
	public static MetaItem<?>.MetaValueItem SENSOR_MAX;
	
	public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_MAX;
	
	public static MetaItem<?>.MetaValueItem FLUID_REGULATOR_MAX;
	
	// Circuit time. UHV already has a single circuit so we're only making 2
	public static MetaItem<?>.MetaValueItem CIRCUIT_UHV_1;
	public static MetaItem<?>.MetaValueItem CIRCUIT_UHV_2;
	// public static MetaItem<?>.MetaValueItem CIRCUIT_UHV_3;
	
	public static MetaItem<?>.MetaValueItem CIRCUIT_UEV_1;
	public static MetaItem<?>.MetaValueItem CIRCUIT_UEV_2;
	public static MetaItem<?>.MetaValueItem CIRCUIT_UEV_3;
	
	public static MetaItem<?>.MetaValueItem CIRCUIT_UIV_1;
	public static MetaItem<?>.MetaValueItem CIRCUIT_UIV_2;
	public static MetaItem<?>.MetaValueItem CIRCUIT_UIV_3;
	
	public static MetaItem<?>.MetaValueItem CIRCUIT_UXV_1;
	public static MetaItem<?>.MetaValueItem CIRCUIT_UXV_2;
	public static MetaItem<?>.MetaValueItem CIRCUIT_UXV_3;
	
	public static MetaItem<?>.MetaValueItem CIRCUIT_OpV_1;
	public static MetaItem<?>.MetaValueItem CIRCUIT_OpV_2;
	public static MetaItem<?>.MetaValueItem CIRCUIT_OpV_3;
	
	public static MetaItem<?>.MetaValueItem CIRCUIT_MAX_1;
	public static MetaItem<?>.MetaValueItem CIRCUIT_MAX_2;
	public static MetaItem<?>.MetaValueItem CIRCUIT_MAX_3;
	
	// These already exist in the code for GTCEu however they won't work as covers if I don't do this
	public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_UHV;
	public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_UEV;
	public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_UIV;
	public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_UXV;
	public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_OpV;
	
    public static void init() {
        AddonMetaItem1 first = new AddonMetaItem1();
        first.setRegistryName("meta_items");
        //MetaTool tool = new MetaTool();
        //tool.setRegistryName("meta_tool");
        //CT_OREDICT_ITEM = new MetaOreDictItem((short) 0);
        //CT_OREDICT_ITEM.setRegistryName("meta_oredict_item_ct");
        //MetaArmor armor = new MetaArmor();
        //armor.setRegistryName("gt_armor");
        //for (OrePrefix prefix : orePrefixes) {
           // String regName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, prefix.name());
           // MetaPrefixItem metaOrePrefix = new MetaPrefixItem(prefix);
            //metaOrePrefix.setRegistryName(String.format("meta_%s", regName));
        }
	
}

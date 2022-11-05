package nepjr.gtceu.addon.items;

import gregtech.api.items.metaitem.MetaItem;

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

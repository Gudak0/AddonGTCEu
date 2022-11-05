package nepjr.gtceu.addon.items;

import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.common.items.MetaItems;

public class AddonMetaItem1 extends StandardMetaItem {
	
	public AddonMetaItem1()
	{
		super();
	}
	
	@Override
	public void registerSubItems()
	{
		// Motors
        MetaItems.ELECTRIC_MOTOR_UHV = 		addItem(1, "electric.motor.uhv");
        MetaItems.ELECTRIC_MOTOR_UEV = 		addItem(2, "electric.motor.uev");
        MetaItems.ELECTRIC_MOTOR_UIV = 		addItem(3, "electric.motor.uiv");
        MetaItems.ELECTRIC_MOTOR_UXV = 		addItem(4, "electric.motor.uxv");
        MetaItems.ELECTRIC_MOTOR_OpV = 		addItem(5, "electric.motor.opv");
        AddonMetaItems.ELECTRIC_MOTOR_MAX = addItem(6, "electric.motor.max");
        
        // Pumps
        MetaItems.ELECTRIC_PUMP_UHV = 		addItem(7, "electric.pump.uhv");
        MetaItems.ELECTRIC_PUMP_UEV = 		addItem(8, "electric.pump.uev");
        MetaItems.ELECTRIC_PUMP_UIV = 		addItem(9, "electric.pump.uiv");
        MetaItems.ELECTRIC_PUMP_UXV = 		addItem(10, "electric.pump.uxv");
        MetaItems.ELECTRIC_PUMP_OpV = 		addItem(11, "electric.pump.opv");
        AddonMetaItems.ELECTRIC_PUMP_MAX = addItem(12, "electric.pump.max");
	}

}

package nepjr.gtceu.addon.api.util;

import java.util.function.Function;

import gregtech.api.GTValues;

public class AddonUtils {
	
    public static final Function<Long, Long> defaultTankSizeFunction = tier -> {
        if (tier <= GTValues.LV)
            return 8000L;
        if (tier == GTValues.MV)
            return 12000L;
        if (tier == GTValues.HV)
            return 16000L;
        if (tier == GTValues.EV)
            return 32000L;
        if (tier == GTValues.IV && tier < GTValues.OpV)
        	return 64000L;
        return Long.MAX_VALUE;
    };
    
    public static final Function<Long, Long> megaCappedTankSizeFunction = tier -> {
    	
    	if (tier <= GTValues.OpV)
    		return 262144L;	    	
        return 2147483647L;
    };
    
    public static final Function<Long, Long> megaLargeTankSizeFunction = tier -> {
    	
    	if (tier <= GTValues.OpV)
    		return 524288L;	    	
        return 2147483647L;
    };

}

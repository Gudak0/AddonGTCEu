package nepjr.gtceu.addon.client;

import nepjr.gtceu.addon.AddonTextures;
import nepjr.gtceu.addon.CommonProxy;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preLoad()
	{
		super.preLoad();
		AddonTextures.preInit();
	}

}

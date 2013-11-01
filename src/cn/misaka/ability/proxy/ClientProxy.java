/**
 * 
 */
package cn.misaka.ability.proxy;

import cn.misaka.ability.client.system.ClientAbilityMain;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * @author WeAthFolD
 *
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		super.preInit();
		TickRegistry.registerTickHandler(new ClientAbilityMain(), Side.CLIENT);
	}
	
	@Override
	public void init() {
		super.init();
	}
	
	@Override
	public void postInit() {
		super.postInit();
	}

	
}

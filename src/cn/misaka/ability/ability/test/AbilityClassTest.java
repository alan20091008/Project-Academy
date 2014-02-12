/**
 * Code by Lambda Innovation, 2013.
 */
package cn.misaka.ability.ability.test;

import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.misaka.system.ability.AbilityClass;

/**
 * @author WeAthFolD
 *
 */
public class AbilityClassTest extends AbilityClass {

	/**
	 * 
	 */
	public AbilityClassTest() {
		for(int i = 0; i < 5; i++) {
			this.skillList.add(new AbilitySkillTest(this, i));
			this.levelList.add(new AbilityLevelTest(this));
		}
	}

	/* (non-Javadoc)
	 * @see cn.misaka.system.ability.AbilityClass#getAbilityName()
	 */
	@Override
	public String getAbilityName() {
		// TODO Auto-generated method stub
		return "Melt Downer";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ResourceLocation getClassLogo() {
		return null;
	}

}

/**
 * Code by Lambda Innovation, 2013.
 */
package cn.misaka.ability.ability.heat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cn.misaka.ability.system.AbilityClass;
import cn.misaka.ability.system.AbilityClass.ControlStat;
import cn.misaka.ability.system.PlayerAbilityData;
import cn.misaka.ability.system.client.system.AbilityRender;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author WeAthFolD
 * 
 */
public class CompHeat1 extends CompHeatBase {

	/**
	 * @param base
	 * @param lvl
	 */
	public CompHeat1(AbilityClass base, int lvl) {
		super(base, lvl);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.misaka.ability.system.AbilityComponent#onAbilityTick(net.minecraft
	 * .entity.player.EntityPlayer, net.minecraft.world.World,
	 * cn.misaka.ability.system.PlayerAbilityData,
	 * cn.misaka.ability.system.AbilityClass.ControlStat)
	 */
	@Override
	protected void onAbilityTick(EntityPlayer player, World world,
			PlayerAbilityData data, ControlStat stat) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.misaka.ability.system.AbilityComponent#onButtonDown(net.minecraft.
	 * entity.player.EntityPlayer, net.minecraft.world.World,
	 * cn.misaka.ability.system.PlayerAbilityData, int,
	 * cn.misaka.ability.system.AbilityClass.ControlStat)
	 */
	@Override
	protected void onButtonDown(EntityPlayer player, World world,
			PlayerAbilityData data, int keyID, ControlStat stat) {
		switch (keyID) {
		case 0:
			break;
		case 1:
			break;
		case 2:
		case 3:
			this.onEnchantStateChange(player, world, data, stat, true);
		default:
			return;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.misaka.ability.system.AbilityComponent#onButtonUp(net.minecraft.entity
	 * .player.EntityPlayer, net.minecraft.world.World,
	 * cn.misaka.ability.system.PlayerAbilityData, int,
	 * cn.misaka.ability.system.AbilityClass.ControlStat)
	 */
	@Override
	protected void onButtonUp(EntityPlayer player, World world,
			PlayerAbilityData data, int keyID, ControlStat stat) {
		switch (keyID) {
		case 0:
			break;
		case 1:
			break;
		case 2:
		case 3:
			this.onEnchantStateChange(player, world, data, stat, false);
		default:
			return;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.misaka.ability.system.AbilityComponent#onButtonTick(net.minecraft.
	 * entity.player.EntityPlayer, net.minecraft.world.World,
	 * cn.misaka.ability.system.PlayerAbilityData, int, int)
	 */
	@Override
	protected void onButtonTick(EntityPlayer player, World world,
			PlayerAbilityData data, int keyID, int ticks) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.misaka.ability.system.AbilityComponent#getClientRender()
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public AbilityRender getClientRender() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.misaka.ability.system.AbilityComponent#getComponentName()
	 */
	@Override
	public String getComponentName() {
		return "Heat-Warmup";
	}

}

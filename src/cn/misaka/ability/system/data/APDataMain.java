/**
 * Copyright (C) Lambda-Innovation, 2013-2014
 * This code is open-source. Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 */
package cn.misaka.ability.system.data;

import net.minecraft.entity.player.EntityPlayer;
import cn.misaka.ability.api.data.PlayerData;

/**
 * @author WeAthFolD
 *
 */
public class APDataMain {

	/**
	 * 
	 */
	public APDataMain() {
		// TODO Auto-generated constructor stub
	}
	
	public static PlayerData loadPlayerData(EntityPlayer player) {
		return getPlayerData(player);
	}
	
	public static  PlayerData getPlayerData(EntityPlayer player) {
		return null;
	}

}

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
package cn.misaka.ability.system.event;

import java.lang.reflect.Field;

import cn.misaka.ability.api.data.PlayerData;
import cn.misaka.ability.block.tile.TileAbilityDeveloper;
import cn.misaka.ability.client.model.ModelBipedAP;
import cn.misaka.ability.system.data.APDataMain;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent17;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.world.BlockEvent;

/**
 * @author WeAthFolD
 *
 */
public class APEventListener {
	
	public APEventListener() {
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		EntityPlayer player = event.getPlayer();
		PlayerData pstat = APDataMain.loadPlayerData(player);
		if(pstat != null && pstat.isActivated && player.getCurrentEquippedItem() == null) {
			event.setCanceled(true);
		}
		System.out.println(player.worldObj.isRemote + " " + player.yOffset);
	}

}

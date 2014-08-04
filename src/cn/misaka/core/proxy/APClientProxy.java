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
package cn.misaka.core.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

import org.lwjgl.input.Keyboard;

import cn.liutils.core.client.register.LIKeyProcess;
import cn.misaka.core.register.APItems;
import cn.misaka.system.client.key.KeySkillControl;
import cn.misaka.system.client.render.RenderAbilityVoid;

/**
 * @author WeAthFolD
 *
 */
public class APClientProxy extends APCommonProxy {

	@Override
	public void preInit() {
		LIKeyProcess.addKey("AP_ML", LIKeyProcess.MOUSE_LEFT, false, new KeySkillControl(0));
		LIKeyProcess.addKey("AP_MR", LIKeyProcess.MOUSE_RIGHT, false, new KeySkillControl(1));
		LIKeyProcess.addKey("AP_R", Keyboard.KEY_R, false, new KeySkillControl(2));
		LIKeyProcess.addKey("AP_F", Keyboard.KEY_F, false, new KeySkillControl(3));
	}
	
	@Override
	public void init() {
		MinecraftForgeClient.registerItemRenderer(APItems.itemVoid, new RenderAbilityVoid());
	}

}

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
package cn.misaka.ability.system.network.message;

import net.minecraft.entity.player.EntityPlayer;
import cn.misaka.ability.system.control.APControlMain;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

/**
 * 
 * @author WeAthFolD
 */
public class ClientOccasionalSync implements IMessage {

	public String player;
	public byte ac_level;
	public byte ac_class;
	public int cp;
	public boolean[] skill_open = new boolean[]{true,false,true};
	public float[] skill_exp;
	public int length;//打酱油的无视
	
	public ClientOccasionalSync(EntityPlayer player,byte ac_level,byte ac_class,int cp,boolean[] skill_open,float[] skill_exp) {
		this.player = player.getCommandSenderName();
		this.ac_level = ac_level;
		this.ac_class = ac_class;
		this.cp = cp;
		this.skill_open = skill_open;
		this.skill_exp = skill_exp;
	}
	
	public ClientOccasionalSync() {}

	@Override
	public void fromBytes(ByteBuf buf) {
		player = ByteBufUtils.readUTF8String(buf);
		ac_level = buf.readByte();
		ac_class = buf.readByte();
		cp = buf.readInt();
		length = buf.readByte();
		for(int i = 0;i < length;i++){
			skill_open[i] = buf.readBoolean();
		}
		length = buf.readByte();
		for(int i = 0;i < length;i++){
			skill_exp[i] = buf.readByte();
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, player);			
		buf.writeByte(ac_level);
		buf.writeByte(ac_class);
		buf.writeInt(cp);
		buf.writeByte(skill_open.length);
		for(boolean i:skill_open){
			buf.writeBoolean(i);
		}
		buf.writeByte(skill_exp.length);
		for(float i:skill_exp){
			buf.writeFloat(i);
		}
	}

	public static class Handler implements IMessageHandler<ClientOccasionalSync, IMessage> {

		@Override
		public IMessage onMessage(ClientOccasionalSync message, MessageContext ctx) {
			System.out.println("Retrived controlChange message from client");
			//我咋知道做啥QAQ
			//EntityPlayer player = ctx.getServerHandler().playerEntity;
			//APControlMain.onSkillKeyChanged(player, message.ability_id, message.key_id, message.downOrUp);
			return null;
		}

	}

}

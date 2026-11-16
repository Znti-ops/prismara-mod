package dev.prismara.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;

import dev.prismara.CodexItem;

public class PrismaraClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		CodexItem.openHook = player -> Minecraft.getInstance().gui.setScreen(new CodexScreen());
	}
}

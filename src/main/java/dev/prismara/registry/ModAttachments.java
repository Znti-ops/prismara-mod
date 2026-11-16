package dev.prismara.registry;

import com.mojang.serialization.Codec;

import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;

import dev.prismara.PrismaraMod;

public final class ModAttachments {
	/**
	 * true cuando al jugador ya se le entregó el Códice.
	 * persistent: se guarda en el mundo. copyOnDeath: sobrevive a la muerte, así no se regala otra vez.
	 */
	public static final AttachmentType<Boolean> CODEX_GIVEN = AttachmentRegistry.create(
			PrismaraMod.id("codex_given"),
			builder -> builder
					.initializer(() -> false)
					.persistent(Codec.BOOL)
					.copyOnDeath());

	public static void init() {
	}

	private ModAttachments() {
	}
}

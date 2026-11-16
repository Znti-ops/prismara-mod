package dev.prismara.client;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/** Pantalla del Códice: lista de capítulos a la izquierda, texto a la derecha. */
public class CodexScreen extends Screen {
	private static final String[] CHAPTERS = {"welcome", "prismite", "realm", "creatures", "gear"};
	private static final int PANEL_W = 320;
	private static final int PANEL_H = 220;

	private static final int COL_PANEL = 0xE61A0B2E;
	private static final int COL_SIDE = 0xE60F0620;
	private static final int COL_EDGE = 0xFFB65CFF;
	private static final int COL_TITLE = 0xFF3DF2FF;
	private static final int COL_TEXT = 0xFFEDE6FF;

	private int selected = 0;

	public CodexScreen() {
		super(Component.translatable("item.prismara.prismara_codex"));
	}

	@Override
	protected void init() {
		int left = this.width / 2 - PANEL_W / 2;
		int top = this.height / 2 - PANEL_H / 2;

		for (int i = 0; i < CHAPTERS.length; i++) {
			final int index = i;
			this.addRenderableWidget(Button.builder(
							Component.translatable("prismara.codex." + CHAPTERS[i] + ".title"),
							button -> this.selected = index)
					.pos(left + 8, top + 30 + i * 24)
					.size(96, 20)
					.build());
		}

		this.addRenderableWidget(Button.builder(Component.translatable("gui.done"), button -> this.onClose())
				.pos(this.width / 2 - 50, top + PANEL_H - 26)
				.size(100, 20)
				.build());
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
		this.extractBackground(graphics, mouseX, mouseY, delta);

		int left = this.width / 2 - PANEL_W / 2;
		int top = this.height / 2 - PANEL_H / 2;

		// Marco y paneles
		graphics.fill(left - 2, top - 2, left + PANEL_W + 2, top + PANEL_H + 2, COL_EDGE);
		graphics.fill(left, top, left + PANEL_W, top + PANEL_H, COL_PANEL);
		graphics.fill(left, top, left + 112, top + PANEL_H, COL_SIDE);

		// Botones
		super.extractRenderState(graphics, mouseX, mouseY, delta);

		// Textos (encima de todo)
		graphics.text(this.font, this.title.getString(), left + 8, top + 10, COL_TITLE);

		String key = CHAPTERS[this.selected];
		graphics.text(this.font, Component.translatable("prismara.codex." + key + ".title").getString(), left + 122, top + 10, COL_TITLE);

		List<String> lines = wrap(Component.translatable("prismara.codex." + key + ".body").getString(), PANEL_W - 134);
		int y = top + 30;
		for (String line : lines) {
			graphics.text(this.font, line, left + 122, y, COL_TEXT);
			y += this.font.lineHeight + 2;
		}
	}

	/** Parte el texto por palabras para que quepa en maxWidth píxeles. */
	private List<String> wrap(String text, int maxWidth) {
		List<String> out = new ArrayList<>();
		for (String paragraph : text.split("\n")) {
			StringBuilder line = new StringBuilder();
			for (String word : paragraph.split(" ")) {
				String candidate = line.isEmpty() ? word : line + " " + word;
				if (this.font.width(Component.literal(candidate)) > maxWidth && !line.isEmpty()) {
					out.add(line.toString());
					line = new StringBuilder(word);
				} else {
					line = new StringBuilder(candidate);
				}
			}
			out.add(line.toString());
		}
		return out;
	}
}

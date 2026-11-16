package dev.prismara;

import java.util.function.Consumer;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

/** El Códice de Prismara. En el lado cliente abre la pantalla mediante un gancho que registra el cliente. */
public class CodexItem extends Item {
	/** Lo reemplaza PrismaraClient al iniciar; en servidor dedicado nunca se usa. */
	public static volatile Consumer<Player> openHook = player -> { };

	public CodexItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(Level level, Player user, InteractionHand hand) {
		if (level.isClientSide()) {
			openHook.accept(user);
		}

		return InteractionResult.SUCCESS;
	}
}

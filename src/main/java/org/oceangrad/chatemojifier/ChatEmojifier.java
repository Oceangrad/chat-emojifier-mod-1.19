package org.oceangrad.chatemojifier;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.slf4j.Logger;

@Mod(ChatEmojifier.MODID)
public class ChatEmojifier {
    public static final String MODID = "chatemoji";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static EmojiState state;

    public ChatEmojifier() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(ChatEvent.class);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.config);

        Config.loadConfig(Config.config, FMLPaths.CONFIGDIR.get().resolve("chatemoji-client.toml").toString());

        state = (EmojiState)Config.emojiState.get();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        Emojify emojify = new Emojify();
    }
}

package org.oceangrad.chatemojifier;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.File;

@Mod.EventBusSubscriber
public class Config {
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec config;

    public static ForgeConfigSpec.EnumValue emojiState;

    public static  void init(ForgeConfigSpec.Builder builder, EmojiState state){
        emojiState = builder
                .comment("Emoji State that decides, do you want to emojify your chat or not.")
                .defineEnum("emojiState.state", state);
    }

    static {
        init(builder, EmojiState.NONE);

        config = builder.build();
    }
    public static void loadConfig(ForgeConfigSpec config, String path){
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }
    @Mod.EventBusSubscriber(modid = ChatEmojifier.MODID)
    public static class PlayerLogEventListener{
        @SubscribeEvent
        public static void PlayerLogOff(PlayerEvent.PlayerLoggedOutEvent event){
            Config.emojiState.set(ChatEmojifier.state);
        }
    }
}

package org.oceangrad.chatemojifier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class KeyBindEvent {
    @Mod.EventBusSubscriber(modid = ChatEmojifier.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientKeyRegistrator{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.STATE_CHANGING_KEY);
        }
    }
    @Mod.EventBusSubscriber(modid = ChatEmojifier.MODID, value = Dist.CLIENT)
    public static class ClientKeyBinder{
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
            if(KeyBinding.STATE_CHANGING_KEY.consumeClick()){
                ChatEmojifier.state = EmojiState.getStateByID(ChatEmojifier.state.getID() + 1);
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Emojifier State changed to " + ChatEmojifier.state.name()));
            }
        }
    }
}

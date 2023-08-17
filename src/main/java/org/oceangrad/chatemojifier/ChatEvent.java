package org.oceangrad.chatemojifier;

import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ChatEvent {
    @Mod.EventBusSubscriber(modid = ChatEmojifier.MODID)
    public static class ForgeEvents{

        @SubscribeEvent
        public static void PlayerSendMessage(ClientChatEvent event){
            event.setMessage(Emojify.GetEmojifiedString(event.getMessage(), ChatEmojifier.state));
        }

    }
}

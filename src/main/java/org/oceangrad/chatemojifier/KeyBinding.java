package org.oceangrad.chatemojifier;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY = "key.category.emojifier.emoji";
    public static final String CHANGE_EMOJI_STATE_KEY = "key.emojifier.changestate";

    public static final KeyMapping STATE_CHANGING_KEY = new KeyMapping(CHANGE_EMOJI_STATE_KEY, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_N, KEY_CATEGORY);
}

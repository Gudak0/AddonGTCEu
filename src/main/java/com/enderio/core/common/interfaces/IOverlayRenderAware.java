package com.enderio.core.common.interfaces;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

/*
 * This code was taken from EnderCore. I have changed nothing. Why is it here? For some dumb fucking reason I cannot register items 
 * like how GregTech CEu does it unless this class is present.
 * 
 * I could have made EnderIO/EnderCore a required dependency but simply adding this class fixes the issue. Again, I don't know why, 
 * and I don't want to know why, but this class file HAS to be present or items WILL NOT work.
 * TODO: fix this weird anomaly? or report this as a bug to GTCEu
 */

public interface IOverlayRenderAware {
    public void renderItemOverlayIntoGUI(@Nonnull ItemStack stack, int xPosition, int yPosition);
}
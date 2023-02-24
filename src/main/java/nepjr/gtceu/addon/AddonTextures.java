package nepjr.gtceu.addon;

import codechicken.lib.render.BlockRenderer.BlockFace;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.texture.TextureUtils.IIconRegister;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Matrix4;
import codechicken.lib.vec.TransformationList;
import codechicken.lib.vec.uv.IconTransformation;
import codechicken.lib.vec.uv.UVTransformationList;
import gregtech.api.GTValues;
import gregtech.api.util.GTLog;
import gregtech.client.renderer.CubeRendererState;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.cclop.UVMirror;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.*;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace;
import gregtech.client.renderer.texture.custom.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace.*;

@Mod.EventBusSubscriber(modid = NepJrAddon.MODID, value = Side.CLIENT)
public class AddonTextures
{
	public static final SimpleSidedCubeRenderer[] SPACE_VOLTAGE_CASINGS = new SimpleSidedCubeRenderer[GTValues.V.length];

    public static void preInit()
    {
        for (int i = 0; i < SPACE_VOLTAGE_CASINGS.length; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            SPACE_VOLTAGE_CASINGS[i] = new SimpleSidedCubeRenderer("casings/voltage/space/" + voltageName);   
        }
    }
}

package nepjr.gtceu.addon.tile.multi.io;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.PipelineUtil;
import gregtech.common.ConfigHolder;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockPart;
import nepjr.gtceu.addon.tile.AddonMetaTileEntitiesUHV;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class AddonMultiblockIOEnergy extends MetaTileEntityMultiblockPart implements IMultiblockAbilityPart<IEnergyContainer> {

    private final boolean isExportHatch;
    private final IEnergyContainer energyContainer;

    public AddonMultiblockIOEnergy(ResourceLocation metaTileEntityId, boolean isExportHatch) {
        super(metaTileEntityId, 14);
        this.isExportHatch = isExportHatch;
        if (isExportHatch) {
            this.energyContainer = EnergyContainerHandler.emitterContainer(this, Long.MAX_VALUE, Long.MAX_VALUE, 1);
            ((EnergyContainerHandler) this.energyContainer).setSideOutputCondition(s -> s == getFrontFacing());
        } else {
            this.energyContainer = EnergyContainerHandler.receiverContainer(this, Long.MAX_VALUE, Long.MAX_VALUE, 1);
        }
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new AddonMultiblockIOEnergy(metaTileEntityId, isExportHatch);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        if (shouldRenderOverlay()) {
            getOverlay().renderSided(getFrontFacing(), renderState, translation, PipelineUtil.color(pipeline, GTValues.VC[getTier()]));
        }
    }

    @Override
    public void update() {
        super.update();
        checkWeatherOrTerrainExplosion(getTier(), getTier() * 10, energyContainer);
    }

    @Nonnull
    private SimpleOverlayRenderer getOverlay() {
        if (isExportHatch) {
                return Textures.ENERGY_OUT_ULTRA;
            }
                return Textures.ENERGY_IN_ULTRA;
        }

    @Override
    public MultiblockAbility<IEnergyContainer> getAbility() {
        return isExportHatch ? MultiblockAbility.OUTPUT_ENERGY : MultiblockAbility.INPUT_ENERGY;
    }

    @Override
    public void registerAbilities(List<IEnergyContainer> abilityList) {
        abilityList.add(energyContainer);
    }

    @Override
    protected boolean openGUIOnRightClick() {
        return false;
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        String tierName = GTValues.VNF[getTier()];

        if (isExportHatch) {
            tooltip.add(I18n.format("gregtech.machine.energy_hatch.output.tooltip"));
            tooltip.add(I18n.format("gregtech.universal.tooltip.voltage_out", energyContainer.getOutputVoltage(), tierName));
            tooltip.add(I18n.format("gregtech.universal.tooltip.amperage_out_till", energyContainer.getOutputAmperage()));
        } else {
                tooltip.add(I18n.format("gregtech.machine.energy_hatch.input.tooltip"));
            tooltip.add(I18n.format("gregtech.universal.tooltip.voltage_in", energyContainer.getInputVoltage(), tierName));
            tooltip.add(I18n.format("gregtech.universal.tooltip.amperage_in_till", energyContainer.getInputAmperage()));
        }
        tooltip.add(I18n.format("gregtech.universal.tooltip.energy_storage_capacity", energyContainer.getEnergyCapacity()));
        tooltip.add(I18n.format("gregtech.universal.enabled"));
    }

    @Override
    public boolean canRenderFrontFaceX() {
        return isExportHatch;
    }

    @Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) {
        // override here is gross, but keeps things in order despite
        // IDs being out of order, due to EV 4A hatches being added later
        if (this == AddonMetaTileEntitiesUHV.MEGA_ENERGY_INPUT_HATCH[0]) {
            for (AddonMultiblockIOEnergy hatch : AddonMetaTileEntitiesUHV.MEGA_ENERGY_INPUT_HATCH) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
            for (AddonMultiblockIOEnergy hatch : AddonMetaTileEntitiesUHV.MEGA_ENERGY_OUTPUT_HATCH) {
                if (hatch != null) subItems.add(hatch.getStackForm());
            }
        }
    }

    @Override
    public void doExplosion(float explosionPower) {
        if (getController() != null)
            getController().explodeMultiblock(explosionPower);
        else {
            super.doExplosion(explosionPower);
        }
    }
}
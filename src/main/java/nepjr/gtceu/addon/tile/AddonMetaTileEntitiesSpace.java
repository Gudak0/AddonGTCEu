package nepjr.gtceu.addon.tile;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

import java.util.function.Function;

import gregtech.GregTechMod;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.metatileentities.converter.MetaTileEntityConverter;
import gregtech.common.metatileentities.electric.MetaTileEntityHull;
import gregtech.common.metatileentities.electric.MetaTileEntityMacerator;
import gregtech.common.metatileentities.multi.electric.MetaTileEntityFusionReactor;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityFluidHatch;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityItemBus;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiFluidHatch;
import gregtech.integration.jei.multiblock.MultiblockInfoCategory;
import moze_intel.projecte.PECore;
import nepjr.gtceu.addon.NepJrAddon;
import nepjr.gtceu.addon.api.metatileentity.SimpleMachineSpaceMetaTileEntity;
import nepjr.gtceu.addon.config.ModConfig;
import nepjr.gtceu.addon.recipes.ModRecipeMaps;
import nepjr.gtceu.addon.tile.multi.elec.AddonMetaTileEntityFusionReactor;
import nepjr.gtceu.addon.tile.multi.elec.AddonMetaTileEntityResourceMiner;
import nepjr.gtceu.addon.tile.multi.io.AddonMultiblockIOEnergy;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import scala.actors.threadpool.Arrays;

public class AddonMetaTileEntitiesSpace 
{
	public static final MetaTileEntityHull[] SPACE_HULL = new MetaTileEntityHull[GTValues.V.length];
	
	//public static final long[] HVArray = Arrays.copyOfRange(GTValues.V, 8, 15);
	public static final MetaTileEntityMacerator[] SPACE_MACERATOR = new MetaTileEntityMacerator[GTValues.V.length];
	public static final SimpleMachineSpaceMetaTileEntity[] SPACE_ALLOY_SMELTER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_ARC_FURNACE = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_ASSEMBLER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_AUTOCLAVE = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_BENDER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_BREWERY = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_CANNER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_CENTRIFUGE = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_CHEMICAL_BATH = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_CHEMICAL_REACTOR = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_COMPRESSOR = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_CUTTER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_DISTILLERY = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_ELECTROLYZER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_ELECTROMAGNETIC_SEPARATOR = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_EXTRACTOR = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_EXTRUDER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_FERMENTER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_FLUID_HEATER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_FLUID_SOLIDIFIER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_FORGE_HAMMER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_FORMING_PRESS = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_LATHE = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_MIXER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_ORE_WASHER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_PACKER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_UNPACKER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_POLARIZER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_LASER_ENGRAVER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_SIFTER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_THERMAL_CENTRIFUGE = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_WIREMILL = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_CIRCUIT_ASSEMBLER = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
    
    public static final SimpleMachineSpaceMetaTileEntity[] SPACE_REPLICATOR = new SimpleMachineSpaceMetaTileEntity[GTValues.V.length];
	
    public static final MetaTileEntityItemBus[] SPACE_ITEM_IMPORT_BUS = new MetaTileEntityItemBus[GTValues.V.length - 2]; // ULV-UHV
    public static final MetaTileEntityItemBus[] SPACE_ITEM_EXPORT_BUS = new MetaTileEntityItemBus[GTValues.V.length - 2];
    public static final MetaTileEntityFluidHatch[] SPACE_FLUID_IMPORT_HATCH = new MetaTileEntityFluidHatch[GTValues.V.length - 2];
    public static final MetaTileEntityFluidHatch[] SPACE_FLUID_EXPORT_HATCH = new MetaTileEntityFluidHatch[GTValues.V.length - 2];
    // public static final MetaTileEntityMultiFluidHatch[] SPACE_MULTI_FLUID_IMPORT_HATCH = new MetaTileEntityMultiFluidHatch[2];
    // public static final MetaTileEntityMultiFluidHatch[] SPACE_MULTI_FLUID_EXPORT_HATCH = new MetaTileEntityMultiFluidHatch[2];
    
	public static void init()
	{
		SPACE_MACERATOR[1] =  MetaTileEntities.registerMetaTileEntity(16000, new MetaTileEntityMacerator(addonId("space_macerator.lv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 1));
		SPACE_MACERATOR[2] =  MetaTileEntities.registerMetaTileEntity(16001, new MetaTileEntityMacerator(addonId("space_macerator.mv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 2));
		SPACE_MACERATOR[3] =  MetaTileEntities.registerMetaTileEntity(16002, new MetaTileEntityMacerator(addonId("space_macerator.hv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 3));
		SPACE_MACERATOR[4] =  MetaTileEntities.registerMetaTileEntity(16003, new MetaTileEntityMacerator(addonId("space_macerator.ev"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 4));
		SPACE_MACERATOR[5] =  MetaTileEntities.registerMetaTileEntity(16004, new MetaTileEntityMacerator(addonId("space_macerator.iv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 5));
		SPACE_MACERATOR[6] =  MetaTileEntities.registerMetaTileEntity(16005, new MetaTileEntityMacerator(addonId("space_macerator.luv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 6));
		SPACE_MACERATOR[7] =  MetaTileEntities.registerMetaTileEntity(16006, new MetaTileEntityMacerator(addonId("space_macerator.zpm"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 7));
		SPACE_MACERATOR[8] =  MetaTileEntities.registerMetaTileEntity(16007, new MetaTileEntityMacerator(addonId("space_macerator.uv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 8));
		SPACE_MACERATOR[9] =  MetaTileEntities.registerMetaTileEntity(16008, new MetaTileEntityMacerator(addonId("space_macerator.uhv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 9));
		SPACE_MACERATOR[10] =  MetaTileEntities.registerMetaTileEntity(16009, new MetaTileEntityMacerator(addonId("space_macerator.uev"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 10));
		SPACE_MACERATOR[11] =  MetaTileEntities.registerMetaTileEntity(16010, new MetaTileEntityMacerator(addonId("space_macerator.uiv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 11));
		SPACE_MACERATOR[12] =  MetaTileEntities.registerMetaTileEntity(16011, new MetaTileEntityMacerator(addonId("space_macerator.uxv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 12));
		SPACE_MACERATOR[13] =  MetaTileEntities.registerMetaTileEntity(16012, new MetaTileEntityMacerator(addonId("space_macerator.opv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 13));
		SPACE_MACERATOR[14] =  MetaTileEntities.registerMetaTileEntity(16013, new MetaTileEntityMacerator(addonId("space_macerator.max"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 14));
        
        registerSimpleMetaTileEntity(SPACE_ALLOY_SMELTER, 16014, "space_alloy_smelter", ModRecipeMaps.SPACE_ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, true);
        
        // Arc Furnace, IDs 95-109
        registerSimpleMetaTileEntity(SPACE_ARC_FURNACE, 16028, "space_arc_furnace", RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, false, GTUtility.hvCappedTankSizeFunction);

        // Assembler, IDs 110-124
        registerSimpleMetaTileEntity(SPACE_ASSEMBLER, 16042, "space_assembler", RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Autoclave, IDs 125-139
        registerSimpleMetaTileEntity(SPACE_AUTOCLAVE, 16056, "space_autoclave", RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, false, GTUtility.hvCappedTankSizeFunction);

        // Bender, IDs 140-154
        registerSimpleMetaTileEntity(SPACE_BENDER, 16070, "space_bender", RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, true);

        // Brewery, IDs 155-169
        registerSimpleMetaTileEntity(SPACE_BREWERY, 16084, "space_brewery", RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Canner, IDs 170-184
        registerSimpleMetaTileEntity(SPACE_CANNER, 16098, "space_canner", RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, true);

        // Centrifuge, IDs 185-199
        registerSimpleMetaTileEntity(SPACE_CENTRIFUGE, 16112, "space_centrifuge", RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, false, GTUtility.largeTankSizeFunction);

        // Chemical Bath, IDs 200-214
        registerSimpleMetaTileEntity(SPACE_CHEMICAL_BATH, 16126, "space_chemical_bath", RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Chemical Reactor, IDs 215-229
        registerSimpleMetaTileEntity(SPACE_CHEMICAL_REACTOR, 16140, "space_chemical_reactor", ModRecipeMaps.SPACE_CHEMICAL_REACTOR, Textures.CHEMICAL_REACTOR_OVERLAY, true, tier -> 16000);

        // Compressor, IDs 230-244
        registerSimpleMetaTileEntity(SPACE_COMPRESSOR, 16154, "space_compressor", RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, true);

        // Cutter, IDs 245-259
        registerSimpleMetaTileEntity(SPACE_CUTTER, 16168, "space_cutter", RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, true);

        // Distillery, IDs 260-274
        registerSimpleMetaTileEntity(SPACE_DISTILLERY, 16182, "space_distillery", RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Electrolyzer, IDs 275-289
        registerSimpleMetaTileEntity(SPACE_ELECTROLYZER, 16196, "space_electrolyzer", RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, false, GTUtility.largeTankSizeFunction);

        // Electromagnetic Separator, IDs 290-304
        registerSimpleMetaTileEntity(SPACE_ELECTROMAGNETIC_SEPARATOR, 16210, "space_electromagnetic_separator", RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, true);

        // Extractor, IDs 305-319
        registerSimpleMetaTileEntity(SPACE_EXTRACTOR, 16224, "space_extractor", RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, true);

        // Extruder, IDs 320-334
        registerSimpleMetaTileEntity(SPACE_EXTRUDER, 16238, "space_extruder", RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, true);

        // Fermenter, IDs 335-349
        registerSimpleMetaTileEntity(SPACE_FERMENTER, 16252, "space_fermenter", RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // TODO Replication system
        // Mass Fabricator, IDs 350-364
        //registerSimpleMetaTileEntity(SPACE_MASS_FABRICATOR, 16266, "space_mass_fabricator", RecipeMaps.MASS_FABRICATOR_RECIPES, Textures.MASS_FABRICATOR_OVERLAY, true);

        // TODO Should anonymously override SimpleMachineSpaceMetaTileEntity#getCircuitSlotOverlay() to display the data stick overlay
        // Replicator, IDs 365-379
        // registerSimpleMetaTileEntity(SPACE_REPLICATOR, 16280, "space_replicator", RecipeMaps.REPLICATOR_RECIPES, Textures.REPLICATOR_OVERLAY, true);

        // Fluid Heater, IDs 380-394
        registerSimpleMetaTileEntity(SPACE_FLUID_HEATER, 16294, "space_fluid_heater", RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Fluid Solidifier, IDs 395-409
        registerSimpleMetaTileEntity(SPACE_FLUID_SOLIDIFIER, 16308, "space_fluid_solidifier", RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Forge Hammer, IDs 410-424
        registerSimpleMetaTileEntity(SPACE_FORGE_HAMMER, 16322, "space_forge_hammer", RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, true);

        // Forming Press, IDs 425-439
        registerSimpleMetaTileEntity(SPACE_FORMING_PRESS, 16336, "space_forming_press", RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, true);

        // Lathe, IDs 440-454
        registerSimpleMetaTileEntity(SPACE_LATHE, 16350, "space_lathe", RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, true);

        // TODO Assembly Line Research system
        // TODO Should anonymously override SimpleMachineSpaceMetaTileEntity#getCircuitSlotOverlay() to display the data stick overlay
        // Scanner, IDs 455-469
        //registerSimpleMetaTileEntity(SCANNER, 16364, "space_scanner", RecipeMaps.SCANNER_RECIPES, Textures.SCANNER_OVERLAY, true);

        // Mixer, IDs 470-484
        registerSimpleMetaTileEntity(SPACE_MIXER, 16378, "space_mixer", RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, false, GTUtility.hvCappedTankSizeFunction);

        // Ore Washer, IDs 485-499
        registerSimpleMetaTileEntity(SPACE_ORE_WASHER, 16392, "space_ore_washer", RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, true);

        // Packer, IDs 500-514
        registerSimpleMetaTileEntity(SPACE_PACKER, 16406, "space_packer", RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, true);

        // FREE, IDs 515-529

        // Polarizer, IDs 545-559
        registerSimpleMetaTileEntity(SPACE_POLARIZER, 16420, "space_polarizer", RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, true);

        // Laser Engraver, IDs 560-574
        registerSimpleMetaTileEntity(SPACE_LASER_ENGRAVER, 16434, "space_laser_engraver", RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, true);

        // Sifter, IDs 575-589
        registerSimpleMetaTileEntity(SPACE_SIFTER, 16448, "space_sifter", RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, true);

        // FREE, IDs 590-604

        // Thermal Centrifuge, IDs 605-619
        registerSimpleMetaTileEntity(SPACE_THERMAL_CENTRIFUGE, 16462, "space_thermal_centrifuge", RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, true);

        // Wire Mill, IDs 620-634
        registerSimpleMetaTileEntity(SPACE_WIREMILL, 16476, "space_wiremill", RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, true);

        // Circuit Assembler, IDs 650-664
        registerSimpleMetaTileEntity(SPACE_CIRCUIT_ASSEMBLER, 16490, "space_circuit_assembler", RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);
        
        for (int i = 8; i < SPACE_ITEM_IMPORT_BUS.length; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            SPACE_ITEM_IMPORT_BUS[i] = new MetaTileEntityItemBus(addonId("space_item_bus.import." + voltageName), i, false);
            SPACE_ITEM_EXPORT_BUS[i] = new MetaTileEntityItemBus(addonId("space_item_bus.export." + voltageName), i, true);
            SPACE_FLUID_IMPORT_HATCH[i] = new MetaTileEntityFluidHatch(addonId("space_fluid_hatch.import." + voltageName), i, false);
            SPACE_FLUID_EXPORT_HATCH[i] = new MetaTileEntityFluidHatch(addonId("space_fluid_hatch.export." + voltageName), i, true);

            // While the code to support it is here, Item busses only have a max of 100 slots
            // and would probably require some funky setup to get 100+ slots working with how GT does GUI stuff
            // and the liquids I would need to implement higher tier support manually
            // TODO: Make it so Higher Tier Fluid hatches store more liquids
            // TODO: Somehow implement a way where higher tier Item busses can store more items
            
            registerMetaTileEntity(16505 + i, SPACE_ITEM_IMPORT_BUS[i]);
            registerMetaTileEntity(16519 + i, SPACE_ITEM_EXPORT_BUS[i]);
            registerMetaTileEntity(16534 + i, SPACE_FLUID_IMPORT_HATCH[i]);
            registerMetaTileEntity(16549 + i, SPACE_FLUID_EXPORT_HATCH[i]);
        }
        
        // Hulls, IDs 985-999
        int endPos = !GTValues.HT ? SPACE_HULL.length : Math.min(SPACE_HULL.length, GTValues.V.length);
        for (int i = 0; i < endPos; i++) {
            SPACE_HULL[i] = new MetaTileEntityHull(addonId("space_hull." + GTValues.VN[i].toLowerCase()), i);
            registerMetaTileEntity(16564 + i, SPACE_HULL[i]);
        }
        
    	if(ModConfig.compat.projecteCompat && Loader.isModLoaded(PECore.MODID))
    	{
    		//registerSimpleMetaTileEntity(AddonMetaTileEntitiesLV.EMC_CREATOR, 16579, "space_emc_creator", ModRecipeMaps.EMC_MAKER, Textures.ASSEMBLER_OVERLAY, true, emcTank);
    		//registerSimpleMetaTileEntity(AddonMetaTileEntitiesLV.EMCER, 16594, "space_emcer", ModRecipeMaps.EMCER, Textures.ASSEMBLER_OVERLAY, true, emcTank);	
    	}
    	// This is the test dummy for recipes, this really shouldn't be enabled in release builds
    	//registerSimpleMetaTileEntity(AddonMetaTileEntitiesLV.TEST, 30500, "space_test", ModRecipeMaps.TEST, Textures.FERMENTER_OVERLAY, true);     
}	
	
	    private static void registerSimpleMetaTileEntity(SimpleMachineSpaceMetaTileEntity[] machines,
                                                    int startId,
                                                    String name,
                                                    RecipeMap<?> map,
                                                     ICubeRenderer texture,
                                                    boolean hasFrontFacing,
                                                    Function<Integer, Integer> tankScalingFunction) {
        registerSimpleMetaTileEntity(machines, startId, name, map, texture, hasFrontFacing, AddonMetaTileEntitiesSpace::addonId, tankScalingFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineSpaceMetaTileEntity[] machines,
                                                    int startId,
                                                    String name,
                                                    RecipeMap<?> map,
                                                     ICubeRenderer texture,
                                                    boolean hasFrontFacing) {
        registerSimpleMetaTileEntity(machines, startId, name, map, texture, hasFrontFacing, GTUtility.defaultTankSizeFunction);
    }

    public static void registerSimpleMetaTileEntity(SimpleMachineSpaceMetaTileEntity[] machines,
                                                    int startId,
                                                    String name,
                                                    RecipeMap<?> map,
                                                    ICubeRenderer texture,
                                                    boolean hasFrontFacing,
                                                    Function<String, ResourceLocation> resourceId,
                                                    Function<Integer, Integer> tankScalingFunction) {
    	for (int i = 0; i < machines.length - 1; i++) {

            String voltageName = GTValues.VN[i + 1].toLowerCase();
            machines[i + 1] = registerMetaTileEntity(startId + i,
                    new SimpleMachineSpaceMetaTileEntity(resourceId.apply(String.format("%s.%s", name, voltageName)), map, texture, i + 1, hasFrontFacing, tankScalingFunction));
        }
    }
    
    public static <T extends MetaTileEntity> T registerMetaTileEntity(int id, T sampleMetaTileEntity) {
        if (sampleMetaTileEntity instanceof IMultiblockAbilityPart) {
            IMultiblockAbilityPart<?> abilityPart = (IMultiblockAbilityPart<?>) sampleMetaTileEntity;
            MultiblockAbility.registerMultiblockAbility(abilityPart.getAbility(), sampleMetaTileEntity);
        }
        if (sampleMetaTileEntity instanceof MultiblockControllerBase && Loader.isModLoaded(GTValues.MODID_JEI)) {
            if (((MultiblockControllerBase) sampleMetaTileEntity).shouldShowInJei()) {
                MultiblockInfoCategory.registerMultiblock((MultiblockControllerBase) sampleMetaTileEntity);
            }
        }
        GregTechAPI.MTE_REGISTRY.register(id, sampleMetaTileEntity.metaTileEntityId, sampleMetaTileEntity);
        return sampleMetaTileEntity;
    }
	  
	  static ResourceLocation addonId(String name) {
	        return new ResourceLocation(NepJrAddon.MODID, name);
	    }
    public static final Function<Integer, Integer> megaCappedTankSizeFunction = tier -> {
	    	
	    	if (tier <= GTValues.OpV)
	    		return 262144;	    	
	        return 2147483647;
	    };
	    
	    public static final Function<Integer, Integer> megaLargeTankSizeFunction = tier -> {
	    	
	    	if (tier <= GTValues.OpV)
	    		return 524288;	    	
	        return 2147483647;
	    };
	    public static final Function<Integer, Integer> emcTank = tier -> {
	        return (int) GTValues.V[tier];
	    };
	    
	
}

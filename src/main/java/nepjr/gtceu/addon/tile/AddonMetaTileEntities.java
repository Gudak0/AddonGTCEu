package nepjr.gtceu.addon.tile;

import java.util.function.Function;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.metatileentities.electric.MetaTileEntityHull;
import gregtech.common.metatileentities.electric.MetaTileEntityMacerator;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityFluidHatch;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityItemBus;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiFluidHatch;
import gregtech.integration.jei.multiblock.MultiblockInfoCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import scala.actors.threadpool.Arrays;

public class AddonMetaTileEntities 
{
	public static final MetaTileEntityHull[] MOD_HULL = new MetaTileEntityHull[GTValues.V.length];
	
	//public static final long[] HVArray = Arrays.copyOfRange(GTValues.V, 8, 15);
	public static final MetaTileEntityMacerator[] MOD_MACERATOR = new MetaTileEntityMacerator[GTValues.V.length];
	public static final SimpleMachineMetaTileEntity[] MOD_ALLOY_SMELTER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_ARC_FURNACE = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_ASSEMBLER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_AUTOCLAVE = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_BENDER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_BREWERY = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_CANNER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_CENTRIFUGE = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_CHEMICAL_BATH = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_CHEMICAL_REACTOR = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_COMPRESSOR = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_CUTTER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_DISTILLERY = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_ELECTROLYZER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_ELECTROMAGNETIC_SEPARATOR = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_EXTRACTOR = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_EXTRUDER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_FERMENTER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_FLUID_HEATER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_FLUID_SOLIDIFIER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_FORGE_HAMMER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_FORMING_PRESS = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_LATHE = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_MIXER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_ORE_WASHER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_PACKER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_UNPACKER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_POLARIZER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_LASER_ENGRAVER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_SIFTER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_THERMAL_CENTRIFUGE = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_WIREMILL = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MOD_CIRCUIT_ASSEMBLER = new SimpleMachineMetaTileEntity[GTValues.V.length];
	
    public static final MetaTileEntityItemBus[] MOD_ITEM_IMPORT_BUS = new MetaTileEntityItemBus[GTValues.V.length - 2]; // ULV-UHV
    public static final MetaTileEntityItemBus[] MOD_ITEM_EXPORT_BUS = new MetaTileEntityItemBus[GTValues.V.length - 2];
    public static final MetaTileEntityFluidHatch[] MOD_FLUID_IMPORT_HATCH = new MetaTileEntityFluidHatch[GTValues.V.length - 2];
    public static final MetaTileEntityFluidHatch[] MOD_FLUID_EXPORT_HATCH = new MetaTileEntityFluidHatch[GTValues.V.length - 2];
    // public static final MetaTileEntityMultiFluidHatch[] MOD_MULTI_FLUID_IMPORT_HATCH = new MetaTileEntityMultiFluidHatch[2];
    // public static final MetaTileEntityMultiFluidHatch[] MOD_MULTI_FLUID_EXPORT_HATCH = new MetaTileEntityMultiFluidHatch[2];
    public static final MetaTileEntityEnergyHatch[] MOD_ENERGY_INPUT_HATCH = new MetaTileEntityEnergyHatch[GTValues.V.length];
    public static final MetaTileEntityEnergyHatch[] MOD_ENERGY_INPUT_HATCH_4A = new MetaTileEntityEnergyHatch[GTValues.V.length]; // EV, IV, LuV, ZPM, UV, UHV
    public static final MetaTileEntityEnergyHatch[] MOD_ENERGY_INPUT_HATCH_16A = new MetaTileEntityEnergyHatch[GTValues.V.length]; // IV, LuV, ZPM, UV, UHV
    public static final MetaTileEntityEnergyHatch[] MOD_ENERGY_OUTPUT_HATCH = new MetaTileEntityEnergyHatch[GTValues.V.length];
    public static final MetaTileEntityEnergyHatch[] MOD_ENERGY_OUTPUT_HATCH_4A = new MetaTileEntityEnergyHatch[GTValues.V.length]; // EV, IV, LuV, ZPM, UV, UHV
    public static final MetaTileEntityEnergyHatch[] MOD_ENERGY_OUTPUT_HATCH_16A = new MetaTileEntityEnergyHatch[GTValues.V.length]; // IV, LuV, ZPM, UV, UHV
    
	public static void init()
	{
		MOD_MACERATOR[9] =  MetaTileEntities.registerMetaTileEntity(11500, new MetaTileEntityMacerator(gregtechId("macerator.uhv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 9));
        MOD_MACERATOR[10] = MetaTileEntities.registerMetaTileEntity(11501, new MetaTileEntityMacerator(gregtechId("macerator.uev"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 10));
        MOD_MACERATOR[11] = MetaTileEntities.registerMetaTileEntity(11502, new MetaTileEntityMacerator(gregtechId("macerator.uiv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 11));
        MOD_MACERATOR[12] = MetaTileEntities.registerMetaTileEntity(11503, new MetaTileEntityMacerator(gregtechId("macerator.uxv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 12));
        MOD_MACERATOR[13] = MetaTileEntities.registerMetaTileEntity(11504, new MetaTileEntityMacerator(gregtechId("macerator.opv"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 13));
        MOD_MACERATOR[14] = MetaTileEntities.registerMetaTileEntity(11505, new MetaTileEntityMacerator(gregtechId("macerator.max"), RecipeMaps.MACERATOR_RECIPES, 4, Textures.PULVERIZER_OVERLAY, 14));
        
        registerSimpleMetaTileEntity(MOD_ALLOY_SMELTER, 11506, "alloy_smelter", RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, true);
        
        // Arc Furnace, IDs 95-109
        registerSimpleMetaTileEntity(MOD_ARC_FURNACE, 11512, "arc_furnace", RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, false, megaCappedTankSizeFunction);

        // Assembler, IDs 110-124
        registerSimpleMetaTileEntity(MOD_ASSEMBLER, 11518, "assembler", RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, true, megaCappedTankSizeFunction);

        // Autoclave, IDs 125-139
        registerSimpleMetaTileEntity(MOD_AUTOCLAVE, 11524, "autoclave", RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, false, megaCappedTankSizeFunction);

        // Bender, IDs 140-154
        registerSimpleMetaTileEntity(MOD_BENDER, 11530, "bender", RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, true);

        // Brewery, IDs 155-169
        registerSimpleMetaTileEntity(MOD_BREWERY, 11536, "brewery", RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, true, megaCappedTankSizeFunction);

        // Canner, IDs 170-184
        registerSimpleMetaTileEntity(MOD_CANNER, 11542, "canner", RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, true);

        // Centrifuge, IDs 185-199
        registerSimpleMetaTileEntity(MOD_CENTRIFUGE, 11548, "centrifuge", RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, false, megaLargeTankSizeFunction);

        // Chemical Bath, IDs 200-214
        registerSimpleMetaTileEntity(MOD_CHEMICAL_BATH, 11554, "chemical_bath", RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, true, megaCappedTankSizeFunction);

        // Chemical Reactor, IDs 215-229
        registerSimpleMetaTileEntity(MOD_CHEMICAL_REACTOR, 11560, "chemical_reactor", RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, true, tier -> 2147483647);

        // Compressor, IDs 230-244
        registerSimpleMetaTileEntity(MOD_COMPRESSOR, 11566, "compressor", RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, true);

        // Cutter, IDs 245-259
        registerSimpleMetaTileEntity(MOD_CUTTER, 11572, "cutter", RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, true);

        // Distillery, IDs 260-274
        registerSimpleMetaTileEntity(MOD_DISTILLERY, 11578, "distillery", RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, true, megaCappedTankSizeFunction);

        // Electrolyzer, IDs 275-289
        registerSimpleMetaTileEntity(MOD_ELECTROLYZER, 11584, "electrolyzer", RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, false, megaLargeTankSizeFunction);

        // Electromagnetic Separator, IDs 290-304
        registerSimpleMetaTileEntity(MOD_ELECTROMAGNETIC_SEPARATOR, 11590, "electromagnetic_separator", RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, true);

        // Extractor, IDs 305-319
        registerSimpleMetaTileEntity(MOD_EXTRACTOR, 11596, "extractor", RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, true);

        // Extruder, IDs 320-334
        registerSimpleMetaTileEntity(MOD_EXTRUDER, 11602, "extruder", RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, true);

        // Fermenter, IDs 335-349
        registerSimpleMetaTileEntity(MOD_FERMENTER, 11608, "fermenter", RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, true, megaCappedTankSizeFunction);

        // TODO Replication system
        // Mass Fabricator, IDs 350-364
        //registerSimpleMetaTileEntity(MOD_MASS_FABRICATOR, 11612, "mass_fabricator", RecipeMaps.MASS_FABRICATOR_RECIPES, Textures.MASS_FABRICATOR_OVERLAY, true);

        // TODO Should anonymously override SimpleMachineMetaTileEntity#getCircuitSlotOverlay() to display the data stick overlay
        // Replicator, IDs 365-379
        //registerSimpleMetaTileEntity(MOD_REPLICATOR, 11618, "replicator", RecipeMaps.REPLICATOR_RECIPES, Textures.REPLICATOR_OVERLAY, true);

        // Fluid Heater, IDs 380-394
        registerSimpleMetaTileEntity(MOD_FLUID_HEATER, 11624, "fluid_heater", RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, true, megaCappedTankSizeFunction);

        // Fluid Solidifier, IDs 395-409
        registerSimpleMetaTileEntity(MOD_FLUID_SOLIDIFIER, 11630, "fluid_solidifier", RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, true, megaCappedTankSizeFunction);

        // Forge Hammer, IDs 410-424
        registerSimpleMetaTileEntity(MOD_FORGE_HAMMER, 11636, "forge_hammer", RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, true);

        // Forming Press, IDs 425-439
        registerSimpleMetaTileEntity(MOD_FORMING_PRESS, 11642, "forming_press", RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, true);

        // Lathe, IDs 440-454
        registerSimpleMetaTileEntity(MOD_LATHE, 11648, "lathe", RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, true);

        // TODO Assembly Line Research system
        // TODO Should anonymously override SimpleMachineMetaTileEntity#getCircuitSlotOverlay() to display the data stick overlay
        // Scanner, IDs 455-469
        //registerSimpleMetaTileEntity(SCANNER, 11654, "scanner", RecipeMaps.SCANNER_RECIPES, Textures.SCANNER_OVERLAY, true);

        // Mixer, IDs 470-484
        registerSimpleMetaTileEntity(MOD_MIXER, 11660, "mixer", RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, false, megaCappedTankSizeFunction);

        // Ore Washer, IDs 485-499
        registerSimpleMetaTileEntity(MOD_ORE_WASHER, 11666, "ore_washer", RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, true);

        // Packer, IDs 500-514
        registerSimpleMetaTileEntity(MOD_PACKER, 11672, "packer", RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, true);

        // FREE, IDs 515-529

        // Polarizer, IDs 545-559
        registerSimpleMetaTileEntity(MOD_POLARIZER, 11678, "polarizer", RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, true);

        // Laser Engraver, IDs 560-574
        registerSimpleMetaTileEntity(MOD_LASER_ENGRAVER, 11684, "laser_engraver", RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, true);

        // Sifter, IDs 575-589
        registerSimpleMetaTileEntity(MOD_SIFTER, 11690, "sifter", RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, true);

        // FREE, IDs 590-604

        // Thermal Centrifuge, IDs 605-619
        registerSimpleMetaTileEntity(MOD_THERMAL_CENTRIFUGE, 11696, "thermal_centrifuge", RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, true);

        // Wire Mill, IDs 620-634
        registerSimpleMetaTileEntity(MOD_WIREMILL, 11702, "wiremill", RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, true);

        // Circuit Assembler, IDs 650-664
        registerSimpleMetaTileEntity(MOD_CIRCUIT_ASSEMBLER, 11708, "circuit_assembler", RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, true, megaCappedTankSizeFunction);
        
        for (int i = 8; i < MOD_ITEM_IMPORT_BUS.length; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            MOD_ITEM_IMPORT_BUS[i] = new MetaTileEntityItemBus(gregtechId("item_bus.import." + voltageName), i, false);
            MOD_ITEM_EXPORT_BUS[i] = new MetaTileEntityItemBus(gregtechId("item_bus.export." + voltageName), i, true);
            MOD_FLUID_IMPORT_HATCH[i] = new MetaTileEntityFluidHatch(gregtechId("fluid_hatch.import." + voltageName), i, false);
            MOD_FLUID_EXPORT_HATCH[i] = new MetaTileEntityFluidHatch(gregtechId("fluid_hatch.export." + voltageName), i, true);

            // While the code to support it is here, these are currently disabled since Item busses only have a max of 100
            // and would require some funky setup to get 100+ slots working with how GT does GUI stuff
            // and the liquids I would need to implement higher tier support manually
            // TODO: Make it so Higher Tier Fluid hatches store more liquids
            // TODO: Somehow implement a way where higher tier Item busses can store more items
            
            //registerMetaTileEntity(11714 + i -8, MOD_ITEM_IMPORT_BUS[i]);
            //registerMetaTileEntity(11720 + i -8, MOD_ITEM_EXPORT_BUS[i]);
            //registerMetaTileEntity(11726 + i -8, MOD_FLUID_IMPORT_HATCH[i]);
            //registerMetaTileEntity(11732 + i -8, MOD_FLUID_EXPORT_HATCH[i]);
        }
        
        // Hulls, IDs 985-999
        int endPos = !GTValues.HT ? MOD_HULL.length : Math.min(MOD_HULL.length, GTValues.V.length);
        for (int i = 10; i < endPos; i++) {
            MOD_HULL[i] = new MetaTileEntityHull(gregtechId("hull." + GTValues.VN[i].toLowerCase()), i);
            registerMetaTileEntity(11736 + i -10, MOD_HULL[i]);
        }
        
        // Energy Input/Output Hatches, IDs 1210-1269
        endPos = !GTValues.HT ? MOD_ENERGY_INPUT_HATCH.length : Math.min(MOD_ENERGY_INPUT_HATCH.length, GTValues.V.length);
        for (int i = 10; i < endPos; i++) {
            String voltageName = GTValues.VN[i].toLowerCase();
            MOD_ENERGY_INPUT_HATCH[i] = registerMetaTileEntity(11742 + i -10, new MetaTileEntityEnergyHatch(gregtechId("energy_hatch.input." + voltageName), i, 2, false));
            MOD_ENERGY_OUTPUT_HATCH[i] = registerMetaTileEntity(11748 + i -10, new MetaTileEntityEnergyHatch(gregtechId("energy_hatch.output." + voltageName), i, 2, true));
            MOD_ENERGY_INPUT_HATCH_4A[i]   = registerMetaTileEntity(11754 + i -10, new MetaTileEntityEnergyHatch(gregtechId("energy_hatch.input_4a." + voltageName), i, 4, false));
            MOD_ENERGY_INPUT_HATCH_16A[i]  = registerMetaTileEntity(11760 + i -10, new MetaTileEntityEnergyHatch(gregtechId("energy_hatch.input_16a." + voltageName), i, 16, false));
            MOD_ENERGY_OUTPUT_HATCH_4A[i]  = registerMetaTileEntity(11766 + i -10, new MetaTileEntityEnergyHatch(gregtechId("energy_hatch.output_4a." + voltageName), i, 4, true));
            MOD_ENERGY_OUTPUT_HATCH_16A[i] = registerMetaTileEntity(11772 + i -10, new MetaTileEntityEnergyHatch(gregtechId("energy_hatch.output_16a." + voltageName), i, 16, true));

        }
	}	
	
	    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines,
                                                    int startId,
                                                    String name,
                                                    RecipeMap<?> map,
                                                     ICubeRenderer texture,
                                                    boolean hasFrontFacing,
                                                    Function<Integer, Integer> tankScalingFunction) {
        registerSimpleMetaTileEntity(machines, startId, name, map, texture, hasFrontFacing, AddonMetaTileEntities::gregtechId, tankScalingFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines,
                                                    int startId,
                                                    String name,
                                                    RecipeMap<?> map,
                                                     ICubeRenderer texture,
                                                    boolean hasFrontFacing) {
        registerSimpleMetaTileEntity(machines, startId, name, map, texture, hasFrontFacing, GTUtility.defaultTankSizeFunction);
    }

    public static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines,
                                                    int startId,
                                                    String name,
                                                    RecipeMap<?> map,
                                                    ICubeRenderer texture,
                                                    boolean hasFrontFacing,
                                                    Function<String, ResourceLocation> resourceId,
                                                    Function<Integer, Integer> tankScalingFunction) {
    	// A note to people editing/browsing this code:
        // Do not change i whatsoever. This makes it so every machine registered by this addon starts at UHV tier
    	// Since thats what this addon aims to do. Changing this value may cause problems, such as re-registering
    	// Existing tier of machines or just crashing the game. You have been warned
    	for (int i = 8; i < machines.length - 1; i++) {

            String voltageName = GTValues.VN[i + 1].toLowerCase();
            // Need to subtract startId by 8 then add i to make the metadata id in the game align with the startId
            machines[i] = registerMetaTileEntity(startId - 8 + i,
                    new SimpleMachineMetaTileEntity(resourceId.apply(String.format("%s.%s", name, voltageName)), map, texture, i + 1, hasFrontFacing, tankScalingFunction));
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

	  private static ResourceLocation gregtechId(String name) {
	        return new ResourceLocation(GTValues.MODID, name);
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
	
}

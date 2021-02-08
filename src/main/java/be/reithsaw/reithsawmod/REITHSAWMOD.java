package be.reithsaw.reithsawmod;

import be.reithsaw.reithsawmod.config.MalachiteHammerConfig;
import be.reithsaw.reithsawmod.data.HammerData;
import be.reithsaw.reithsawmod.init.block.ModBlocks;
import be.reithsaw.reithsawmod.init.items.ModItems;
import be.reithsaw.reithsawmod.item.ExtendedHammerItem;
import draylar.magna.api.optional.MagnaOptionals;
import draylar.staticcontent.StaticContent;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class REITHSAWMOD implements ModInitializer
{

    public static final String MODID = "reithsawmod";
    public static MalachiteHammerConfig CONFIG = AutoConfig.register(MalachiteHammerConfig.class, GsonConfigSerializer::new).getConfig();


    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
                new Identifier("reithsawmod", "general"),
                () -> new ItemStack(ModBlocks.MALACHITE_BLOCK));

    /* OVERWORLD
    private static ConfiguredFeature<?, ?> ORE_WOOL_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Blocks.WHITE_WOOL.getDefaultState(),
                    9)) // vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0, // bottom offset
                    0, // min y level
                    64))) // max y level
            .spreadHorizontally()
            .repeat(20); // number of veins per chunk

    /* NETHER
    private static ConfiguredFeature<?, ?> ORE_WOOL_NETHER = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_NETHER, // We use OreFeatureConfig.Rules.BASE_STONE_NETHER for nether
                    Blocks.WHITE_WOOL.getDefaultState(),
                    9))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    64)))
            .spreadHorizontally()
            .repeat(20);

    /* END */
    private static ConfiguredFeature<?, ?> ORE_WOOL_END = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE), // base block is endstone in the end biomes
                    ModBlocks.END_MALACHITE_ORE.getDefaultState(),
                    3))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    55)))
            .spreadHorizontally()
            .repeat(20);

    @Override
    public void onInitialize()
    {
        ModItems.registerAll();
        ModBlocks.INSTANCE.registerAll();

        /* HAMMER */

        MagnaOptionals.optInForCurse();
        StaticContent.load(id("hammers"), HammerData.class);
        registerCallbackHandlers();

        /* OVERWORLD

        RegistryKey<ConfiguredFeature<?, ?>> oreWoolOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("tutorial", "ore_wool_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreWoolOverworld.getValue(), ORE_WOOL_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreWoolOverworld);

        /* NETHER

        RegistryKey<ConfiguredFeature<?, ?>> oreWoolNether = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("tutorial", "ore_wool_nether"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreWoolNether.getValue(), ORE_WOOL_NETHER);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, oreWoolNether);

        /* END */
        RegistryKey<ConfiguredFeature<?, ?>> oreWoolEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("tutorial", "ore_wool_end"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreWoolEnd.getValue(), ORE_WOOL_END);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreWoolEnd);

    }

    private void registerCallbackHandlers() {
        AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
            ItemStack handStack = playerEntity.getMainHandStack();
            if(handStack.getItem() instanceof ExtendedHammerItem) {
                ExtendedHammerItem extendedHammerItem = (ExtendedHammerItem) handStack.getItem();

                // set entity on fire if this hammer smelts blocks
                if(extendedHammerItem.getData().canSmelt()) {
                    entity.setOnFireFor(4);
                }
            }

            return ActionResult.PASS;
        });
    }

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }

}

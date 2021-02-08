package be.reithsaw.reithsawmod.init.block;

import be.reithsaw.reithsawmod.REITHSAWMOD;
import be.reithsaw.reithsawmod.init.items.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks
{
    public static final ModBlocks INSTANCE = new ModBlocks();

    public static final Block MALACHITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 4).requiresTool().strength(15f, 30));

    public static final Block MALACHITE_ORE = new Block(FabricBlockSettings.of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 4).requiresTool().strength(10f, 20f));

    public static final Block END_MALACHITE_ORE = new Block(FabricBlockSettings.of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 4).requiresTool().strength(10f, 20f));

    public void registerAll()
    {
        register(MALACHITE_BLOCK, new Identifier(REITHSAWMOD.MODID, "malachite_block"));
        //register(MALACHITE_ORE, new Identifier(REITHSAWMOD.MODID, "malachite_ore"));
        register(END_MALACHITE_ORE, new Identifier(REITHSAWMOD.MODID, "end_malachite_ore"));
    }

    private void register(Block block, Identifier name)
    {
        Registry.register(Registry.BLOCK, name, block);
        createBlockItem(block, name);
    }

    private void createBlockItem(Block block, Identifier name)
    {
        Registry.register(Registry.ITEM, name, new BlockItem(block, new Item.Settings().group(REITHSAWMOD.ITEM_GROUP)));
    }
}

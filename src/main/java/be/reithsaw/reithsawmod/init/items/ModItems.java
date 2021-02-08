package be.reithsaw.reithsawmod.init.items;

import be.reithsaw.reithsawmod.REITHSAWMOD;
import be.reithsaw.reithsawmod.init.armormaterials.MalachiteArmorMaterial;
import be.reithsaw.reithsawmod.toolmaterials.MalachiteToolMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems
{
    public static final Item MALACHITE_INGOT = new Item(new Item.Settings().group(REITHSAWMOD.ITEM_GROUP));
    public static final Item MALACHITE_STICK = new Item(new Item.Settings().group(REITHSAWMOD.ITEM_GROUP));

    /* TOOLS */

    public static final Item MALACHITE_SHOVEL =
            new ShovelItem(MalachiteToolMaterial.INSTANCE, 1.0f, -2.5f, new Item.Settings().maxDamage(4083).group(REITHSAWMOD.ITEM_GROUP));

    public static final Item MALACHITE_SWORD =
            new SwordItem(MalachiteToolMaterial.INSTANCE, 5, -2f, new Item.Settings().maxDamage(4083).group(REITHSAWMOD.ITEM_GROUP));

    public static ToolItem MALACHITE_PICKAXE =
            new CustomPickaxeItem(MalachiteToolMaterial.INSTANCE,1, -2.8F, new Item.Settings().group(REITHSAWMOD.ITEM_GROUP));

    public static ToolItem MALACHITE_AXE =
            new CustomAxeItem(MalachiteToolMaterial.INSTANCE, 5, -2f, new Item.Settings().maxDamage(4083).group(REITHSAWMOD.ITEM_GROUP));

    public static ToolItem MALACHITE_HOE =
            new CustomHoeItem(MalachiteToolMaterial.INSTANCE, -5, 0.5f, new Item.Settings().maxDamage(4083).group(REITHSAWMOD.ITEM_GROUP));


    /* ARMOR */

    public static final ArmorMaterial customArmorMaterial = new MalachiteArmorMaterial();

    public static final Item MALACHITE_HELMET =
            new ArmorItem(MalachiteArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().maxDamage(814).group(REITHSAWMOD.ITEM_GROUP));

    public static final Item MALACHITE_CHESTPLATE =
            new ArmorItem(MalachiteArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().maxDamage(1086).group(REITHSAWMOD.ITEM_GROUP));

    public static final Item MALACHITE_LEGGINGS =
            new ArmorItem(MalachiteArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().maxDamage(1003).group(REITHSAWMOD.ITEM_GROUP));

    public static final Item MALACHITE_BOOTS =
            new ArmorItem(MalachiteArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().maxDamage(846).group(REITHSAWMOD.ITEM_GROUP));


    public static void registerAll()
    {
        Registry.register( Registry.ITEM, new Identifier(REITHSAWMOD.MODID, "malachite_ingot"), MALACHITE_INGOT );
        Registry.register( Registry.ITEM, new Identifier(REITHSAWMOD.MODID, "malachite_stick"), MALACHITE_STICK );

        Registry.register( Registry.ITEM, new Identifier(REITHSAWMOD.MODID, "malachite_sword"), MALACHITE_SWORD );
        Registry.register( Registry.ITEM, new Identifier(REITHSAWMOD.MODID, "malachite_shovel"), MALACHITE_SHOVEL );
        Registry.register( Registry.ITEM, new Identifier(REITHSAWMOD.MODID, "malachite_pickaxe"), MALACHITE_PICKAXE );
        Registry.register( Registry.ITEM, new Identifier(REITHSAWMOD.MODID, "malachite_axe"), MALACHITE_AXE );
        Registry.register( Registry.ITEM, new Identifier(REITHSAWMOD.MODID, "malachite_hoe"), MALACHITE_HOE );

        Registry.register(Registry.ITEM, new Identifier(REITHSAWMOD.MODID, "malachite_helmet"), MALACHITE_HELMET);
        Registry.register(Registry.ITEM, new Identifier(REITHSAWMOD.MODID, "malachite_chestplate"), MALACHITE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(REITHSAWMOD.MODID, "malachite_leggings"), MALACHITE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(REITHSAWMOD.MODID, "malachite_boots"), MALACHITE_BOOTS);
    }

    public static class CustomPickaxeItem extends PickaxeItem
    {
        public CustomPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
        {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class CustomAxeItem extends AxeItem
    {
        public CustomAxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
        {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class CustomHoeItem extends HoeItem
    {
        public CustomHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
        {
            super(material, attackDamage, attackSpeed, settings);
        }
    }
}

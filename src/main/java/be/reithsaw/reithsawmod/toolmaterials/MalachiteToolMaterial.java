package be.reithsaw.reithsawmod.toolmaterials;

import be.reithsaw.reithsawmod.init.items.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MalachiteToolMaterial implements ToolMaterial
{
    public static final MalachiteToolMaterial INSTANCE = new MalachiteToolMaterial();

    @Override
    public int getDurability()
    {
        return 4064;
    }

    @Override
    public float getMiningSpeedMultiplier()
    {
        return 13.0f;
    }

    @Override
    public float getAttackDamage()
    {
        return 5f;
    }

    @Override
    public int getMiningLevel()
    {
        return 5;
    }

    @Override
    public int getEnchantability()
    {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.ofItems(ModItems.MALACHITE_INGOT);
    }

}

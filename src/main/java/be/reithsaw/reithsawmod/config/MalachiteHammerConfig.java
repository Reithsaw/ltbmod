package be.reithsaw.reithsawmod.config;


import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "vanilla-hammers")
public class MalachiteHammerConfig implements ConfigData {
    public boolean enableExtraMaterials = true;
    public int durabilityModifier = 1;
}
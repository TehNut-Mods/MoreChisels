package tehnut.morechisels.item;

import java.util.Locale;

import static tehnut.morechisels.ConfigHandler.*;

public enum ChiselType {

    BLOODY(durabilityBloody), BOUND(), // Blood Magic
    BEDROCKIUM(0), UNSTABLE(durabilityUnstable), // Extra Utilities
    FLUXED(), // RF
    CHEESE(durabilityCheese), DESH(durabilityDesh),
    IRONWOOD(durabilityIronwood), STEELEAF(durabilitySteeleaf), KNIGHTMETAL(durabilityKnightmetal), FIERY(durabilityFiery), // Twilight Forest
    MANASTEEL(durabilityManasteel), ELEMENTIUM(durabilityElementium), // Botania
    SKYROOT(durabilitySkyroot), HOLYSTONE(durabilityHolystone), ZANITE(durabilityZanite), GRAVITITE(durabilityGravitite), // Aether II
//    STEAMPOWERED(durabilitySteam), // Flaxbeard's Steam Power
    SOULIUM(durabilitySoulium), // Soul Shards: The Old Ways
    THAUMIUM(durabilityThaumium), VOIDMETAL(durabilityVoidmetal), // Thaumcraft
    NEPTUNIUM(durabilityNeptunium), // Aquaculture
    INFINITY(0), // Avaritia
    WALRUS(durabilityWalrus); // Extra Cells

    /**
     * Used for all types of durability (RF, EU, etc)
     */
    public final int durability;

    ChiselType(int dura) {
        this.durability = dura;
    }

    ChiselType() {
        this(100);
    }

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}

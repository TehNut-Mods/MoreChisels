package tehnut.morechisels.items;

import java.util.Locale;

import static tehnut.morechisels.ConfigHandler.*;

public enum ChiselType {

    BLOODY(durabilityBloody),
    BOUND(),
    BEDROCKIUM(durabilityBedrockium),
    FLUXED(),
    RUBY(durabilityRuby),
    SAPPHIRE(durabilitySapphire),
    EMERALD(durabilityEmerald);

    /**
     * Used for all types of durability (RF, EU, etc)
     */
    public final int durability;

    private ChiselType(int dura) {
        this.durability = dura;
    }

    private ChiselType() {
        this(100);
    }

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}

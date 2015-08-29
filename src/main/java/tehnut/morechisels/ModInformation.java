package tehnut.morechisels;

public class ModInformation {

    public static final String NAME = "More Chisels";
    public static final String ID = "morechisels";
    public static final String TEXLOC = ID + ":";
    public static final String CHANNEL = "MoreChisels";
    public static final String DEPEND = "required-after:chisel;after:SSTOW";
    public static final String VERSION = "@VERSION@";
    public static final String CLIENTPROXY = "tehnut.morechisels.proxy.ClientProxy";
    public static final String COMMONPROXY = "tehnut.morechisels.proxy.CommonProxy";
    public static final String GUIFACTORY = "tehnut.morechisels.client.gui.ConfigGuiFactory";
}

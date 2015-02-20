package tehnut.morechisels.proxies;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;
import tehnut.morechisels.util.EventHandler;

public class ClientProxy extends CommonProxy {

    @Override
    public void load() {
        FMLCommonHandler.instance().bus().register(new EventHandler.ClientEventHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler.ClientEventHandler());
    }
}

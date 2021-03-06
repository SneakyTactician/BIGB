package sneaky.bigb.event;

import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import sneaky.bigb.bigstorage.gui.AccessUnitGUI;
import sneaky.bigb.chat.ChatUtil;
import sneaky.bigb.compat.CompatModuleManager;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.main.Reference;
import sneaky.bigb.main.Util;
import sneaky.bigbproxies.ClientProxy;
import codechicken.nei.LayoutManager;
import codechicken.nei.VisiblityData;
import codechicken.nei.api.API;
import codechicken.nei.api.LayoutStyle;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.LoadFromFile;
import net.minecraftforge.event.entity.player.PlayerEvent.StartTracking;
import net.minecraftforge.event.world.WorldEvent.Load;

/**
 * @author SneakyTactician
 * This class is the event handler for this mod. It contains all events and directs Minecraft forge events towards this.
 */
public class EventHandler
{
	public void OnServerTickEvent(TickEvent event)
	{
		
	}
	
	//@SubscribeEvent
	public void OnPlayerLoggedInEvent(PlayerLoggedInEvent event)
	{

	}
	
	@Mod.EventHandler
	public void OnFMLServerStartedEvent(FMLServerStartedEvent event)
	{
		
	}
	
	@SubscribeEvent
	public void OnGUIOpen(GuiOpenEvent event)
	{
		
	}
	
	@SubscribeEvent
	public void OnLoadEvent(Load event)
	{
		
	}
	
	@SubscribeEvent
	public void OnLoadFromFile(LoadFromFile event)
	{
		this.LaunchClientSideCode(event.entityPlayer);
		Util.world = event.entity.worldObj;
	}
	
	/**
	 * Kicks the client proxy off to start launching client side code.
	 */
	public void LaunchClientSideCode(EntityPlayer player)
	{
		LogHelper.info("Checking for updates!");
		ClientProxy a;
		a = new ClientProxy();
		a.CheckForUpdates(player);
		a.RunClientSideCode();
	}
}
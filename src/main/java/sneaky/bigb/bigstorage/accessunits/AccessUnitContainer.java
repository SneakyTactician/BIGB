package sneaky.bigb.bigstorage.accessunits;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import sneaky.bigb.gui.GUIUtils;
import sneaky.bigb.gui.ScreenResolutionHandler;

/**
 * @author SneakyTactician
 * Controls the actual slots and stuff of the access unit.
 */
public class AccessUnitContainer extends Container
{
	
	public final IInventory Storage;
	public int InventorySize;
	public InventoryPlayer PlayerInv;
	
	/**
	 * The constructor for the AccessUnitContainer class.
	 */
	public AccessUnitContainer(InventoryPlayer PlayerInventory, TileEntityAccessUnit Inv) //http://jabelarminecraft.blogspot.com/p/minecraft-modding-containers.html
	{
		this.Storage = Inv;
		this.PlayerInv = PlayerInventory;
		this.ConstructPlayerInventory();
		this.ConstructBIGInventory();
	}
	
	/**
	 * Adds slots to the top part of the Access Unit.
	 */
	public void ConstructBIGInventory()
	{
        int YVal = ScreenResolutionHandler.GetYValueForAccessUnitContainerHotBars();
        
        int i;
		//Adds player inventory slots
        for (i = 0; i < 6; ++i)
        {
        	double b = 480;
        	double c = 3.45;
        	double a = b / c;
        	int d = (int) Math.round(a);
            for (int j = 0; j < 9; ++j)
            {
            	//New Slot(PlayerInventory, int SlotIndex, int X, int Y
            	switch (i)
            	{
            	case 0:
            		//Row 1
                    addSlotToContainer(new Slot(Storage, j+i*9+9, 8+j*18,  (((GUIUtils.GetSHeight() / 80) - 19))));
            		break;
            	case 1:
            		//Row 2
                    addSlotToContainer(new Slot(Storage, j+i*9+9, 8+j*18,  (((GUIUtils.GetSHeight() / 80) - 1))));
            		break;
            	case 2:
            		//Row 3
            		addSlotToContainer(new Slot(Storage, j+i*9+9, 8+j*18,  (((GUIUtils.GetSHeight() / 80) + 17))));
            		break;
            	case 3:
            		//Row 4
                    addSlotToContainer(new Slot(Storage, j+i*9+9, 8+j*18,  (((GUIUtils.GetSHeight() / 80) + 35))));
            		break;
            	case 4:
            		//Row 5
            		addSlotToContainer(new Slot(Storage, j+i*9+9, 8+j*18,  (((GUIUtils.GetSHeight() / 80) + 53))));
            		break;
            	case 5:
            		//Row 6
                    addSlotToContainer(new Slot(Storage, j+i*9+9, 8+j*18,  (((GUIUtils.GetSHeight() / 80) + 71))));
                    break;
            	}
            }
        }
	}
	
	/**
	 * Adds slots and the hotbar into the GUI for this container.
	 */
	public void ConstructPlayerInventory()
	{
        int YVal = ScreenResolutionHandler.GetYValueForAccessUnitContainerHotBars();
        
        int i;
		//Adds player inventory slots
        for (i = 0; i < 3; ++i)
        {
        	double b = 480;
        	double c = 3.45;
        	double a = b / c;
        	int d = (int) Math.round(a);
            for (int j = 0; j < 9; ++j)
            {
            	//New Slot(PlayerInventory, int SlotIndex, int X, int Y
            	switch (i)
            	{
            	case 0:
            		//Middle row
                    addSlotToContainer(new Slot(this.PlayerInv, j+i*9+9, 8+j*18, ((GUIUtils.GetSHeight() / 80) + d) - 36));
            		break;
            	case 1:
            		//Bottom row
                    addSlotToContainer(new Slot(this.PlayerInv, j+i*9+9, 8+j*18,  ((GUIUtils.GetSHeight() / 80) + d) - 18));
            		break;
            	case 2:
            		//Top row
                    addSlotToContainer(new Slot(this.PlayerInv, j+i*9+9, 8+j*18,  ((GUIUtils.GetSHeight() / 80) + (d))));
            		break;
            	}
            }
        }
        
        // add hotbar slots
        for (i = 0; i < 9; ++i)
        {
            addSlotToContainer(new Slot(this.PlayerInv, i, 8 + i * 18, YVal));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
	
    @Override
    public void addCraftingToCrafters(ICrafting listener)
    {
        super.addCraftingToCrafters(listener);
    }
	
    /**
     * Looks for changes made in the container, sends them to every listener.
     */
/*    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        
        //Might need to implement this. Don't understand it yet.
    }
   */
    
  //Don't understand this yet
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int slotIndex)
    {
        ItemStack itemStack1 = null;
        Slot slot = (Slot)inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack2 = slot.getStack();
            itemStack1 = itemStack2.copy();

            if (itemStack2.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemStack2.stackSize == itemStack1.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemStack2);
        }

        return itemStack1;
    }
}
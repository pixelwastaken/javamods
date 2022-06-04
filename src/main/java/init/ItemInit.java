package init;

import com.example.eitem.ElliotItems;

import items.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import util.ModItemTier;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, ElliotItems.MOD_ID);
	public static final RegistryObject<Item> SMILE = ITEMS.register("smile",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));
	public static final RegistryObject<Item> SMILE_SWORD = ITEMS.register("smile_sword",
            () -> new SwordItem(ModItemTier.SMILE_S, 3, -2.4F, new Item.Properties().tab(ModCreativeTab.instance)));
	public static final RegistryObject<Item> SMILER = ITEMS.register("smiler",
            () -> new Smiler(new Item.Properties().tab(ModCreativeTab.instance)));
	public static final RegistryObject<Item> SMILE_PICKER = ITEMS.register("smile_picker",
            () -> new SmilePicker(new Item.Properties().tab(ModCreativeTab.instance)));
	public static final RegistryObject<Item> LIGHTNING_ITEM = ITEMS.register("lightning_item",
			() -> new LightningItem(new Item.Properties().tab(ModCreativeTab.instance)));
	public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench",
			() -> new Wrench(new Item.Properties().tab(ModCreativeTab.instance)));
	public static class ModCreativeTab extends CreativeModeTab {
	    private ModCreativeTab(int index, String label) {
	        super(index, label);
	    }
	    @Override
	    public ItemStack makeIcon() {
	        return new ItemStack(SMILE.get());
	    }
	    public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "eitem");
	}
}

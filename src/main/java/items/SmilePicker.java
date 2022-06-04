package items;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

import java.util.ArrayList;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;

public class SmilePicker extends Item {

	public SmilePicker(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ClipContext.Fluid cc = ClipContext.Fluid.NONE;
		BlockHitResult ray = getPlayerPOVHitResult(world, player, cc);
		BlockPos lookPos = ray.getBlockPos();
		Block block = world.getBlockState(lookPos).getBlock();
		if (block != Blocks.AIR) {
			if (block != Smiler.blockChosen) {
				Smiler.blockChosen = block;
				player.sendMessage((Component) new TextComponent("You picked " + this.makeFormal(block)), player.getUUID());
			}
		} else {
			Smiler.blockChosen = null;
			player.sendMessage((Component) new TextComponent("Reseted!"), player.getUUID());
		}
	    return super.use(world, player, hand);
	}
	private String fin;
	public String makeFormal(Block block_p) {
		String strBlock = block_p.getRegistryName().toString();
		char[] blockArr = new char[strBlock.length()];
		if (strBlock.contains("minecraft:"))
			strBlock = strBlock.replace("minecraft:", "");
		if (strBlock.contains("eitem:"))
			strBlock = strBlock.replace("eitem:", "");
		strBlock = strBlock.replace("_", " ");
		System.out.println(strBlock + " is str");
		for (int c = 0; c < strBlock.length(); c++) {
			blockArr[c] = strBlock.charAt(c);
		}
		System.out.println(new String(blockArr) + " is ba");
		for (int ct = 0; ct < blockArr.length; ct++) {
			if (ct == 0) {
				String c = Character.toString(blockArr[ct]).toUpperCase();
				blockArr[ct] = c.toCharArray()[0];
			} else if (blockArr[ct - 1] == ' ') {
				String c = Character.toString(blockArr[ct]).toUpperCase();
				blockArr[ct] = c.toCharArray()[0];
			}
			
		}
		ArrayList<Character> alcBlock = new ArrayList<Character>();
		for (int ct = 0; ct < blockArr.length; ct++) {
			if (blockArr[ct] != 0x00)
				alcBlock.add(blockArr[ct]);
		}
		fin = "";
		alcBlock.forEach((item) -> {
			fin = fin + item.toString();
		});
		return fin;
	}
}

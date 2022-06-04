package items;


import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Smiler extends Item{
	public static Block blockChosen;
	public Smiler(Properties properties) {
		super(properties);
	}
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ClipContext.Fluid cc = ClipContext.Fluid.NONE;
		BlockHitResult ray = getPlayerPOVHitResult(world, player, cc);
		BlockPos lookPos = ray.getBlockPos();
		//BlockState bs = world.getBlockState(lookPos);
		if (blockChosen != null)
			world.setBlock(lookPos, blockChosen.defaultBlockState(), 1);
	    return super.use(world, player, hand);
	}
}

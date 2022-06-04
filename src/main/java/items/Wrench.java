package items;

import java.util.ArrayList;

import init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;



public class Wrench extends Item {
	private int tries = 0;
	public ArrayList<Connection> pairs = new ArrayList<Connection>();
	public Wrench(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		BlockPos block1 = null;
		BlockPos block2 = null;
		if (hand == InteractionHand.MAIN_HAND) {
			tries++;
			if (tries == 1) {
				ClipContext.Fluid cc = ClipContext.Fluid.NONE;
				BlockHitResult ray = getPlayerPOVHitResult(world, player, cc);
				block1 = ray.getBlockPos();
			} else {
				ClipContext.Fluid cc = ClipContext.Fluid.NONE;
				BlockHitResult ray = getPlayerPOVHitResult(world, player, cc);
				block2 = ray.getBlockPos();
				tries = 0;
				if (BlockInit.getBlock(world, block1) == BlockInit.TELEPORTER.get() && BlockInit.getBlock(world, block2) == BlockInit.TELEPORTER.get()) {
					pairs.add(new Connection(block1, block2));
				}
				System.out.println(pairs.get(0).blockPosA + " " + pairs.get(0).blockPosB);
			}
			
		}
		return super.use(world, player, hand);
	}
	public class Connection {
		public BlockPos blockPosA;
		public BlockPos blockPosB;
		public Connection(BlockPos blockA, BlockPos blockB) {
			this.blockPosA = blockA;
			this.blockPosB = blockB;
		}
	}

}

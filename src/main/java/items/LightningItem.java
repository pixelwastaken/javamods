package items;



import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;



public class LightningItem extends Item {
	public LightningItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ClipContext.Fluid cc = ClipContext.Fluid.NONE;
		BlockHitResult ray = getPlayerPOVHitResult(world, player, cc);
		LightningBolt LB = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
		LB.moveTo(new Vec3(ray.getBlockPos().getX(), ray.getBlockPos().getY(), ray.getBlockPos().getZ()));
		world.addFreshEntity(LB);
	    return super.use(world, player, hand);
	    
	}
}


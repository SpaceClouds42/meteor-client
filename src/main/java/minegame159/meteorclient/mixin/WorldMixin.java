package minegame159.meteorclient.mixin;

import minegame159.meteorclient.mixininterface.IWorld;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.World;
import net.minecraft.world.chunk.BlockEntityTickInvoker;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.List;

@Mixin(World.class)
public abstract class WorldMixin implements IWorld{
    @Shadow
    @Final
    protected List<BlockEntityTickInvoker> blockEntityTickers;

    @Override
    public List<BlockEntity> getBlockEntities() {
        ArrayList<BlockEntity> blockEntities = new ArrayList<>();
        World world = (World) (Object) this;
        for (BlockEntityTickInvoker blockEntityTickInvoker: blockEntityTickers) {
            blockEntities.add(world.getBlockEntity(blockEntityTickInvoker.getPos()));
        }
        return blockEntities;
    }
}

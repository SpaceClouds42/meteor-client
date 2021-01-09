package minegame159.meteorclient.mixin;

import minegame159.meteorclient.utils.world.IWorld;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.chunk.BlockEntityTickInvoker;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.Supplier;

@Mixin(World.class)
public abstract class WorldMixin implements IWorld{
    @Shadow
    @Final
    protected List<BlockEntityTickInvoker> blockEntityTickers;

    @Override
    public List<BlockEntity> getBlockEntities() {
        List<BlockEntity> blockEntities = List.of();
        World world = (World) (Object) this;
        for (BlockEntityTickInvoker blockEntityTickInvoker: blockEntityTickers) {
            blockEntities.add(world.getBlockEntity(blockEntityTickInvoker.getPos()));
        }
        return blockEntities;
    }

    @Final
    @Shadow
    public long seed;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void World(MutableWorldProperties properties, RegistryKey<World> registryRef, final DimensionType dimensionType, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long seed, CallbackInfo ci) {
            System.out.println("World seed: " + seed);
    }

}
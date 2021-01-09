package minegame159.meteorclient.mixininterface;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.chunk.BlockEntityTickInvoker;

import java.util.List;

public interface IWorld {
    List<BlockEntity> getBlockEntities();
}

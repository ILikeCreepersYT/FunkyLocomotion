package com.rwtema.funkylocomotion.api;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public interface IAdvStickyBlock {
	Iterable<BlockPos> getBlocksToMove(World world, BlockPos pos);
}

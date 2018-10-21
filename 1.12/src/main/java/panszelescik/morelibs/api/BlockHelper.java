package panszelescik.morelibs.api;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockHelper {
	
	public static int MAX_ID = 1024;
	public static byte[] rotateType = new byte[MAX_ID];
	public static final byte[] SIDE_LEFT = { 4, 5, 5, 4, 2, 3 };
	public static final byte[] SIDE_OPPOSITE = { 1, 0, 3, 2, 5, 4 };
	
	public static final class RotationType {
		public static final int STAIRS = 1;
		public static final int SLAB = 2;
		public static final int CHEST = 3;
		
		private RotationType() {}
	}
	
	static {
		rotateType[getId(Blocks.STONE_SLAB)] = RotationType.SLAB;
		rotateType[getId(Blocks.WOODEN_SLAB)] = RotationType.SLAB;
		rotateType[getId(Blocks.STONE_SLAB2)] = RotationType.SLAB;
		rotateType[getId(Blocks.PURPUR_SLAB)] = RotationType.SLAB;
		
		rotateType[getId(Blocks.TRAPPED_CHEST)] = RotationType.CHEST;
		rotateType[getId(Blocks.CHEST)] = RotationType.CHEST;
		
		rotateType[getId(Blocks.OAK_STAIRS)] = RotationType.STAIRS;
		rotateType[getId(Blocks.STONE_STAIRS)] = RotationType.STAIRS;
		rotateType[getId(Blocks.BRICK_STAIRS)] = RotationType.STAIRS;
		rotateType[getId(Blocks.STONE_BRICK_STAIRS)] = RotationType.STAIRS;
		rotateType[getId(Blocks.NETHER_BRICK_STAIRS)] = RotationType.STAIRS;
		rotateType[getId(Blocks.SANDSTONE_STAIRS)] = RotationType.STAIRS;
		rotateType[getId(Blocks.SPRUCE_STAIRS)] = RotationType.STAIRS;
		rotateType[getId(Blocks.BIRCH_STAIRS)] = RotationType.STAIRS;
		rotateType[getId(Blocks.JUNGLE_STAIRS)] = RotationType.STAIRS;
		rotateType[getId(Blocks.QUARTZ_STAIRS)] = RotationType.STAIRS;
		rotateType[getId(Blocks.RED_SANDSTONE_STAIRS)] = RotationType.STAIRS;
		rotateType[getId(Blocks.PURPUR_STAIRS)] = RotationType.STAIRS;
	}
	
	public static boolean isEqual(Block blockA, Block blockB) {
		if (blockA == blockB)
			return true;
		if (blockA == null | blockB == null)
			return false;
		return blockA.equals(blockB) || blockA.isAssociatedBlock(blockB);
	}
	
	public static boolean canRotate(Block block) {
		int id = getId(block);
		return id < MAX_ID && rotateType[id] != 0;
	}
	
	public static IBlockState rotateVanillaBlock(World world, IBlockState state, BlockPos pos) {
		int bId = getId(state.getBlock()), bMeta = state.getBlock().getMetaFromState(state);
		Block block = state.getBlock();
		switch (rotateType[bId]) {
			case RotationType.STAIRS:
				return block.getStateFromMeta(++bMeta % 8);
			case RotationType.SLAB:
				return block.getStateFromMeta((bMeta + 8) % 16);
			case RotationType.CHEST:
				BlockPos offsetPos;
				for (EnumFacing facing : EnumFacing.HORIZONTALS) {
					offsetPos = pos.offset(facing);
					if (isEqual(world.getBlockState(offsetPos).getBlock(), state.getBlock())) {
						world.setBlockState(offsetPos, state.getBlock().getStateFromMeta(SIDE_OPPOSITE[bMeta]), 1);
						return block.getStateFromMeta(SIDE_OPPOSITE[bMeta]);
					}
				}
				return block.getStateFromMeta(SIDE_LEFT[bMeta]);
			default:
				return block.getStateFromMeta(bMeta);
		}
	}
	
	private static int getId(Block block) {
		return Block.getIdFromBlock(block);
	}
	
	public static boolean startWith(Block block, String name) {
		return block.getRegistryName().toString().startsWith(name);
	}
}
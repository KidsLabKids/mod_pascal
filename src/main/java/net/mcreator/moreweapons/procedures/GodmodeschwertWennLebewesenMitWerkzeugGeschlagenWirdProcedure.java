package net.mcreator.moreweapons.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.block.Blocks;

import net.mcreator.moreweapons.MoreWeaponsMod;

import java.util.Map;

public class GodmodeschwertWennLebewesenMitWerkzeugGeschlagenWirdProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MoreWeaponsMod.LOGGER.warn("Failed to load dependency x for procedure GodmodeschwertWennLebewesenMitWerkzeugGeschlagenWird!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MoreWeaponsMod.LOGGER.warn("Failed to load dependency y for procedure GodmodeschwertWennLebewesenMitWerkzeugGeschlagenWird!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MoreWeaponsMod.LOGGER.warn("Failed to load dependency z for procedure GodmodeschwertWennLebewesenMitWerkzeugGeschlagenWird!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MoreWeaponsMod.LOGGER.warn("Failed to load dependency world for procedure GodmodeschwertWennLebewesenMitWerkzeugGeschlagenWird!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			FallingBlockEntity blockToSpawn = new FallingBlockEntity((World) world, x, y, z, Blocks.ANVIL.getDefaultState());
			blockToSpawn.fallTime = 1;
			world.addEntity(blockToSpawn);
		}
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
	}
}

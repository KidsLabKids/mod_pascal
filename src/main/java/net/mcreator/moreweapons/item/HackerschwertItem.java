
package net.mcreator.moreweapons.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.mcreator.moreweapons.procedures.HackerschwertWennLebewesenMitWerkzeugGeschlagenWirdProcedure;
import net.mcreator.moreweapons.MoreWeaponsModElements;

import java.util.Map;
import java.util.HashMap;

@MoreWeaponsModElements.ModElement.Tag
public class HackerschwertItem extends MoreWeaponsModElements.ModElement {
	@ObjectHolder("more_weapons:hackerschwert")
	public static final Item block = null;
	public HackerschwertItem(MoreWeaponsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 160;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 6;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2f, new Item.Properties().group(ItemGroup.TOOLS).isImmuneToFire()) {
			@Override
			public boolean hasContainerItem() {
				return true;
			}

			@Override
			public ItemStack getContainerItem(ItemStack itemstack) {
				return new ItemStack(this);
			}

			@Override
			public boolean isRepairable(ItemStack itemstack) {
				return false;
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					HackerschwertWennLebewesenMitWerkzeugGeschlagenWirdProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("hackerschwert"));
	}
}

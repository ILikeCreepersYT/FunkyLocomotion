package com.rwtema.funkylocomotion;

import com.rwtema.funkylocomotion.items.ItemBlockTeleporter;
import com.rwtema.funkylocomotion.items.ItemWrench;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;

import static net.minecraftforge.oredict.RecipeSorter.Category.SHAPELESS;

public class Recipes {
	public static boolean shouldAddRecipes;
	public static boolean shouldAddFrameCopyResetRecipes;

	public static void addRecipes() {
	    /* FIXME/TODO 1.12 update
		for (String s : OreDictionary.getOreNames()) {
			if (s.startsWith("ingot"))
				LogHelper.info(s);
		}

		if (shouldAddRecipes) {
			Object lapis = "gemLapis";
			Object gearEnderium = getOreWithVanillaFallback(Blocks.PISTON, "thermalexpansion:machineFrame", "itemMachineChassi");
			Object diamond = "gemDiamond";
			Object nuggetSignalum = getOreWithVanillaFallback("dustRedstone", "nuggetSignalum", "itemRedstoneAlloy");
			Object ingotInvar = getOreWithVanillaFallback("ingotIron", "ingotInvar");
			Object IngotInvarIron = getOreWithVanillaFallback("ingotIron", "ingotInvar", "ingotSteel");
			Object nuggetInvar = getOreWithVanillaFallback("stickWood", "nuggetInvar", "nuggetIron");
			Object nuggetIron = getOreWithVanillaFallback("stickWood", "nuggetIron");
			Object nuggetEnderium = getOreWithVanillaFallback(Items.ENDER_EYE, "nuggetEnderium", "ingotPulsatingIron");
			Object dustEnderium = getOreWithVanillaFallback(Items.ENDER_PEARL, "dustEnderium", "nuggetPulsatingIron");
			Object ingotElectrum = getOreWithVanillaFallback("ingotGold", "ingotElectrum", "ingotVibrantAlloy");
			Object dustGlowstone = getOreWithVanillaFallback("dustGlowstone", "ingotEnergeticAlloy");

			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FunkyLocomotion.frame[0], 8, 0), "III", "i i", "III", 'I', ingotInvar, 'i', nuggetInvar));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FunkyLocomotion.wrench, 1, ItemWrench.metaWrenchNormal), "I  ", " i ", "  I", 'I', "ingotIron", 'i', nuggetIron));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(FunkyLocomotion.wrench, 1, ItemWrench.metaWrenchEye), Items.ENDER_EYE, dustEnderium, dustEnderium, new ItemStack(FunkyLocomotion.wrench, 1, ItemWrench.metaWrenchNormal)));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FunkyLocomotion.wrench, 1, ItemWrench.metaWrenchHammer), "WIW", " i ", " i ", 'I', IngotInvarIron, 'W', new ItemStack(FunkyLocomotion.wrench, 1, ItemWrench.metaWrenchNormal), 'i', "ingotIron"));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FunkyLocomotion.pusher, 1, 0), "EEE", "CGC", "CTC", 'E', nuggetEnderium, 'G', gearEnderium, 'C', ingotInvar, 'T', diamond));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(FunkyLocomotion.pusher, 1, 1), new ItemStack(FunkyLocomotion.pusher, 1, 0), "slimeball", "dustRedstone", "dustRedstone", "dustRedstone"));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(FunkyLocomotion.slider, 1, 0), new ItemStack(FunkyLocomotion.pusher, 1, 0), nuggetSignalum, lapis, lapis, lapis));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FunkyLocomotion.booster, 1, 0), "EEE", "CGC", "CTC", 'E', ingotElectrum, 'G', gearEnderium, 'C', ingotInvar, 'T', FunkyLocomotion.pusher));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FunkyLocomotion.frameProjector, 1, 0), "EEE", "CGC", "CTC", 'E', dustGlowstone, 'G', gearEnderium, 'C', ingotInvar, 'T', new ItemStack(FunkyLocomotion.pusher, 1, 1)));


			addCustomRecipe(new ShapedOreRecipe(
					ItemBlockTeleporter.assignNullID(new ItemStack(FunkyLocomotion.teleporter, 2)),
					"EEE", "PNY", "EEE",
					'E', nuggetEnderium,
					'P', new ItemStack(FunkyLocomotion.pusher, 1, 0),
					'N', Items.ENDER_PEARL,
					'Y', new ItemStack(FunkyLocomotion.pusher, 1, 1)
			) {
				@Override
				public ItemStack getCraftingResult(InventoryCrafting var1) {
					return ItemBlockTeleporter.assignRandomID(super.getCraftingResult(var1));
				}
			});

			addCustomRecipe(new ShapelessOreRecipe(
					ItemBlockTeleporter.assignNullID(new ItemStack(FunkyLocomotion.teleporter, 2)),
					FunkyLocomotion.teleporter, FunkyLocomotion.teleporter
			) {
				@Override
				public ItemStack getCraftingResult(InventoryCrafting var1) {
					return ItemBlockTeleporter.assignRandomID(super.getCraftingResult(var1));
				}
			});
		}

		if (shouldAddFrameCopyResetRecipes) {
			ItemStack basicFrame = new ItemStack(FunkyLocomotion.frame[0], 1, 0);
			ArrayList<ItemStack> list = new ArrayList<>(64);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 16; j++) {
					if (i != 0 || j != 0) {
						ItemStack stack = new ItemStack(FunkyLocomotion.frame[i], 1, j);
						list.add(stack);

						GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(FunkyLocomotion.frame[i], 2, j), stack, basicFrame));
					}
				}
			}

			ShapelessOreRecipe t = new ShapelessOreRecipe(FunkyLocomotion.frame[0], new ItemStack(FunkyLocomotion.frame[0]));
			t.getInput().clear();
			t.getInput().add(list);

			GameRegistry.addRecipe(t);
		}
		*/
	}

	/* FIXME/TODO 1.12 update
	public static Object getOreWithVanillaFallback(Object vanillaFallback, String... moddedOre) {
		for (String modOre : moddedOre) {
			if (OreDictionary.getOres(modOre).size() > 0)
				return modOre;
		}
		return vanillaFallback;
	}

	public static void addCustomRecipe(IRecipe recipe) {
		GameRegistry.addRecipe(recipe);
		RecipeSorter.register("funky:recipe:" + recipe.getClass().getName(), recipe.getClass(), SHAPELESS, "");
	}
	*/
}

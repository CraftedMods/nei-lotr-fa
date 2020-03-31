/*******************************************************************************
 * Copyright (C) 2020 CraftedMods (see https://github.com/CraftedMods)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package craftedMods.lotr.fa.recipes;

import java.util.*;

import craftedMods.lotr.fa.recipes.recipeHandlers.*;
import craftedMods.lotr.recipes.api.utils.LOTRRecipeHandlerUtils;
import craftedMods.recipes.api.*;
import eoa.lotrfa.common.FARecipes;
import eoa.lotrfa.common.block.table.*;
import eoa.lotrfa.common.entity.LOTRFATrades;
import eoa.lotrfa.common.entity.npc.anfauglith.*;
import eoa.lotrfa.common.entity.npc.angband.LOTRFAEntityAngbandTrader;
import eoa.lotrfa.common.entity.npc.belegost.LOTRFAEntityBelegostGoldsmith;
import eoa.lotrfa.common.entity.npc.bor.*;
import eoa.lotrfa.common.entity.npc.brethil.*;
import eoa.lotrfa.common.entity.npc.doriath.*;
import eoa.lotrfa.common.entity.npc.dorlomin.*;
import eoa.lotrfa.common.entity.npc.dornadaerachas.LOTRFAEntityDorNaDaerachasTrader;
import eoa.lotrfa.common.entity.npc.falathrim.*;
import eoa.lotrfa.common.entity.npc.feanorian.*;
import eoa.lotrfa.common.entity.npc.gondolin.*;
import eoa.lotrfa.common.entity.npc.hithlum.*;
import eoa.lotrfa.common.entity.npc.laegrim.*;
import eoa.lotrfa.common.entity.npc.nargothrond.*;
import eoa.lotrfa.common.entity.npc.nogrod.LOTRFAEntityNogrodStonemason;
import eoa.lotrfa.common.entity.npc.pettydwarf.LOTRFAEntityPettyDwarfSmith;
import eoa.lotrfa.common.entity.npc.tolingaurhoth.*;
import eoa.lotrfa.common.entity.npc.tormentedelf.*;
import eoa.lotrfa.common.entity.npc.ulfang.*;
import lotr.common.entity.npc.*;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.crafting.IRecipe;

@RegisteredHandler
public class IntegratedRecipeHandlerFactory implements RecipeHandlerFactory {

	private static final String FACTION_ANGBAND = "angband";
	private static final String FACTION_BELEGOST = "belegost";
	private static final String FACTION_BOR = "bor";
	private static final String FACTION_BRETHIL = "brethil";
	private static final String FACTION_DORIATH = "doriath";
	private static final String FACTION_ANFAUGLITH = "anfauglith";
	private static final String FACTION_DOR_NA_DAERACHAS = "dorNaDaerachas";
	private static final String FACTION_DOR_LOMIN = "dorLomin";
	private static final String FACTION_FALATHRIM = "falathrim";
	private static final String FACTION_FEANORIAN = "feanorian";
	private static final String FACTION_GONDOLIN = "gondolin";
	private static final String FACTION_HITHLUM = "hithlum";
	private static final String FACTION_LAEGRIM = "laegrim";
	private static final String FACTION_NARGOTHROND = "nargothrond";
	private static final String FACTION_NOGROD = "nogrod";
	private static final String FACTION_PETTY_DWARF = "pettyDwarf";
	private static final String FACTION_TOL_IN_GAURHOTH = "tolInGaurhoth";
	private static final String FACTION_TORMENTED_ELF = "tormentedElf";
	private static final String FACTION_ULFANG = "ulfang";

	private static final Set<RecipeHandler<?>> recipeHandlers = new HashSet<>();

	static {
		// FA crafting tables
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_ANGBAND, LOTRBlockTableAngband.Gui.class,
				FARecipes.angbandRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_BRETHIL, LOTRBlockTableBrethil.Gui.class,
				FARecipes.brethilRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_DOR_NA_DAERACHAS, LOTRBlockTableDorNaDaerachas.Gui.class,
				FARecipes.dorNaDaerachasRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_DORIATH, LOTRBlockTableDoriath.Gui.class,
				FARecipes.doriathRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_DOR_LOMIN, LOTRBlockTableDorLomin.Gui.class,
				FARecipes.dorLominRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_FALATHRIM, LOTRBlockTableFalathrim.Gui.class,
				FARecipes.falathrimRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_FEANORIAN, LOTRBlockTableFeanorian.Gui.class,
				FARecipes.feanorianRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_GONDOLIN, LOTRBlockTableGondolin.Gui.class,
				FARecipes.gondolinRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_HITHLUM, LOTRBlockTableHithlum.Gui.class,
				FARecipes.hithlumRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("houseBor", LOTRBlockTableHouseBor.Gui.class, FARecipes.houseBorRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler("houseUlfang", LOTRBlockTableHouseUlfang.Gui.class, FARecipes.houseUlfangRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_LAEGRIM, LOTRBlockTableLaegrim.Gui.class,
				FARecipes.laegrimRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_NARGOTHROND, LOTRBlockTableNargothrond.Gui.class,
				FARecipes.nargothrondRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_PETTY_DWARF, LOTRBlockTablePettyDwarven.Gui.class,
				FARecipes.pettyDwarvenRecipes);
		IntegratedRecipeHandlerFactory.registerFACTHandler(IntegratedRecipeHandlerFactory.FACTION_TOL_IN_GAURHOTH, LOTRBlockTolInGaurhothTable.Gui.class,
				FARecipes.tolInGaurhothRecipes);

		// FA traders
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityAngbandTrader.class, IntegratedRecipeHandlerFactory.FACTION_ANGBAND,
				LOTRFATrades.angband_trader_sell, LOTRFATrades.angband_trader_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityBelegostGoldsmith.class, IntegratedRecipeHandlerFactory.FACTION_BELEGOST,
				LOTRFATrades.belegost_goldsmith_sell, LOTRFATrades.belegost_goldsmith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityBorBartender.class, IntegratedRecipeHandlerFactory.FACTION_BOR,
				LOTRFATrades.bor_bartender_sell, LOTRFATrades.bor_bartender_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityBorFarmer.class, IntegratedRecipeHandlerFactory.FACTION_BOR,
				LOTRFATrades.bor_farmer_sell, LOTRFATrades.bor_farmer_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityBorGreengrocer.class, IntegratedRecipeHandlerFactory.FACTION_BOR,
				LOTRFATrades.bor_greengrocer_sell, LOTRFATrades.bor_greengrocer_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityBorBlacksmith.class, IntegratedRecipeHandlerFactory.FACTION_BOR,
				LOTRFATrades.bor_smith_sell, LOTRFATrades.bor_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityBorBaker.class, IntegratedRecipeHandlerFactory.FACTION_BOR,
				LOTRTradeEntries.DALE_BAKER_SELL, LOTRTradeEntries.DALE_BAKER_BUY);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityBrethilButcher.class, IntegratedRecipeHandlerFactory.FACTION_BRETHIL,
				LOTRFATrades.brethil_butcher_sell, LOTRFATrades.brethil_butcher_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityBrethilLumberman.class, IntegratedRecipeHandlerFactory.FACTION_BRETHIL,
				LOTRFATrades.brethil_lumberman_sell, LOTRFATrades.brethil_lumberman_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityBrethilSmith.class, IntegratedRecipeHandlerFactory.FACTION_BRETHIL,
				LOTRFATrades.brethil_smith_sell, LOTRFATrades.brethil_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityDoriathBaker.class, IntegratedRecipeHandlerFactory.FACTION_DORIATH,
				LOTRFATrades.doriath_baker_sell, LOTRFATrades.doriath_baker_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityDoriathHuntsman.class, IntegratedRecipeHandlerFactory.FACTION_DORIATH,
				LOTRFATrades.doriath_huntsman_sell, LOTRFATrades.doriath_huntsman_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityDoriathLumberman.class, IntegratedRecipeHandlerFactory.FACTION_DORIATH,
				LOTRFATrades.doriath_lumberman_sell, LOTRFATrades.doriath_lumberman_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityDoriathSmith.class, IntegratedRecipeHandlerFactory.FACTION_DORIATH,
				LOTRFATrades.doriath_smith_sell, LOTRFATrades.doriath_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityAnfauglithHuntsman.class, IntegratedRecipeHandlerFactory.FACTION_ANFAUGLITH,
				LOTRFATrades.anfauglith_huntsman_sell, LOTRFATrades.anfauglith_huntsman_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityAnfauglithScavenger.class, IntegratedRecipeHandlerFactory.FACTION_ANFAUGLITH,
				LOTRFATrades.anfauglith_scavenger_sell, LOTRFATrades.anfauglith_scavenger_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityAnfauglithTrader.class, IntegratedRecipeHandlerFactory.FACTION_ANFAUGLITH,
				LOTRFATrades.anfauglith_trader_sell, LOTRFATrades.anfauglith_trader_buy);

		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityDorNaDaerachasTrader.class, IntegratedRecipeHandlerFactory.FACTION_DOR_NA_DAERACHAS,
				LOTRFATrades.dor_na_daerachas_trader_sell, LOTRFATrades.dor_na_daerachas_trader_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityDorLominBrewer.class, IntegratedRecipeHandlerFactory.FACTION_DOR_LOMIN,
				LOTRFATrades.dor_lomin_brewer_sell, LOTRFATrades.dor_lomin_brewer_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityDorLominFarmer.class, IntegratedRecipeHandlerFactory.FACTION_DOR_LOMIN,
				LOTRFATrades.dor_lomin_farmer_sell, LOTRFATrades.dor_lomin_farmer_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityDorLominSmith.class, IntegratedRecipeHandlerFactory.FACTION_DOR_LOMIN,
				LOTRFATrades.dor_lomin_smith_sell, LOTRFATrades.dor_lomin_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityDorLominBartender.class, IntegratedRecipeHandlerFactory.FACTION_DOR_LOMIN,
				LOTRTradeEntries.GONDOR_BARTENDER_SELL, LOTRTradeEntries.GONDOR_BARTENDER_BUY);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityFalathrimSmith.class, IntegratedRecipeHandlerFactory.FACTION_FALATHRIM,
				LOTRFATrades.falathrim_smith_sell, LOTRFATrades.falathrim_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityFalathrimLumberman.class, IntegratedRecipeHandlerFactory.FACTION_FALATHRIM,
				LOTRFATrades.falathrim_lumberman_sell, LOTRFATrades.falathrim_lumberman_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityFalathrimFishmonger.class, IntegratedRecipeHandlerFactory.FACTION_FALATHRIM,
				LOTRTradeEntries.GONDOR_FISHMONGER_SELL, LOTRTradeEntries.GONDOR_FISHMONGER_BUY);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityFeanorianSmith.class, IntegratedRecipeHandlerFactory.FACTION_FEANORIAN,
				LOTRFATrades.feanorian_smith_sell, LOTRFATrades.feanorian_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityFeanorianStablemaster.class, IntegratedRecipeHandlerFactory.FACTION_FEANORIAN,
				LOTRFATrades.feanorian_stablemaster_sell, LOTRFATrades.feanorian_stablemaster_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityGondolinFlorist.class, IntegratedRecipeHandlerFactory.FACTION_GONDOLIN,
				LOTRFATrades.gondolin_florist_sell, LOTRFATrades.gondolin_florist_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityGondolinSmith.class, IntegratedRecipeHandlerFactory.FACTION_GONDOLIN,
				LOTRFATrades.gondolin_smith_sell, LOTRFATrades.gondolin_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityGondolinStonemason.class, IntegratedRecipeHandlerFactory.FACTION_GONDOLIN,
				LOTRFATrades.gondolin_stonemason_sell, LOTRFATrades.gondolin_stonemason_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityHithlumFlorist.class, IntegratedRecipeHandlerFactory.FACTION_HITHLUM,
				LOTRFATrades.hithlum_florist_sell, LOTRFATrades.hithlum_florist_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityHithlumGreengrocer.class, IntegratedRecipeHandlerFactory.FACTION_HITHLUM,
				LOTRFATrades.hithlum_greengrocer_sell, LOTRFATrades.hithlum_greengrocer_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityHithlumVinekeeper.class, IntegratedRecipeHandlerFactory.FACTION_HITHLUM,
				LOTRFATrades.hithlum_vinekeeper_sell, LOTRFATrades.hithlum_vinekeeper_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityHithlumVintnerElf.class, IntegratedRecipeHandlerFactory.FACTION_HITHLUM,
				LOTRTradeEntries.DORWINION_VINTNER_SELL, LOTRFATrades.hithlum_vintner_elf_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityHithlumSmith.class, IntegratedRecipeHandlerFactory.FACTION_HITHLUM,
				LOTRFATrades.hithlum_smith_sell, LOTRFATrades.hithlum_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityLaegrimFlorist.class, IntegratedRecipeHandlerFactory.FACTION_LAEGRIM,
				LOTRFATrades.laegrim_florist_sell, LOTRFATrades.laegrim_florist_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityLaegrimHuntsman.class, IntegratedRecipeHandlerFactory.FACTION_LAEGRIM,
				LOTRFATrades.laegrim_huntsman_sell, LOTRFATrades.laegrim_huntsman_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityLaegrimLumberman.class, IntegratedRecipeHandlerFactory.FACTION_LAEGRIM,
				LOTRFATrades.laegrim_lumberman_sell, LOTRFATrades.laegrim_lumberman_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityLaegrimSmith.class, IntegratedRecipeHandlerFactory.FACTION_LAEGRIM,
				LOTRFATrades.laegrim_smith_sell, LOTRFATrades.laegrim_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityNargothrondGoldsmith.class, IntegratedRecipeHandlerFactory.FACTION_NARGOTHROND,
				LOTRFATrades.nargothrond_goldsmith_sell, LOTRFATrades.nargothrond_goldsmith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityNargothrondStonemason.class, IntegratedRecipeHandlerFactory.FACTION_NARGOTHROND,
				LOTRFATrades.nargothrond_stonemason_sell, LOTRFATrades.nargothrond_stonemason_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityNargothrondTrader.class, IntegratedRecipeHandlerFactory.FACTION_NARGOTHROND,
				LOTRTradeEntries.RIVENDELL_TRADER_SELL, LOTRTradeEntries.RIVENDELL_TRADER_BUY);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityNargothrondSmith.class, IntegratedRecipeHandlerFactory.FACTION_NARGOTHROND,
				LOTRFATrades.nargothrond_smith_sell, LOTRFATrades.nargothrond_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityNogrodStonemason.class, IntegratedRecipeHandlerFactory.FACTION_NOGROD,
				LOTRFATrades.nogrod_stonemason_sell, LOTRFATrades.nogrod_stonemason_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityPettyDwarfSmith.class, IntegratedRecipeHandlerFactory.FACTION_PETTY_DWARF,
				LOTRFATrades.petty_dwarf_smith_sell, LOTRFATrades.petty_dwarf_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityTolInGaurhothTrader.class, IntegratedRecipeHandlerFactory.FACTION_TOL_IN_GAURHOTH,
				LOTRFATrades.tol_in_gaurhoth_trader_sell, LOTRFATrades.tol_in_gaurhoth_trader_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityTolInGaurhothLumberman.class, IntegratedRecipeHandlerFactory.FACTION_TOL_IN_GAURHOTH,
				LOTRFATrades.tol_in_gaurhoth_lumberman_sell, LOTRFATrades.tol_in_gaurhoth_lumberman_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityTormentedElfSmith.class, IntegratedRecipeHandlerFactory.FACTION_TORMENTED_ELF,
				LOTRFATrades.tormented_elf_smith_sell, LOTRFATrades.tormented_elf_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityTormentedElfStonemason.class, IntegratedRecipeHandlerFactory.FACTION_TORMENTED_ELF,
				LOTRFATrades.tormented_elf_stonemason_sell, LOTRFATrades.tormented_elf_stonemason_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityUlfangBrewer.class, IntegratedRecipeHandlerFactory.FACTION_ULFANG,
				LOTRFATrades.ulfang_brewer_sell, LOTRFATrades.ulfang_brewer_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityUlfangButcher.class, IntegratedRecipeHandlerFactory.FACTION_ULFANG,
				LOTRFATrades.ulfang_butcher_sell, LOTRFATrades.ulfang_butcher_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityUlfangHuntsman.class, IntegratedRecipeHandlerFactory.FACTION_ULFANG,
				LOTRFATrades.ulfang_huntsman_sell, LOTRFATrades.ulfang_huntsman_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityUlfangLumberman.class, IntegratedRecipeHandlerFactory.FACTION_ULFANG,
				LOTRFATrades.ulfang_lumberman_sell, LOTRFATrades.ulfang_lumberman_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityUlfangSmith.class, IntegratedRecipeHandlerFactory.FACTION_ULFANG,
				LOTRFATrades.ulfang_smith_sell, LOTRFATrades.ulfang_smith_buy);
		IntegratedRecipeHandlerFactory.registerTraderHandler(LOTRFAEntityUlfangBartender.class, IntegratedRecipeHandlerFactory.FACTION_ULFANG,
				LOTRTradeEntries.DUNLENDING_BARTENDER_SELL, LOTRTradeEntries.DUNLENDING_BARTENDER_BUY);

		// FA alloy forges
		IntegratedRecipeHandlerFactory.recipeHandlers
				.add(new FAAlloyForgeRecipeHandler("pettyDwarven", new FAAlloyForgeRecipeHandler.PettyDwarvenAlloyForgeAccess()));
	}

	private static void registerFACTHandler(String unlocalizedName, Class<? extends GuiContainer> guiClass, Collection<IRecipe> recipes) {
		IntegratedRecipeHandlerFactory.recipeHandlers.add(new FACraftingTableRecipeHandler(unlocalizedName, guiClass, () -> recipes));
	}

	private static void registerTraderHandler(Class<? extends LOTRTradeable> entityClass, String faction, LOTRTradeEntries itemsBought,
			LOTRTradeEntries itemsSold) {
		IntegratedRecipeHandlerFactory.recipeHandlers.add(new FATraderRecipeHandler(
				LOTRRecipeHandlerUtils.getUnlocalizedEntityName(entityClass).replaceAll("lotrfa.", ""), faction, itemsBought, itemsSold));
	}

	@Override
	public Set<RecipeHandler<?>> getRecipeHandlers() {
		return IntegratedRecipeHandlerFactory.recipeHandlers;
	}

}

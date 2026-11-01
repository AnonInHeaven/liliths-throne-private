package com.lilithsthrone.game.combat.v2;

import com.lilithsthrone.game.combat.Combat;
import com.lilithsthrone.game.combat.LegacyCombatEngine;
import com.lilithsthrone.utils.colours.PresetColour;

/**
 * Redesigned combat engine (initiative, telegraphed intents, affinities, reactions). See <code>.ai/plan/feature/combat-redesign.md</code>.
 * <br/><br/>
 * <b>Phase 0:</b> this is a placeholder which still runs the legacy rules, so that the engine toggle can be exercised end-to-end.
 * Each subsequent phase replaces an inherited hook with v2 behaviour.
 * <br/><br/>
 * Enabled via the debug menu's "Combat engine" toggle ({@link com.lilithsthrone.game.PropertyValue#combatEngineV2}).
 *
 * @since 0.4.12
 * @version 0.4.12
 */
public class CombatEngineV2 extends LegacyCombatEngine {

	public CombatEngineV2(Combat combat) {
		super(combat);
	}

	@Override
	public String getName() {
		return "v2 (experimental)";
	}

	@Override
	public String getCombatContentPrefix() {
		return "<div class='container-full-width' style='text-align:center; padding:4px; box-sizing:border-box;'>"
					+ "<span style='color:"+PresetColour.GENERIC_ARCANE.toWebHexString()+";'>Combat engine: "+getName()+"</span>"
				+ "</div>";
	}
}

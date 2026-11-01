package com.lilithsthrone.game.combat;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.dialogue.DialogueNode;

/**
 * The original combat rules (simultaneous AP-based move queueing, DEFEND -> SPELL -> ATTACK resolution, flat shielding).
 * The implementation still lives inside {@link Combat}; this adapter only routes the {@link CombatEngine} hooks to it.
 *
 * @since 0.4.12
 * @version 0.4.12
 */
public class LegacyCombatEngine implements CombatEngine {

	protected final Combat combat;

	public LegacyCombatEngine(Combat combat) {
		this.combat = combat;
	}

	@Override
	public String getName() {
		return "Legacy";
	}

	@Override
	public void onCombatInitialised() {
		combat.prepareFirstTurnLegacy();
	}

	@Override
	public DialogueNode getCombatNode() {
		return combat.ENEMY_ATTACK;
	}

	@Override
	public void endCombatTurn() {
		combat.endCombatTurnLegacy();
	}

	@Override
	public boolean isCombatantDefeated(GameCharacter character) {
		return character.getHealth() <= 0 || (character.getLust()>=100 && character.isVulnerableToLustLoss());
	}
}

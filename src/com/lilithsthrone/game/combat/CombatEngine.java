package com.lilithsthrone.game.combat;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.dialogue.DialogueNode;

/**
 * The rules engine behind a single fight. {@link Combat} remains the public facade (<code>Main.combat</code>) and owns the
 * shared session state (combatants, targets, thrown weapons, post-combat dialogue hooks), while the engine owns turn flow,
 * move resolution, and defeat rules.
 * <br/><br/>
 * A new engine instance is created by {@link Combat#initialiseCombat} for every fight, so implementations may keep per-fight state.
 *
 * @since 0.4.12
 * @version 0.4.12
 */
public interface CombatEngine {

	/**
	 * @return A short identifier for debugging/UI purposes.
	 */
	public String getName();

	/**
	 * Called at the end of {@link Combat#initialiseCombat}, after combatants, targets and opening descriptions have been set up.
	 * Responsible for marking the game as in combat and preparing the first turn (resources, NPC move selection, predictions).
	 */
	public void onCombatInitialised();

	/**
	 * @return The dialogue node which combat starts on (returned by {@link Combat#startCombat()}).
	 */
	public DialogueNode getCombatNode();

	/**
	 * Resolves the current turn and prepares the next one.
	 */
	public void endCombatTurn();

	/**
	 * @return true if this character has been knocked out of the fight.
	 */
	public boolean isCombatantDefeated(GameCharacter character);

	/**
	 * Called at the end of {@link Combat#endCombat(boolean)}, after victory/defeat processing.
	 */
	public default void onCombatEnded(boolean playerVictory) {
	}

	/**
	 * @return HTML inserted at the top of the main combat content panel. Empty by default.
	 */
	public default String getCombatContentPrefix() {
		return "";
	}
}

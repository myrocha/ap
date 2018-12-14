package br.com.appiddog.util;

/**
 * Class to open activities from any part of the code.
 */
public enum IntentActions {
    MAIN_ACTIVITY("br.com.appiddog.view.activity.MAIN_ACTIVTY"),
    DOG_ACTIVITY("br.com.appiddog.view.activity.DOG_ACTIVITY");



    private final String action;

    /**
     * Default constructor
     *
     * @param action
     */
    IntentActions(final String action) {
        this.action = action;
    }

    /**
     * Returns the current action
     *
     * @return
     */
    public String getAction() {
        return action;
    }
}
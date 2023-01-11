package tondeuse;

public enum Action {
    LEFT('G'), RIGHT('D'), FORWARD('A');

    private final Character value;
    Action(Character value) {
        this.value  = value;
    }

    public static Action fromValue(Character value) {
        for (Action action : Action.values()) {
            if (action.value.equals(value)) {
                return action;
            }
        }
        return null;
    }
}

package finalClasses.gameConsole.sealed;

public sealed abstract class SpecialAbstractClass permits FinalKid, NonSealedKid, SealedKid, SpecialAbstractClass.Kid {

    //nested class doesn't need to be in permits (only works if this is only extending class from sealed)
    final class Kid extends SpecialAbstractClass{

    }

}

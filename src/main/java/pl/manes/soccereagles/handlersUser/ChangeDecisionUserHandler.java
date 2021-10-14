package pl.manes.soccereagles.handlersUser;

import pl.manes.soccereagles.inputUser.MasterUserCommand;

public class ChangeDecisionUserHandler extends BasicCommandUserHandler{

    private static final String COMMAND_NAME = "change";
    @Override
    protected Object getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void interceptionUser(MasterUserCommand command) {
        
        switch (command.getAction()){

            case "changeDecision" :

                // logika, która wyświetla listę z confirmedUsers
                // logika, ktora wyświetla list z declinedUsers

                //z tej wyświetlone listy odejmujemy usera poprez WPISANIE jego imienia/Nicka - robi to dam User
                // i aktualizuje listę zarówno jedną jak i drugą

        }
    }
}

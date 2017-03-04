package com.javarush.test.level23.lesson06.task02;

import static com.javarush.test.level23.lesson06.task02.Solution.Constants.*;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    final public static class Constants{

        static final String SERVERNOTACC = "Server is not accessible for now.";
        static final String USERNOTAUT = "User is not authorized.";
        static final String USERBANNED = "User is banned.";
        static final String ACCESSDEN = "Access is denied.";

    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(SERVERNOTACC);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(SERVERNOTACC);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(USERNOTAUT);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(USERNOTAUT, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(USERBANNED);
        }

        public BannedUserException(Throwable cause) {
            super(USERBANNED, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(ACCESSDEN);
        }

        public RestrictionException(Throwable cause) {
            super(ACCESSDEN, cause);
        }
    }
}

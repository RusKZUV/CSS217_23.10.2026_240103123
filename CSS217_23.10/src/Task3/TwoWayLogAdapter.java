package Task3;

public class TwoWayLogAdapter implements ModernConsole, LegacyPrinter {

    private ModernConsole modern = new ModernConsole() {
        public void logMessage(String tag, String body) {
            System.out.println("[" + tag + "] " + body);
        }
    };

    private LegacyPrinter legacy = new LegacyPrinter() {
        public void printLine(String combinedText) {
            System.out.println(combinedText);
        }
    };

    public void logMessage(String tag, String body) {
        String combined = "[" + tag + "] " + body;
        legacy.printLine(combined);
    }


    public void printLine(String combinedText) {
        if (combinedText.startsWith("[") && combinedText.contains("]")) {
            int closingBracket = combinedText.indexOf("]");
            String tag = combinedText.substring(1, closingBracket);
            String body = combinedText.substring(closingBracket + 2);
            modern.logMessage(tag, body);
        } else {
            modern.logMessage("Unknown", combinedText);
        }
    }
}
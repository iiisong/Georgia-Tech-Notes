import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
* Creates Party.
*
* @author iiisong
* @version 1.0.0
*/
public class Party {
    /**
     * Recruits Party.
     *
     * @param filename input file with party info
     * @return arraylist of partymember
     * @throws FileNotFoundException when file not found
     */
    public static ArrayList<PartyMember> recruitParty(String filename) throws FileNotFoundException {
        ArrayList<PartyMember> party = new ArrayList<>();

        if (filename == null) {
            throw new FileNotFoundException(String.format("%s file not found", filename));
        }

        File file = new File(filename);

        // throws exception if file doesn't exist
        if (!file.exists()) {
            throw new FileNotFoundException(String.format("%s file not found", filename));
        }

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            // check not empty line
            if (line.equals("")) {
                continue;
            }

            party.add(processInfo(line));
            // System.out.println(party.get(party.size() - 1));
        }

        return party;
    }

    /**
     * Converts String into Party Member.
     *
     * @param line member info line
     * @return PartyMember
     * @throws InvalidPartyMemberException no such class
     */
    private static PartyMember processInfo(String line) throws InvalidPartyMemberException {
        String[] ss = line.split(","); // stats string
        for (int i = 0; i < ss.length; i++) {
            ss[i] = ss[i].split(" ")[ss[i].split(" ").length - 1];
        }

        switch (ss[0]) {
        case "Warrior":
            return new Warrior(ss[1], // characterName (string)
                                Integer.parseInt(ss[2]), // health (int)
                                Integer.parseInt(ss[3]), // baseAttack (int)
                                ss[4], // weapon (string)
                                Integer.parseInt(ss[5]) // armorClass (int)
                                );

        case "Mage":
            return new Mage(ss[1], // characterName (string)
            Integer.parseInt(ss[2]), // health (int)
            Integer.parseInt(ss[3]), // baseAttack (int)
            Integer.parseInt(ss[4]), // spell attack (int)
            Integer.parseInt(ss[5]) // spell slots (int)
            );

        default:
            throw new InvalidPartyMemberException(
                        String.format("the party shall not pass! no such class %s exists", ss[0]));
        }
    }

    /**
     * Writes party members to file.
     *
     * @param filename name of file to write to
     * @param members arraylist of members
     * @return successfully written or not
     */
    public static boolean partyRoster(String filename, ArrayList<PartyMember> members) {
        try {
            if (filename == null) {
                System.out.println("File name cannot be null");
                return false;
            }

            PrintWriter output = new PrintWriter(filename);

            for (PartyMember member : members) {
                output.println(member);
            }

            output.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * Read/Modify/Write quest file on whether party beat quest.
     *
     * @param questName specified quest
     * @param party ArrayList of PartyMembers
     * @return party successfully beat quest
     * @throws FileNotFoundException quest.csv not found
     * @throws QuestNotFoundException specified quest not in quest.csv
     * @throws IOException reading writing error
     */
    public static boolean getQuest(String questName, ArrayList<PartyMember> party)
                    throws FileNotFoundException, QuestNotFoundException, IOException {

        File file = new File("quest.csv");

        // throws exception if file doesn't exist
        if (!file.exists()) {
            throw new FileNotFoundException("quest.csv file not found");
        }

        boolean foundQuest = false;
        boolean success = false;
        ArrayList<String> quests = new ArrayList<>();

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            // check not empty line
            if (line.equals("")) {
                continue;
            }

            String[] qInfo = line.split(":");

            // found quest
            if (qInfo[0].equals(questName)) {
                foundQuest = true;

                // quest level < party quest level
                if (Integer.parseInt(qInfo[1].split(",")[0].strip()) < partyQuestLevel(party)) {
                    System.out.printf("Success! Your party gained %s coins. This calls for a trip to the Tavern!\n",
                                        qInfo[1].split(",")[1].strip());
                    success = true;
                    continue;
                }

                // quest level >= party quest level
                System.out.println("Failure... Your party was defeated. Better Luck Next Time!");
            }

            quests.add(line);
        }

        // no quest found
        if (!foundQuest) {
            throw new QuestNotFoundException(String.format("%s quest not found", questName));
        }

        PrintWriter output = new PrintWriter("quest.csv");

        for (String q : quests) {
            output.println(q);
        }

        output.close();

        return success;
    }

    /**
     * Private calculate party quest level.
     *
     * @param party ArrayList of Party
     * @return quest level
     */
    private static int partyQuestLevel(ArrayList<PartyMember> party) {
        int sum = 0;

        if (party == null || party.size() == 0) {
            return -1;
        }

        for (PartyMember pm : party) {
            sum += pm.questLevel();
        }

        System.out.println(sum);
        return sum;
    }

    /**
     * Main.
     *
     * @param args console in
     * @throws FileNotFoundException file not found
     */
    public static void main(String[] args) throws FileNotFoundException, QuestNotFoundException, IOException {
        // recruitParty(null);
        // for (PartyMember pm : recruitParty("TestMembersClean.csv")) {
        //     System.out.println(pm.toString());
        // }

        // recruitParty(null);
        //partyRoster("filename", recruitParty("TestMembersClean.csv"));


        String name = null;

        try {
            System.out.println(name.length());
        } catch (NullPointerException e) {
            System.out.println("jk we good");
        }


        getQuest("End Game", recruitParty("TestMembersClean.csv"));
    }
}

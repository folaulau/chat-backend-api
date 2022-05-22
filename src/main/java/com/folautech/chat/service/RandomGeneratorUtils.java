package com.folautech.chat.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * @author fkaveinga
 * @see RandomStringUtils
 * @see RandomUtils
 */
public final class RandomGeneratorUtils {

  private static List<String> specialCharacters =
      Arrays.asList("@", "#", "$", "%", "!", "^", "&", "*", "()", "\"", "_", ",", "~", "`", "-",
          "=", "[", "]", "{", "}", "|", ";", ":", "'", ",", ".", "/", "<", ">", "?");

  public static String getString(int length) {
    return RandomStringUtils.randomAlphabetic(length);
  }

  public static int getInteger() {
    return RandomUtils.nextInt();
  }

  public static int getIntegerWithin(int start, int end) {
    return RandomUtils.nextInt(start, end);
  }

  public static Float getFloat() {
    return RandomUtils.nextFloat();
  }

  public static Float getIntegerWithin(float start, float end) {
    return RandomUtils.nextFloat(start, end);
  }

  public static Double getDouble() {
    return RandomUtils.nextDouble();
  }

  public static Double getDoubleWithin(double start, double end) {
    return RandomUtils.nextDouble(start, end);
  }

  public static long getLongWithin(long start, long end) {
    return RandomUtils.nextLong(start, end);
  }

  public static long getLong() {
    return RandomUtils.nextLong();
  }

  public static String getAlphaNumeric(int length) {
    return RandomStringUtils.randomAlphanumeric(length);
  }

  public static String getJWTId() {
    return UUID.randomUUID().toString() + "-" + RandomStringUtils.randomAlphabetic(10);
  }

  public static String getAwsS3FileKey(String fileName) {
    // TODO Auto-generated method stub
    return UUID.randomUUID().toString() + "-" + fileName;
  }

  public static String getRandomEmail() {
    // TODO Auto-generated method stub
    return getRandomEmail(null);
  }

  public static String getRandomEmail(String name) {
    // TODO Auto-generated method stub
    return getRandomEmail(name, null);
  }

  public static String getRandomEmail(String name, String domain) {
    StringBuilder email = new StringBuilder();

    if (null == name || name.trim().length() == 0) {
      email.append("folaudev+");
    } else {
      email.append(name);
    }

    email.append(getIntegerWithin(0, Integer.MAX_VALUE));

    if (null == domain || domain.trim().length() == 0) {
      email.append("@gmail.com");
    } else {
      email.append(domain);
    }

    return email.toString();
  }

  public static String getRandomFirstname() {
    return firstnames.get(RandomGeneratorUtils.getIntegerWithin(0, firstnames.size() - 1));
  }

  public static String getRandomLastname() {
    return lastnames.get(RandomGeneratorUtils.getIntegerWithin(0, lastnames.size()));
  }
  
  public static String getRandomFullName() {
    return getRandomFirstname() + " " + getRandomLastname();
  }  

  public static String getRandomAboutMe(String name) {
    String aboutMe = aboutMes.get(RandomGeneratorUtils.getIntegerWithin(0, aboutMes.size()));
    return aboutMe.replace("{name}", name);
  }

  private static final List<String> aboutMes = Arrays.asList(
      "{name}, 21, dishy psychology student {name} is a dishy psychology student who finds it hard to stay out of jail. He looks trustworthy. He always carries two phones. He must use his talent for campaigning to heal the people around him before he can work on his own problems.",
      "{name}, 14, outspoken teenager. A fourteen-year-old teenager is traumatised by the loss of his co-worker when he was thirteen. He looks exhausted. He strongly dislikes sheep. He has been wrongly accused of killing his sister.",
      "{name}, 97, nosy software developer. {name} is a nosy software developer who finds it hard to trust people. He usually wears orange trousers. His biggest fear is his friends discovering that he can't laugh. His purpose in life is to protect others.",
      "{name}, 21, sarcastic soldier. A sarcastic soldier from Sweden is obsessed with envelopes. People often compare him to a sarcastic doll. His biggest fear is his friends discovering that he can't dance. He is particularly interested in learning to play musical instruments.",
      "{name}, 28, unstable merman. {name} is an unstable man from Mars who can only see at night. Physically, he is built like a truck. His biggest fear is being killed by a snake. He is striving to redeem himself after committing fraud.",
      "{name}, 27, kind shop assistant. A 27-year-old shop assistant is angry about his leaky teapot. Physically, he is built like a collection of sticks. He always carries a calculator. He is particularly interested in learning to play musical instruments.",
      "{name}, 20, greedy merman. Fin is a greedy merman who finds it hard to put himself in other people's shoes. He usually wears a bullet-proof vest. He always carries a tape measure. He is striving to redeem himself after pushing a fox under a bus.",
      "{name}, 19, colourful father. {name} is a colourful father who is addicted to Hull. He looks young for his age. His top quality is that he is particularly interesting. His purpose in life is to pursue happiness.",
      "{name}, 13, forceful teenager. A thirteen-year-old teenager is angry about violence on TV. Physically, he is built like a beanstalk. His top quality is that he is particularly polite. He must use his talent for swimming to heal the people around him before he can work on his own problems.",
      "{name}, 21, entertaining radiologist. {name} is an entertaining man from Seattle who can only swim when he is hungry. He usually wears a bullet-proof vest. His top quality is that he is particularly law-abiding. He is hiding a terrible secret concerning his relative.");

  private static final List<String> firstnames = Arrays.asList("Jacob", "Michael", "Ethan",
      "Joshua", "Daniel", "Alexander", "Anthony", "William", "Christopher", "Matthew", "Jayden",
      "Andrew", "Joseph", "David", "Noah", "Aiden", "James", "Ryan", "Logan", "John", "Nathan",
      "Elijah", "Christian", "Gabriel", "Benjamin", "Jonathan", "Tyler", "Samuel", "Nicholas",
      "Gavin", "Dylan", "Jackson", "Brandon", "Caleb", "Mason", "Angel", "Isaac", "Evan", "Jack",
      "Kevin", "Jose", "Isaiah", "Luke", "Landon", "Justin", "Lucas", "Zachary", "Jordan", "Robert",
      "Aaron", "Brayden", "Thomas", "Cameron", "Hunter", "Austin", "Adrian", "Connor", "Owen",
      "Aidan", "Jason", "Julian", "Wyatt", "Charles", "Luis", "Carter", "Juan", "Chase", "Diego",
      "Jeremiah", "Brody", "Xavier", "Adam", "Carlos", "Sebastian", "Liam", "Hayden", "Nathaniel",
      "Henry", "Jesus", "Ian", "Tristan", "Bryan", "Sean", "Cole", "Alex", "Eric", "Brian", "Jaden",
      "Carson", "Blake", "Ayden", "Cooper", "Dominic", "Brady", "Caden", "Josiah", "Kyle", "Colton",
      "Kaden", "Eli", "Miguel", "Antonio", "Parker", "Steven", "Alejandro", "Riley", "Richard",
      "Timothy", "Devin", "Jesse", "Victor", "Jake", "Joel", "Colin", "Kaleb", "Bryce", "Levi",
      "Oliver", "Oscar", "Vincent", "Ashton", "Cody", "Micah", "Preston", "Marcus", "Max",
      "Patrick", "Seth", "Jeremy", "Peyton", "Nolan", "Ivan", "Damian", "Maxwell", "Alan",
      "Kenneth", "Jonah", "Jorge", "Mark", "Giovanni", "Eduardo", "Grant", "Collin", "Gage", "Omar",
      "Emmanuel", "Trevor", "Edward", "Ricardo", "Cristian", "Nicolas", "Kayden", "George", "Jaxon",
      "Paul", "Braden", "Elias", "Andres", "Derek", "Garrett", "Tanner", "Malachi", "Conner",
      "Fernando", "Cesar", "Javier", "Miles", "Jaiden", "Alexis", "Leonardo", "Santiago",
      "Francisco", "Cayden", "Shane", "Edwin", "Hudson", "Travis", "Bryson", "Erick", "Jace",
      "Hector", "Josue", "Peter", "Jaylen", "Mario", "Manuel", "Abraham", "Grayson", "Damien",
      "Kaiden", "Spencer", "Stephen", "Edgar", "Wesley", "Shawn", "Trenton", "Jared", "Jeffrey",
      "Landen", "Johnathan", "Bradley", "Braxton", "Ryder", "Camden", "Roman", "Asher", "Brendan",
      "Maddox", "Sergio", "Israel", "Andy", "Lincoln", "Erik", "Donovan", "Raymond", "Avery",
      "Rylan", "Dalton", "Harrison", "Andre", "Martin", "Keegan", "Marco", "Jude", "Sawyer",
      "Dakota", "Leo", "Calvin", "Kai", "Drake", "Troy", "Zion", "Clayton", "Roberto", "Zane",
      "Gregory", "Tucker", "Rafael", "Kingston", "Dominick", "Ezekiel", "Griffin", "Devon", "Drew",
      "Lukas", "Johnny", "Ty", "Pedro", "Tyson", "Caiden", "Mateo", "Braylon", "Cash", "Aden",
      "Chance", "Taylor", "Marcos", "Maximus", "Ruben", "Emanuel", "Simon", "Corbin", "Brennan",
      "Dillon", "Skyler", "Myles", "Xander", "Jaxson", "Dawson", "Kameron", "Kyler", "Axel",
      "Colby", "Jonas", "Joaquin", "Payton", "Brock", "Frank", "Enrique", "Quinn", "Emilio",
      "Malik", "Grady", "Angelo", "Julio", "Derrick", "Raul", "Fabian", "Corey", "Gerardo", "Dante",
      "Ezra", "Armando", "Allen", "Theodore", "Gael", "Amir", "Zander", "Adan", "Maximilian",
      "Randy", "Easton", "Dustin", "Luca", "Phillip", "Julius", "Charlie", "Ronald", "Jakob",
      "Cade", "Brett", "Trent", "Silas", "Keith", "Emiliano", "Trey", "Jalen", "Darius", "Lane",
      "Jerry", "Jaime", "Scott", "Graham", "Weston", "Braydon", "Anderson", "Rodrigo", "Pablo",
      "Saul", "Danny", "Donald", "Elliot", "Brayan", "Dallas", "Lorenzo", "Casey", "Mitchell",
      "Alberto", "Tristen", "Rowan", "Jayson", "Gustavo", "Aaden", "Amari", "Dean", "Braeden",
      "Declan", "Chris", "Ismael", "Dane", "Louis", "Arturo", "Brenden", "Felix", "Jimmy", "Cohen",
      "Tony", "Holden", "Reid", "Abel", "Bennett", "Zackary", "Arthur", "Nehemiah", "Ricky",
      "Esteban", "Cruz", "Finn", "Mauricio", "Dennis", "Keaton", "Albert", "Marvin", "Mathew",
      "Larry", "Moises", "Issac", "Philip", "Quentin", "Curtis", "Greyson", "Jameson", "Everett",
      "Jayce", "Darren", "Elliott", "Uriel", "Alfredo", "Hugo", "Alec", "Jamari", "Marshall",
      "Walter", "Judah", "Jay", "Lance", "Beau", "Ali", "Landyn", "Yahir", "Phoenix", "Nickolas",
      "Kobe", "Bryant", "Maurice", "Russell", "Leland", "Colten", "Reed", "Davis", "Joe", "Ernesto",
      "Desmond", "Kade", "Reece", "Morgan", "Ramon", "Rocco", "Orlando", "Ryker", "Brodie",
      "Paxton", "Jacoby", "Douglas", "Kristopher", "Gary", "Lawrence", "Izaiah", "Solomon",
      "Nikolas", "Mekhi", "Justice", "Tate", "Jaydon", "Salvador", "Shaun", "Alvin", "Eddie",
      "Kane", "Davion", "Zachariah", "Dorian", "Titus", "Kellen", "Camron", "Isiah", "Javon",
      "Nasir", "Milo", "Johan", "Byron", "Jasper", "Jonathon", "Chad", "Marc", "Kelvin", "Chandler",
      "Sam", "Cory", "Deandre", "River", "Reese", "Roger", "Quinton", "Talon", "Romeo", "Franklin",
      "Noel", "Alijah", "Guillermo", "Gunner", "Damon", "Jadon", "Emerson", "Micheal", "Bruce",
      "Terry", "Kolton", "Melvin", "Beckett", "Porter", "August", "Brycen", "Dayton", "Jamarion",
      "Leonel", "Karson", "Zayden", "Keagan", "Carl", "Khalil", "Cristopher", "Nelson", "Braiden",
      "Moses", "Isaias", "Roy", "Triston", "Walker", "Kale", "Jermaine", "Leon", "Rodney",
      "Kristian", "Mohamed", "Ronan", "Pierce", "Trace", "Warren", "Jeffery", "Maverick", "Cyrus",
      "Quincy", "Nathanael", "Skylar", "Tommy", "Conor", "Noe", "Ezequiel", "Demetrius", "Jaylin",
      "Kendrick", "Frederick", "Terrance", "Bobby", "Jamison", "Jon", "Rohan", "Jett", "Kieran",
      "Tobias", "Ari", "Colt", "Gideon", "Felipe", "Kenny", "Wilson", "Orion", "Kamari", "Gunnar",
      "Jessie", "Alonzo", "Gianni", "Omari", "Waylon", "Malcolm", "Emmett", "Abram", "Julien",
      "London", "Tomas", "Allan", "Terrell", "Matteo", "Tristin", "Jairo", "Reginald", "Brent",
      "Ahmad", "Yandel", "Rene", "Willie", "Boston", "Billy", "Marlon", "Trevon", "Aydan", "Jamal",
      "Aldo", "Ariel", "Cason", "Braylen", "Javion", "Joey", "Rogelio", "Ahmed", "Dominik",
      "Brendon", "Toby", "Kody", "Marquis", "Ulises", "Armani", "Adriel", "Alfonso", "Branden",
      "Will", "Craig", "Ibrahim", "Osvaldo", "Wade", "Harley", "Steve", "Davin", "Deshawn", "Kason",
      "Damion", "Jaylon", "Jefferson", "Aron", "Brooks", "Darian", "Gerald", "Rolando", "Terrence",
      "Enzo", "Kian", "Ryland", "Barrett", "Jaeden", "Ben", "Bradyn", "Giovani", "Blaine", "Madden",
      "Jerome", "Muhammad", "Ronnie", "Layne", "Kolby", "Leonard", "Vicente", "Cale", "Alessandro",
      "Zachery", "Gavyn", "Aydin", "Xzavier", "Malakai", "Raphael", "Cannon", "Rudy", "Asa",
      "Darrell", "Giancarlo", "Elisha", "Junior", "Zackery", "Alvaro", "Lewis", "Valentin",
      "Deacon", "Jase", "Harry", "Kendall", "Rashad", "Finnegan", "Mohammed", "Ramiro", "Cedric",
      "Brennen", "Santino", "Stanley", "Tyrone", "Chace", "Francis", "Johnathon", "Teagan",
      "Zechariah", "Alonso", "Kaeden", "Kamden", "Gilberto", "Ray", "Karter", "Luciano", "Nico",
      "Kole", "Aryan", "Draven", "Jamie", "Misael", "Lee", "Alexzander", "Camren", "Giovanny",
      "Amare", "Rhett", "Rhys", "Rodolfo", "Nash", "Markus", "Deven", "Mohammad", "Moshe",
      "Quintin", "Dwayne", "Memphis", "Atticus", "Davian", "Eugene", "Jax", "Antoine", "Wayne",
      "Randall", "Semaj", "Uriah", "Clark", "Aidyn", "Jorden", "Maxim", "Aditya", "Lawson",
      "Messiah", "Korbin", "Sullivan", "Freddy", "Demarcus", "Neil", "Brice", "King", "Davon",
      "Elvis", "Ace", "Dexter", "Heath", "Duncan", "Jamar", "Sincere", "Irvin", "Remington",
      "Kadin", "Soren", "Tyree", "Damarion", "Talan", "Adrien", "Gilbert", "Keenan", "Darnell",
      "Adolfo", "Tristian", "Derick", "Isai", "Rylee", "Gauge", "Harold", "Kareem", "Deangelo",
      "Agustin", "Coleman", "Zavier", "Lamar", "Emery", "Jaydin", "Devan", "Jordyn", "Mathias",
      "Prince", "Sage", "Seamus", "Jasiah", "Efrain", "Darryl", "Arjun", "Mike", "Roland", "Conrad",
      "Kamron", "Hamza", "Santos", "Frankie", "Dominique", "Marley", "Vance", "Dax", "Jamir",
      "Kylan", "Todd", "Maximo", "Jabari", "Matthias", "Haiden", "Luka", "Marcelo", "Keon",
      "Layton", "Tyrell", "Kash", "Raiden", "Cullen", "Donte", "Jovani", "Cordell", "Kasen", "Rory",
      "Alfred", "Darwin", "Ernest", "Bailey", "Gaige", "Hassan", "Jamarcus", "Killian", "Augustus",
      "Trevin", "Zain", "Ellis", "Rex", "Yusuf", "Bruno", "Jaidyn", "Justus", "Ronin", "Humberto",
      "Jaquan", "Josh", "Kasey", "Winston", "Dashawn", "Lucian", "Matias", "Sidney", "Ignacio",
      "Nigel", "Van", "Elian", "Finley", "Jaron", "Addison", "Aedan", "Braedon", "Jadyn", "Konner",
      "Zayne", "Franco", "Niko", "Savion", "Cristofer", "Deon", "Krish", "Anton", "Brogan", "Cael",
      "Coby", "Kymani", "Marcel", "Yair", "Dale", "Bo", "Jordon", "Samir", "Darien", "Zaire",
      "Ross", "Vaughn", "Devyn", "Kenyon", "Clay", "Dario", "Ishaan", "Jair", "Kael", "Adonis",
      "Jovanny", "Clinton", "Rey", "Chaim", "German", "Harper", "Nathen", "Rigoberto", "Sonny",
      "Glenn", "Octavio", "Blaze", "Keshawn", "Ralph", "Ean", "Nikhil", "Rayan", "Sterling",
      "Branson", "Jadiel", "Dillan", "Jeramiah", "Koen", "Konnor", "Antwan", "Houston", "Tyrese",
      "Dereon", "Leonidas", "Zack", "Fisher", "Jaydan", "Quinten", "Nick", "Urijah", "Darion",
      "Jovan", "Salvatore", "Beckham", "Jarrett", "Antony", "Eden", "Makai", "Zaiden", "Broderick",
      "Camryn", "Malaki", "Nikolai", "Howard", "Immanuel", "Demarion", "Valentino", "Jovanni",
      "Ayaan", "Ethen", "Leandro", "Royce", "Yael", "Yosef", "Jean", "Marquise", "Alden", "Leroy",
      "Gaven", "Jovany", "Tyshawn", "Aarav", "Kadyn", "Milton", "Zaid", "Kelton", "Tripp", "Kamren",
      "Slade", "Hezekiah", "Jakobe", "Nathanial", "Rishi", "Shamar", "Geovanni", "Pranav",
      "Roderick", "Bentley", "Clarence", "Lyric", "Bernard", "Carmelo", "Denzel", "Maximillian",
      "Reynaldo", "Cassius", "Gordon", "Reuben", "Samson", "Yadiel", "Jayvon", "Reilly", "Sheldon",
      "Abdullah", "Jagger", "Thaddeus", "Case", "Kyson", "Lamont", "Chaz", "Makhi", "Jan",
      "Marques", "Oswaldo", "Donavan", "Keyon", "Kyan", "Simeon", "Trystan", "Andreas", "Dangelo",
      "Landin", "Reagan", "Turner", "Arnav", "Brenton", "Callum", "Jayvion", "Bridger", "Sammy",
      "Deegan", "Jaylan", "Lennon", "Odin", "Abdiel", "Jerimiah", "Eliezer", "Bronson", "Cornelius",
      "Pierre", "Cortez", "Baron", "Carlo", "Carsen", "Fletcher", "Izayah", "Kolten", "Damari",
      "Hugh", "Jensen", "Yurem", "Emma", "Isabella", "Emily", "Madison", "Ava", "Olivia", "Sophia",
      "Abigail", "Elizabeth", "Chloe", "Samantha", "Addison", "Natalie", "Mia", "Alexis", "Alyssa",
      "Hannah", "Ashley", "Ella", "Sarah", "Grace", "Taylor", "Brianna", "Lily", "Hailey", "Anna",
      "Victoria", "Kayla", "Lillian", "Lauren", "Kaylee", "Allison", "Savannah", "Nevaeh",
      "Gabriella", "Sofia", "Makayla", "Avery", "Riley", "Julia", "Leah", "Aubrey", "Jasmine",
      "Audrey", "Katherine", "Morgan", "Brooklyn", "Destiny", "Sydney", "Alexa", "Kylie", "Brooke",
      "Kaitlyn", "Evelyn", "Layla", "Madeline", "Kimberly", "Zoe", "Jessica", "Peyton", "Alexandra",
      "Claire", "Madelyn", "Maria", "Mackenzie", "Arianna", "Jocelyn", "Amelia", "Angelina",
      "Trinity", "Andrea", "Maya", "Valeria", "Sophie", "Rachel", "Vanessa", "Aaliyah", "Mariah",
      "Gabrielle", "Katelyn", "Ariana", "Bailey", "Camila", "Jennifer", "Melanie", "Gianna",
      "Charlotte", "Paige", "Autumn", "Payton", "Faith", "Sara", "Isabelle", "Caroline", "Genesis",
      "Isabel", "Mary", "Zoey", "Gracie", "Megan", "Haley", "Mya", "Michelle", "Molly", "Stephanie",
      "Nicole", "Jenna", "Natalia", "Sadie", "Jada", "Serenity", "Lucy", "Ruby", "Eva", "Kennedy",
      "Rylee", "Jayla", "Naomi", "Rebecca", "Lydia", "Daniela", "Bella", "Keira", "Adriana",
      "Lilly", "Hayden", "Miley", "Katie", "Jade", "Jordan", "Gabriela", "Amy", "Angela", "Melissa",
      "Valerie", "Giselle", "Diana", "Amanda", "Kate", "Laila", "Reagan", "Jordyn", "Kylee",
      "Danielle", "Briana", "Marley", "Leslie", "Kendall", "Catherine", "Liliana", "Mckenzie",
      "Jacqueline", "Ashlyn", "Reese", "Marissa", "London", "Juliana", "Shelby", "Cheyenne",
      "Angel", "Daisy", "Makenzie", "Miranda", "Erin", "Amber", "Alana", "Ellie", "Breanna", "Ana",
      "Mikayla", "Summer", "Piper", "Adrianna", "Jillian", "Sierra", "Jayden", "Sienna", "Alicia",
      "Lila", "Margaret", "Alivia", "Brooklynn", "Karen", "Violet", "Sabrina", "Stella", "Aniyah",
      "Annabelle", "Alexandria", "Kathryn", "Skylar", "Aliyah", "Delilah", "Julianna", "Kelsey",
      "Khloe", "Carly", "Amaya", "Mariana", "Christina", "Alondra", "Tessa", "Eliana", "Bianca",
      "Jazmin", "Clara", "Vivian", "Josephine", "Delaney", "Scarlett", "Elena", "Cadence", "Alexia",
      "Maggie", "Laura", "Nora", "Ariel", "Elise", "Nadia", "Mckenna", "Chelsea", "Lyla", "Alaina",
      "Jasmin", "Hope", "Leila", "Caitlyn", "Cassidy", "Makenna", "Allie", "Izabella", "Eden",
      "Callie", "Haylee", "Caitlin", "Kendra", "Karina", "Kyra", "Kayleigh", "Addyson", "Kiara",
      "Jazmine", "Karla", "Camryn", "Alina", "Lola", "Kyla", "Kelly", "Fatima", "Tiffany", "Kira",
      "Crystal", "Mallory", "Esmeralda", "Alejandra", "Eleanor", "Angelica", "Jayda", "Abby",
      "Kara", "Veronica", "Carmen", "Jamie", "Ryleigh", "Valentina", "Allyson", "Dakota", "Kamryn",
      "Courtney", "Cecilia", "Madeleine", "Aniya", "Alison", "Esther", "Heaven", "Aubree",
      "Lindsey", "Leilani", "Nina", "Melody", "Macy", "Ashlynn", "Joanna", "Cassandra", "Alayna",
      "Kaydence", "Madilyn", "Aurora", "Heidi", "Emerson", "Kimora", "Madalyn", "Erica", "Josie",
      "Katelynn", "Guadalupe", "Harper", "Ivy", "Lexi", "Camille", "Savanna", "Dulce", "Daniella",
      "Lucia", "Emely", "Joselyn", "Kiley", "Kailey", "Miriam", "Cynthia", "Rihanna", "Georgia",
      "Rylie", "Harmony", "Kiera", "Kyleigh", "Monica", "Bethany", "Kaylie", "Cameron", "Teagan",
      "Cora", "Brynn", "Ciara", "Genevieve", "Alice", "Maddison", "Eliza", "Tatiana", "Jaelyn",
      "Erika", "Ximena", "April", "Marely", "Julie", "Danica", "Presley", "Brielle", "Julissa",
      "Angie", "Iris", "Brenda", "Hazel", "Rose", "Malia", "Shayla", "Fiona", "Phoebe", "Nayeli",
      "Paola", "Kaelyn", "Selena", "Audrina", "Rebekah", "Carolina", "Janiyah", "Michaela",
      "Penelope", "Janiya", "Anastasia", "Adeline", "Ruth", "Sasha", "Denise", "Holly", "Madisyn",
      "Hanna", "Tatum", "Marlee", "Nataly", "Helen", "Janelle", "Lizbeth", "Serena", "Anya",
      "Jaslene", "Kaylin", "Jazlyn", "Nancy", "Lindsay", "Desiree", "Hayley", "Itzel", "Imani",
      "Madelynn", "Asia", "Kadence", "Madyson", "Talia", "Jane", "Kayden", "Annie", "Amari",
      "Bridget", "Raegan", "Jadyn", "Celeste", "Jimena", "Luna", "Yasmin", "Emilia", "Annika",
      "Estrella", "Sarai", "Lacey", "Ayla", "Alessandra", "Willow", "Nyla", "Dayana", "Lilah",
      "Lilliana", "Natasha", "Hadley", "Harley", "Priscilla", "Claudia", "Allisson", "Baylee",
      "Brenna", "Brittany", "Skyler", "Fernanda", "Danna", "Melany", "Cali", "Lia", "Macie",
      "Lyric", "Logan", "Gloria", "Lana", "Mylee", "Cindy", "Lilian", "Amira", "Anahi", "Alissa",
      "Anaya", "Lena", "Ainsley", "Sandra", "Noelle", "Marisol", "Meredith", "Kailyn", "Lesly",
      "Johanna", "Diamond", "Evangeline", "Juliet", "Kathleen", "Meghan", "Paisley", "Athena",
      "Hailee", "Rosa", "Wendy", "Emilee", "Sage", "Alanna", "Elaina", "Cara", "Nia", "Paris",
      "Casey", "Dana", "Emery", "Rowan", "Aubrie", "Kaitlin", "Jaden", "Kenzie", "Kiana", "Viviana",
      "Norah", "Lauryn", "Perla", "Amiyah", "Alyson", "Rachael", "Shannon", "Aileen", "Miracle",
      "Lillie", "Danika", "Heather", "Kassidy", "Taryn", "Tori", "Francesca", "Kristen", "Amya",
      "Elle", "Kristina", "Cheyanne", "Haylie", "Patricia", "Anne", "Samara", "Skye", "Kali",
      "America", "Lexie", "Parker", "Halle", "Londyn", "Abbigail", "Linda", "Hallie", "Saniya",
      "Bryanna", "Bailee", "Jaylynn", "Mckayla", "Quinn", "Jaelynn", "Jaida", "Caylee", "Jaiden",
      "Melina", "Abril", "Sidney", "Kassandra", "Elisabeth", "Adalyn", "Kaylynn", "Mercedes",
      "Yesenia", "Elliana", "Brylee", "Dylan", "Isabela", "Ryan", "Ashlee", "Daphne", "Kenya",
      "Marina", "Christine", "Mikaela", "Kaitlynn", "Justice", "Saniyah", "Jaliyah", "Ingrid",
      "Marie", "Natalee", "Joy", "Juliette", "Simone", "Adelaide", "Krystal", "Kennedi", "Mila",
      "Tamia", "Addisyn", "Aylin", "Dayanara", "Sylvia", "Clarissa", "Maritza", "Virginia",
      "Braelyn", "Jolie", "Jaidyn", "Kinsley", "Kirsten", "Laney", "Marilyn", "Whitney", "Janessa",
      "Raquel", "Anika", "Kamila", "Aria", "Rubi", "Adelyn", "Amara", "Ayanna", "Teresa", "Zariah",
      "Kaleigh", "Amani", "Carla", "Yareli", "Gwendolyn", "Paulina", "Nathalie", "Annabella",
      "Jaylin", "Tabitha", "Deanna", "Madalynn", "Journey", "Aiyana", "Skyla", "Yaretzi", "Ada",
      "Liana", "Karlee", "Jenny", "Myla", "Cristina", "Myah", "Lisa", "Tania", "Isis", "Jayleen",
      "Jordin", "Arely", "Azul", "Helena", "Aryanna", "Jaqueline", "Lucille", "Destinee", "Martha",
      "Zoie", "Arielle", "Liberty", "Marlene", "Elisa", "Isla", "Noemi", "Raven", "Jessie", "Aleah",
      "Kailee", "Kaliyah", "Lilyana", "Haven", "Tara", "Giana", "Camilla", "Maliyah", "Irene",
      "Carley", "Maeve", "Lea", "Macey", "Sharon", "Alisha", "Marisa", "Jaylene", "Kaya", "Scarlet",
      "Siena", "Adyson", "Maia", "Shiloh", "Tiana", "Jaycee", "Gisselle", "Yazmin", "Eve",
      "Shyanne", "Arabella", "Sherlyn", "Sariah", "Amiya", "Kiersten", "Madilynn", "Shania",
      "Aleena", "Finley", "Kinley", "Kaia", "Aliya", "Taliyah", "Pamela", "Yoselin", "Ellen",
      "Carlie", "Monserrat", "Jakayla", "Reyna", "Yaritza", "Carolyn", "Clare", "Lorelei", "Paula",
      "Zaria", "Gracelyn", "Kasey", "Regan", "Alena", "Angelique", "Regina", "Britney", "Emilie",
      "Mariam", "Jaylee", "Julianne", "Greta", "Elyse", "Lainey", "Kallie", "Felicity", "Zion",
      "Aspen", "Carlee", "Annalise", "Iliana", "Larissa", "Akira", "Sonia", "Catalina", "Phoenix",
      "Joslyn", "Anabelle", "Mollie", "Susan", "Judith", "Destiney", "Hillary", "Janet", "Katrina",
      "Mareli", "Ansley", "Kaylyn", "Alexus", "Gia", "Maci", "Elsa", "Stacy", "Kaylen", "Carissa",
      "Haleigh", "Lorena", "Jazlynn", "Milagros", "Luz", "Leanna", "Renee", "Shaniya", "Charlie",
      "Abbie", "Cailyn", "Cherish", "Elsie", "Jazmyn", "Elaine", "Emmalee", "Luciana", "Dahlia",
      "Jamya", "Belinda", "Mariyah", "Chaya", "Dayami", "Rhianna", "Yadira", "Aryana", "Rosemary",
      "Armani", "Cecelia", "Celia", "Barbara", "Cristal", "Eileen", "Rayna", "Campbell", "Amina",
      "Aisha", "Amirah", "Ally", "Araceli", "Averie", "Mayra", "Sanaa", "Patience", "Leyla",
      "Selah", "Zara", "Chanel", "Kaiya", "Keyla", "Miah", "Aimee", "Giovanna", "Amelie", "Kelsie",
      "Alisson", "Angeline", "Dominique", "Adrienne", "Brisa", "Cierra", "Paloma", "Isabell",
      "Precious", "Alma", "Charity", "Jacquelyn", "Janae", "Frances", "Shyla", "Janiah", "Kierra",
      "Karlie", "Annabel", "Jacey", "Karissa", "Jaylah", "Xiomara", "Edith", "Marianna", "Damaris",
      "Deborah", "Jaylyn", "Evelin", "Mara", "Olive", "Ayana", "India", "Kendal", "Kayley",
      "Tamara", "Briley", "Charlee", "Nylah", "Abbey", "Moriah", "Saige", "Savanah", "Giada",
      "Hana", "Lizeth", "Matilda", "Ann", "Jazlene", "Gillian", "Beatrice", "Ireland", "Karly",
      "Mylie", "Yasmine", "Ashly", "Kenna", "Maleah", "Corinne", "Keely", "Tanya", "Tianna",
      "Adalynn", "Ryann", "Salma", "Areli", "Karma", "Shyann", "Kaley", "Theresa", "Evie", "Gina",
      "Roselyn", "Kaila", "Jaylen", "Natalya", "Meadow", "Rayne", "Aliza", "Yuliana", "June",
      "Lilianna", "Nathaly", "Ali", "Alisa", "Aracely", "Belen", "Tess", "Jocelynn", "Litzy",
      "Makena", "Abagail", "Giuliana", "Joyce", "Libby", "Lillianna", "Thalia", "Tia", "Sarahi",
      "Zaniyah", "Kristin", "Lorelai", "Mattie", "Taniya", "Jaslyn", "Gemma", "Valery", "Lailah",
      "Mckinley", "Micah", "Deja", "Frida", "Brynlee", "Jewel", "Krista", "Mira", "Yamilet",
      "Adison", "Carina", "Karli", "Magdalena", "Stephany", "Charlize", "Raelynn", "Aliana",
      "Cassie", "Mina", "Karley", "Shirley", "Marlie", "Alani", "Taniyah", "Cloe", "Sanai", "Lina",
      "Nola", "Anabella", "Dalia", "Raina", "Mariela", "Ariella", "Bria", "Kamari", "Monique",
      "Ashleigh", "Reina", "Alia", "Ashanti", "Lara", "Lilia", "Justine", "Leia", "Maribel",
      "Abigayle", "Tiara", "Alannah", "Princess", "Sydnee", "Kamora", "Paityn", "Payten", "Naima",
      "Gretchen", "Heidy", "Nyasia", "Livia", "Marin", "Shaylee", "Maryjane", "Laci", "Nathalia",
      "Azaria", "Anabel", "Chasity", "Emmy", "Izabelle", "Denisse", "Emelia", "Mireya", "Shea",
      "Amiah", "Dixie", "Maren", "Averi", "Esperanza", "Micaela", "Selina", "Alyvia", "Chana",
      "Avah", "Donna", "Kaylah", "Ashtyn", "Karsyn", "Makaila", "Shayna", "Essence", "Leticia",
      "Miya", "Rory", "Desirae", "Kianna", "Laurel", "Neveah", "Amaris", "Hadassah", "Dania",
      "Hailie", "Jamiya", "Kathy", "Laylah", "Riya", "Diya", "Carleigh", "Iyana", "Kenley",
      "Sloane", "Elianna");

  private static final List<String> lastnames = Arrays.asList("Smith", "Johnson", "Williams",
      "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson", "Martinez", "Anderson",
      "Taylor", "Thomas", "Hernandez", "Moore", "Martin", "Jackson", "Thompson", "White", "Lopez",
      "Lee", "Gonzalez", "Harris", "Clark", "Lewis", "Robinson", "Walker", "Perez", "Hall", "Young",
      "Allen", "Sanchez", "Wright", "King", "Scott", "Green", "Baker", "Adams", "Nelson", "Hill",
      "Ramirez", "Campbell", "Mitchell", "Roberts", "Carter", "Phillips", "Evans", "Turner",
      "Torres", "Parker", "Collins", "Edwards", "Stewart", "Flores", "Morris", "Nguyen", "Murphy",
      "Rivera", "Cook", "Rogers", "Morgan", "Peterson", "Cooper", "Reed", "Bailey", "Bell", "Gomez",
      "Kelly", "Howard", "Ward", "Cox", "Diaz", "Richardson", "Wood", "Watson", "Brooks", "Bennett",
      "Gray", "James", "Reyes", "Cruz", "Hughes", "Price", "Myers", "Long", "Foster", "Sanders",
      "Ross", "Morales", "Powell", "Sullivan", "Russell", "Ortiz", "Jenkins", "Gutierrez", "Perry",
      "Butler", "Barnes", "Fisher", "Henderson", "Coleman", "Simmons", "Patterson", "Jordan",
      "Reynolds", "Hamilton", "Graham", "Kim", "Gonzales", "Alexander", "Ramos", "Wallace",
      "Griffin", "West", "Cole", "Hayes", "Chavez", "Gibson", "Bryant", "Ellis", "Stevens",
      "Murray", "Ford", "Marshall", "Owens", "Mcdonald", "Harrison", "Ruiz", "Kennedy", "Wells",
      "Alvarez", "Woods", "Mendoza", "Castillo", "Olson", "Webb", "Washington", "Tucker", "Freeman",
      "Burns", "Henry", "Vasquez", "Snyder", "Simpson", "Crawford", "Jimenez", "Porter", "Mason",
      "Shaw", "Gordon", "Wagner", "Hunter", "Romero", "Hicks", "Dixon", "Hunt", "Palmer",
      "Robertson", "Black", "Holmes", "Stone", "Meyer", "Boyd", "Mills", "Warren", "Fox", "Rose",
      "Rice", "Moreno", "Schmidt", "Patel", "Ferguson", "Nichols", "Herrera", "Medina", "Ryan",
      "Fernandez", "Weaver", "Daniels", "Stephens", "Gardner", "Payne", "Kelley", "Dunn", "Pierce",
      "Arnold", "Tran", "Spencer", "Peters", "Hawkins", "Grant", "Hansen", "Castro", "Hoffman",
      "Hart", "Elliott", "Cunningham", "Knight", "Bradley", "Carroll", "Hudson", "Duncan",
      "Armstrong", "Berry", "Andrews", "Johnston", "Ray", "Lane", "Riley", "Carpenter", "Perkins",
      "Aguilar", "Silva", "Richards", "Willis", "Matthews", "Chapman", "Lawrence", "Garza",
      "Vargas", "Watkins", "Wheeler", "Larson", "Carlson", "Harper", "George", "Greene", "Burke",
      "Guzman", "Morrison", "Munoz", "Jacobs", "Obrien", "Lawson", "Franklin", "Lynch", "Bishop",
      "Carr", "Salazar", "Austin", "Mendez", "Gilbert", "Jensen", "Williamson", "Montgomery",
      "Harvey", "Oliver", "Howell", "Dean", "Hanson", "Weber", "Garrett", "Sims", "Burton",
      "Fuller", "Soto", "Mccoy", "Welch", "Chen", "Schultz", "Walters", "Reid", "Fields", "Walsh",
      "Little", "Fowler", "Bowman", "Davidson", "May", "Day", "Schneider", "Newman", "Brewer",
      "Lucas", "Holland", "Wong", "Banks", "Santos", "Curtis", "Pearson", "Delgado", "Valdez",
      "Pena", "Rios", "Douglas", "Sandoval", "Barrett", "Hopkins", "Keller", "Guerrero", "Stanley",
      "Bates", "Alvarado", "Beck", "Ortega", "Wade", "Estrada", "Contreras", "Barnett", "Caldwell",
      "Santiago", "Lambert", "Powers", "Chambers", "Nunez", "Craig", "Leonard", "Lowe", "Rhodes",
      "Byrd", "Gregory", "Shelton", "Frazier", "Becker", "Maldonado", "Fleming", "Vega", "Sutton",
      "Cohen", "Jennings", "Parks", "Mcdaniel", "Watts", "Barker", "Norris", "Vaughn", "Vazquez",
      "Holt", "Schwartz", "Steele", "Benson", "Neal", "Dominguez", "Horton", "Terry", "Wolfe",
      "Hale", "Lyons", "Graves", "Haynes", "Miles", "Park", "Warner", "Padilla", "Bush", "Thornton",
      "Mccarthy", "Mann", "Zimmerman", "Erickson", "Fletcher", "Mckinney", "Page", "Dawson",
      "Joseph", "Marquez", "Reeves", "Klein", "Espinoza", "Baldwin", "Moran", "Love", "Robbins",
      "Higgins", "Ball", "Cortez", "Le", "Griffith", "Bowen", "Sharp", "Cummings", "Ramsey",
      "Hardy", "Swanson", "Barber", "Acosta", "Luna", "Chandler", "Blair", "Daniel", "Cross",
      "Simon", "Dennis", "Oconnor", "Quinn", "Gross", "Navarro", "Moss", "Fitzgerald", "Doyle",
      "Mclaughlin", "Rojas", "Rodgers", "Stevenson", "Singh", "Yang", "Figueroa", "Harmon",
      "Newton", "Paul", "Manning", "Garner", "Mcgee", "Reese", "Francis", "Burgess", "Adkins",
      "Goodman", "Curry", "Brady", "Christensen", "Potter", "Walton", "Goodwin", "Mullins",
      "Molina", "Webster", "Fischer", "Campos", "Avila", "Sherman", "Todd", "Chang", "Blake",
      "Malone", "Wolf", "Hodges", "Juarez", "Gill", "Farmer", "Hines", "Gallagher", "Duran",
      "Hubbard", "Cannon", "Miranda", "Wang", "Saunders", "Tate", "Mack", "Hammond", "Carrillo",
      "Townsend", "Wise", "Ingram", "Barton", "Mejia", "Ayala", "Schroeder", "Hampton", "Rowe",
      "Parsons", "Frank", "Waters", "Strickland", "Osborne", "Maxwell", "Chan", "Deleon", "Norman",
      "Harrington", "Casey", "Patton", "Logan", "Bowers", "Mueller", "Glover", "Floyd", "Hartman",
      "Buchanan", "Cobb", "French", "Kramer", "Mccormick", "Clarke", "Tyler", "Gibbs", "Moody",
      "Conner", "Sparks", "Mcguire", "Leon", "Bauer", "Norton", "Pope", "Flynn", "Hogan", "Robles",
      "Salinas", "Yates", "Lindsey", "Lloyd", "Marsh", "Mcbride", "Owen", "Solis", "Pham", "Lang",
      "Pratt", "Lara", "Brock", "Ballard", "Trujillo", "Shaffer", "Drake", "Roman", "Aguirre",
      "Morton", "Stokes", "Lamb", "Pacheco", "Patrick", "Cochran", "Shepherd", "Cain", "Burnett",
      "Hess", "Li", "Cervantes", "Olsen", "Briggs", "Ochoa", "Cabrera", "Velasquez", "Montoya",
      "Roth", "Meyers", "Cardenas", "Fuentes", "Weiss", "Hoover", "Wilkins", "Nicholson",
      "Underwood", "Short", "Carson", "Morrow", "Colon", "Holloway", "Summers", "Bryan", "Petersen",
      "Mckenzie", "Serrano", "Wilcox", "Carey", "Clayton", "Poole", "Calderon", "Gallegos", "Greer",
      "Rivas", "Guerra", "Decker", "Collier", "Wall", "Whitaker", "Bass", "Flowers", "Davenport",
      "Conley", "Houston", "Huff", "Copeland", "Hood", "Monroe", "Massey", "Roberson", "Combs",
      "Franco", "Larsen", "Pittman", "Randall", "Skinner", "Wilkinson", "Kirby", "Cameron",
      "Bridges", "Anthony", "Richard", "Kirk", "Bruce", "Singleton", "Mathis", "Bradford", "Boone",
      "Abbott", "Charles", "Allison", "Sweeney", "Atkinson", "Horn", "Jefferson", "Rosales", "York",
      "Christian", "Phelps", "Farrell", "Castaneda", "Nash", "Dickerson", "Bond", "Wyatt", "Foley",
      "Chase", "Gates", "Vincent", "Mathews", "Hodge", "Garrison", "Trevino", "Villarreal", "Heath",
      "Dalton", "Valencia", "Callahan", "Hensley", "Atkins", "Huffman", "Roy", "Boyer", "Shields",
      "Lin", "Hancock", "Grimes", "Glenn", "Cline", "Delacruz", "Camacho", "Dillon", "Parrish",
      "Oneill", "Melton", "Booth", "Kane", "Berg", "Harrell", "Pitts", "Savage", "Wiggins",
      "Brennan", "Salas", "Marks", "Russo", "Sawyer", "Baxter", "Golden", "Hutchinson", "Liu",
      "Walter", "Mcdowell", "Wiley", "Rich", "Humphrey", "Johns", "Koch", "Suarez", "Hobbs",
      "Beard", "Gilmore", "Ibarra", "Keith", "Macias", "Khan", "Andrade", "Ware", "Stephenson",
      "Henson", "Wilkerson", "Dyer", "Mcclure", "Blackwell", "Mercado", "Tanner", "Eaton", "Clay",
      "Barron", "Beasley", "Oneal", "Preston", "Small", "Wu", "Zamora", "Macdonald", "Vance",
      "Snow", "Mcclain", "Stafford", "Orozco", "Barry", "English", "Shannon", "Kline", "Jacobson",
      "Woodard", "Huang", "Kemp", "Mosley", "Prince", "Merritt", "Hurst", "Villanueva", "Roach",
      "Nolan", "Lam", "Yoder", "Mccullough", "Lester", "Santana", "Valenzuela", "Winters",
      "Barrera", "Leach", "Orr", "Berger", "Mckee", "Strong", "Conway", "Stein", "Whitehead",
      "Bullock", "Escobar", "Knox", "Meadows", "Solomon", "Velez", "Odonnell", "Kerr", "Stout",
      "Blankenship", "Browning", "Kent", "Lozano", "Bartlett", "Pruitt", "Buck", "Barr", "Gaines",
      "Durham", "Gentry", "Mcintyre", "Sloan", "Melendez", "Rocha", "Herman", "Sexton", "Moon",
      "Hendricks", "Rangel", "Stark", "Lowery", "Hardin", "Hull", "Sellers", "Ellison", "Calhoun",
      "Gillespie", "Mora", "Knapp", "Mccall", "Morse", "Dorsey", "Weeks", "Nielsen", "Livingston",
      "Leblanc", "Mclean", "Bradshaw", "Glass", "Middleton", "Buckley", "Schaefer", "Frost", "Howe",
      "House", "Mcintosh", "Ho", "Pennington", "Reilly", "Hebert", "Mcfarland", "Hickman", "Noble",
      "Spears", "Conrad", "Arias", "Galvan", "Velazquez", "Huynh", "Frederick", "Randolph", "Cantu",
      "Fitzpatrick", "Mahoney", "Peck", "Villa", "Michael", "Donovan", "Mcconnell", "Walls",
      "Boyle", "Mayer", "Zuniga", "Giles", "Pineda", "Pace", "Hurley", "Mays", "Mcmillan", "Crosby",
      "Ayers", "Case", "Bentley", "Shepard", "Everett", "Pugh", "David", "Mcmahon", "Dunlap",
      "Bender", "Hahn", "Harding", "Acevedo", "Raymond", "Blackburn", "Duffy", "Landry",
      "Dougherty", "Bautista", "Shah", "Potts", "Arroyo", "Valentine", "Meza", "Gould", "Vaughan",
      "Fry", "Rush", "Avery", "Herring", "Dodson", "Clements", "Sampson", "Tapia", "Bean", "Lynn",
      "Crane", "Farley", "Cisneros", "Benton", "Ashley", "Mckay", "Finley", "Best", "Blevins",
      "Friedman", "Moses", "Sosa", "Blanchard", "Huber", "Frye", "Krueger", "Bernard", "Rosario",
      "Rubio", "Mullen", "Benjamin", "Haley", "Chung", "Moyer", "Choi", "Horne", "Yu", "Woodward",
      "Ali", "Nixon", "Hayden", "Rivers", "Estes", "Mccarty", "Richmond", "Stuart", "Maynard",
      "Brandt", "Oconnell", "Hanna", "Sanford", "Sheppard", "Church", "Burch", "Levy", "Rasmussen",
      "Coffey", "Ponce", "Faulkner", "Donaldson", "Schmitt", "Novak", "Costa", "Montes", "Booker",
      "Cordova", "Waller", "Arellano", "Maddox", "Mata", "Bonilla", "Stanton", "Compton", "Kaufman",
      "Dudley", "Mcpherson", "Beltran", "Dickson", "Mccann", "Villegas", "Proctor", "Hester",
      "Cantrell", "Daugherty", "Cherry", "Bray", "Davila", "Rowland", "Levine", "Madden", "Spence",
      "Good", "Irwin", "Werner", "Krause", "Petty", "Whitney", "Baird", "Hooper", "Pollard",
      "Zavala", "Jarvis", "Holden", "Haas", "Hendrix", "Mcgrath", "Bird", "Lucero", "Terrell",
      "Riggs", "Joyce", "Mercer", "Rollins", "Galloway", "Duke", "Odom", "Andersen", "Downs",
      "Hatfield", "Benitez", "Archer", "Huerta", "Travis", "Mcneil", "Hinton", "Zhang", "Hays",
      "Mayo", "Fritz", "Branch", "Mooney", "Ewing", "Ritter", "Esparza", "Frey", "Braun", "Gay",
      "Riddle", "Haney", "Kaiser", "Holder", "Chaney", "Mcknight", "Gamble", "Vang", "Cooley",
      "Carney", "Cowan", "Forbes", "Ferrell", "Davies", "Barajas", "Shea", "Osborn", "Bright",
      "Cuevas", "Bolton", "Murillo", "Lutz", "Duarte", "Kidd", "Key", "Cooke");

}
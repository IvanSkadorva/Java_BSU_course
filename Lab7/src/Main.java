public class Main {

    public static void main(String[] args) {
        String[] paintings = {"42 sites of Fudzi",
                "Nihongo", "Samurai before their death"};
        String[] authors = {"Hacusika Hokusai", "Yamomoto Onikay"};
        ArtExhibition artExhibition = new ArtExhibition("The future of Japanese", paintings, "18.03.2021", authors);
        String[] names = {"Oleg", "Wild John", "Pikacu", "Lukashenko"};
        artExhibition.getVisitors(names);
        artExhibition.hostExhibition();
    }
}

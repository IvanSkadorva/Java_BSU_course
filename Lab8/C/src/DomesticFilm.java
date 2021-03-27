public class DomesticFilm implements  Film{
    String title;
    Double duration;
    String overview;
    Double rating = 0.0;

    @Override
    public void watch() {
        System.out.println("Let's watch a film");
    }

    public  void donate() {
        System.out.println("The future of the belarusian cinematography in our hands. Take my money");
    }

}

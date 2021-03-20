class Visitor {
    public String name;

    Visitor(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void visit() {
        System.out.println(this.name +" said, 'Not bad...'");
    }
}

public class ArtExhibition {
    public String title;
    public ArtExhibitionInfo info;

    public void hostExhibition() {
        System.out.println("The Exhibition '" + this.title +  "' has been hosted");
    }

    public void getVisitors(String[] names) {
        Visitor[] visitors = new Visitor[names.length];
        for (int i = 0; i < names.length; i++) {
            visitors[i] = new Visitor(names[i]);
            visitors[i].visit();
        }
    }

    ArtExhibition(String title, String[] paintings, String date, String[] authors) {
        this.title = title;
        this.info = new ArtExhibitionInfo(paintings, date, authors);
    }

    static class ArtExhibitionInfo {
        public String[] paintings;
        public String date;
        public String[] authors;

        ArtExhibitionInfo(String[] paintings, String date, String[] authors) {
            this.authors = authors;
            this.date = date;
            this.paintings = paintings;
        }
    }
}

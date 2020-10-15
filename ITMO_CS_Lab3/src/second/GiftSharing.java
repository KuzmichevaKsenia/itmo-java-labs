package second;

abstract class Gift {
    public abstract void buy();

    public abstract void give(String name);
}

class Postcard extends Gift {
    private String wish = "";

    public Postcard() {
    }

    public void writeWish(String wish) {
        this.wish += wish;
    }

    public String getWish() {
        return this.wish;
    }

    @Override
    public void buy() {
        System.out.println("Вы купили открытку");
    }

    @Override
    public void give(String name) {
        System.out.println(wish + ", " + name);
    }
}

class Painting extends Gift {
    private String title = "";
    private String author = "";

    public Painting() {
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void buy() {
        System.out.println("Вы купили картину");
    }

    @Override
    public void give(String name) {
        System.out.println("'" + title + "' " + author + " для " + name);
    }
}

public class GiftSharing {
    public static void main(String[] args) {
        Postcard postcard = new Postcard();
        postcard.writeWish("Поздравляю");
        System.out.println(postcard.getWish());
        postcard.buy();
        postcard.give("Роман");

        Painting painting = new Painting();
        painting.setAuthor("Леонардо да Винчи");
        painting.setTitle("Моно Лиза");
        System.out.println(painting.getAuthor());
        System.out.println(painting.getTitle());
        painting.buy();
        painting.give("Андрей");

        Gift gift = new Gift() {
            private String name;

            @Override
            public void buy() {
                System.out.println("Вы купили подарок: " + name);
            }

            @Override
            public void give(String name) {
                this.name = name;
            }
        };
        gift.give("мягкая игрушка");
        gift.buy();
    }
}